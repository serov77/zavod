package ru.solicom.zavod.controllers;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.solicom.zavod.domain.PogruzkaIK;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.domain.VagoniPoroznie;
import ru.solicom.zavod.fasade.PogruzkaService;
import ru.solicom.zavod.service.*;
import ru.solicom.zavod.util.StatusVaiona;
import ru.solicom.zavod.util.ZayavkaPoroznie;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vagon")
public class VagonController {

    @Autowired
    private VagonService vagonService;
    @Autowired
    private VagoniPoroznieService vagoniPoroznieService;
    @Autowired
    private RodVagonaService rodVagonaService;
    @Autowired
    private GruzService gruzService;
    @Autowired
    private PogruzkaService pogruzkaService;
    @Autowired
    ZayavkaService zayavkaService;
    private List<Vagon> vagonList;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listVagoniPoroznie(Model model) throws JRException, InterruptedException {
        vagonList = vagonService.vagonList();
        model.addAttribute("vagonList", vagonList);
        model.addAttribute("searchVagon", new Vagon());
        //model.addAttribute("x", request.getSession().getMaxInactiveInterval());
        return "vagon";
    }

    @RequestMapping(value = "/poroznieAll", method = RequestMethod.GET)
    public String listVagon(Model model) throws JRException, InterruptedException {
        List<VagoniPoroznie> vagoniPoroznies = vagoniPoroznieService.vagoniPoroznieList();
        model.addAttribute("vagoniPoroznieList", vagoniPoroznies);
        //model.addAttribute("searchVagon", new Vagon());
        return "vagoni_poroznie";
    }

    @RequestMapping("/search")
    public String searchVagonAll(@ModelAttribute("searchVagon") Vagon vagon, Model model) {
        vagonList = vagonService.searchVagonList(vagon.getNomerVagona());
        model.addAttribute("vagonList", vagonList);
        model.addAttribute("vagon", vagon);
        return "vagon";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addVagonGet(Model model) throws IOException {
        model.addAttribute("vagon", new Vagon());
        model.addAttribute("rodVagonaList", rodVagonaService.rodVagonaList());
        model.addAttribute("title_modal", "Добавление вагона!");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(new Vagon());
        model.addAttribute("vagonJSON", json);
        return "vagon_edit";
    }

    @RequestMapping(value = "/f", method = RequestMethod.GET)
    @ResponseBody
    public Boolean searchVagonByNomerVagona(@RequestParam String nomer, @RequestParam int id) {
        return vagonService.searchVagonByNomerVagona(nomer, id);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    /**
     * @RequestMapping(method = RequestMethod.GET, value = "/report")
     * public String generatePDFReport(Model model) throws JRException, FileNotFoundException {
     * //Map<String,Object> parameterMap = new HashMap<String,Object>();
     * //List<Vagon> usersList = vagonService.vagonList();
     * JRDataSource JRdataSource = new JRBeanCollectionDataSource(vagonList);
     * model.addAttribute("datasource", JRdataSource);
     * //modelAndView = new ModelAndView("pdfReport", parameterMap);
     * return "pdfReport";
     * }
     * @RequestMapping(method = RequestMethod.GET, value = "/report1")
     * public String generateHTMLReport(Model model) throws JRException, FileNotFoundException {
     * JRDataSource JRdataSource = new JRBeanCollectionDataSource(vagonList);
     * model.addAttribute("datasource", JRdataSource);
     * return "htmlReport";
     * }
     **/

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String vagonSave(@RequestBody String vagonJSON) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Vagon vagon = mapper.readValue(vagonJSON, Vagon.class);
        vagonService.saveVagon(vagon);
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/save_vagon_porozniy", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String vagonPorozniySave(@RequestBody String vagonPorozniyJSON) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        VagoniPoroznie vagon = mapper.readValue(vagonPorozniyJSON, VagoniPoroznie.class);
        //vagonService.saveVagon(vagon);
        int i = vagoniPoroznieService.maxNomerSvidetelstva();
        if (vagon.getGruz().getId() > 2) {
            vagon.setNomerSvidetelstva(0);
        }

        vagon.setPogruzen(false);
        vagon.setZayavka(zayavkaService.nullZayavka());
        vagoniPoroznieService.saveVagonPorozniy(vagon);
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/edit/{input}", method = RequestMethod.GET)
    public String searchVagonById(@PathVariable int input, Model model) throws IOException {
        Vagon vagon = vagonService.retriveVagon(input);
        model.addAttribute("rodVagonaList", rodVagonaService.rodVagonaList());
        model.addAttribute("vagon", vagon);
        model.addAttribute("title_modal", "Редактирование вагона!");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(vagon);
        model.addAttribute("vagonJSON", json);
        return "vagon_edit";
    }

    @RequestMapping(value = "/poroznie/{vagonId}", method = RequestMethod.GET)
    public String porozniyVagon(@PathVariable int vagonId, Model model) throws IOException, ParseException {
        Vagon vagon = vagonService.retriveVagon(vagonId);
        Boolean b = vagoniPoroznieService.statusPoroznegoVagona(vagon);
        StatusVaiona statusVaiona = pogruzkaService.searchPogruzka(vagon);
        if (statusVaiona != StatusVaiona.OK) {
            b = false;
        }
        String viewName = "vagon_porozniy_false";
        if (b) {
            VagoniPoroznie vagoniPoroznie = new VagoniPoroznie();
            vagoniPoroznie.setVagon(vagon);
            vagoniPoroznie.setGruz(gruzService.retriveGruz(1));
            vagoniPoroznie.setDataPribitiya(LocalDate.now());
            int i = vagoniPoroznieService.maxNomerSvidetelstva();
            //if (vagoniPoroznie.getGruz().getId() < 3) {
            vagoniPoroznie.setNomerSvidetelstva(i + 1);
            //} else {
            //vagoniPoroznie.setNomerSvidetelstva(0);
            //}
            model.addAttribute("vagonPorozniy", vagoniPoroznie);
            model.addAttribute("gruzList", gruzService.gruzList());
            model.addAttribute("title_modal", "Добавление вагона в список порожних.");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vagoniPoroznie);
            model.addAttribute("vagoniPoroznieJSON", json);
            viewName = "vagon_porozniy";
        }
        return viewName;
    }

    @RequestMapping(value = "/poroznie_edit/{vagonId}", method = RequestMethod.GET)
    public String porozniyVagonEdit(@PathVariable int vagonId, Model model) throws IOException, ParseException {
        VagoniPoroznie porozniy = vagoniPoroznieService.retriveVagonPorozniy(vagonId);
        model.addAttribute("vagonPorozniy", porozniy);
        model.addAttribute("gruzList", gruzService.gruzList());
        model.addAttribute("title_modal", "Редактирование вагона в списоке порожних.");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(porozniy);
        model.addAttribute("vagoniPoroznieJSON", json);
        return "vagon_porozniy";
    }

    @RequestMapping(value = "/pechat_zayavki", method = RequestMethod.POST)
    public String pechatZayavki(@RequestParam("data_zayavki") String data,  Model model) {
        //List<PogruzkaMPN> pogruzkaMPNs = new ArrayList<>();
        //Set<Pokupatel> pokupatels = new HashSet<>();
        //PogruzkaMPN pogruzkaMPN;
        //for (Integer i : list) {
        //    pogruzkaMPN = pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(i);
        //    pokupatels.add(pogruzkaMPN.getSertificatMPN().getPokupatel());
        //    pogruzkaMPNs.add(pogruzkaMPN);
        //}
        //PechatDokumentovMPN mpn = new PechatDokumentovMPN(2, 1, pogruzkaMPNs);
       // model.addAttribute("listMPN", mpn);
        //model.addAttribute("setPokupatel", pokupatels);
        //httpSession.setAttribute("listMPNSession", mpn);

        DateTimeFormatter format = DateTimeFormat.forPattern("dd.MM.yyyy");
        LocalDate lDate = new LocalDate().parse(data,format);
        int day = lDate.getDayOfYear();
        List<VagoniPoroznie> vagonList = vagoniPoroznieService.vagoniPoroznieListZayavka(lDate);
        ZayavkaPoroznie zayavkaPoroznie = new ZayavkaPoroznie(day,lDate,vagonList);
        JRDataSource jRdataSource = new JRBeanCollectionDataSource(vagonList);
        model.addAttribute("datasource", jRdataSource);
        //model.addAttribute("nomerZayavki", day);
        return "pechat_zayavki";
    }
    @RequestMapping(value = "/pechat_nomera_svidetelstv", method = RequestMethod.POST)
    public String pechatNS(Model model) {
        List<VagoniPoroznie> vagonList = vagoniPoroznieService.vagoniPoroznieIzvestList();
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(vagonList);
        model.addAttribute("datasource", jrDataSource);
        return "pechat_nomera_svidetelstv";
    }
}
