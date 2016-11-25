package ru.solicom.zavod.controllers;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.solicom.zavod.domain.*;
import ru.solicom.zavod.fasade.PogruzkaService;
import ru.solicom.zavod.service.*;
import ru.solicom.zavod.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes({"listIKSession", "listIMSession", "listMPNSession", "listMPASession"})
public class MainController {

    @Autowired
    private RodVagonaService rodVagonaService;
    @Autowired
    private VagonService vagonService;
    @Autowired
    private StationService stationService;
    @Autowired
    private PokupatelService pokupatelService;
    @Autowired
    private SertificatIKService sertificatIKService;
    @Autowired
    private SertificatIMService sertificatIMService;
    @Autowired
    private SertificatMPNService sertificatMPNService;
    @Autowired
    private SertificatMPAService sertificatMPAService;
    @Autowired
    private PogruzkaService pogruzkaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listRodVagona(Model model) {
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user = "Гость";
        if (!o.toString().equals("anonymousUser")) {
            user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getLogin();
        }
        //model.addAttribute("list", rodVagonaService.rodVagonaList());
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping(value = "/home_ajax", method = RequestMethod.GET)
    public String listRodVagonaAjax(Model model) {
        //Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //String user = "Гость";
        //if (!o.toString().equals("anonymousUser")) {
        //    user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getLogin();
        //}
        //model.addAttribute("list", rodVagonaService.rodVagonaList());
        //model.addAttribute("user", user);
        return "homeAjax";
    }

    @RequestMapping(value = "/sbit", method = RequestMethod.GET)
    public String sbitHome() {
        return "sbit_home";
    }

    @RequestMapping(value = "/valid_vagon", method = RequestMethod.GET)
    @ResponseBody
    public String searchVagonByNomerId(@RequestParam String nomerVagona, @RequestParam int id) {
        Boolean x = vagonService.searchVagonByNomerVagona(nomerVagona.trim(), id);
        return "{ \"valid\": " + x + " }";
    }

    @RequestMapping(value = "/valid_station", method = RequestMethod.GET)
    @ResponseBody
    public String searchStationByKodId(@RequestParam String kod, @RequestParam int id) {
        Boolean x = stationService.searchStationByKod(kod, id);
        return "{ \"valid\": " + x + " }";
    }

    @RequestMapping(value = "/valid_pokupatel_kod", method = RequestMethod.GET)
    @ResponseBody
    public String searchPokupatelByKodId(@RequestParam String kod, @RequestParam int id) {
        Boolean x = pokupatelService.searchPokupatelByKod(kod, id);
        return "{ \"valid\": " + x + " }";
    }

    @RequestMapping(value = "/valid_pokupatel_okpo", method = RequestMethod.GET)
    @ResponseBody
    public String searchPokupatelByOKPOId(@RequestParam String okpo, @RequestParam int id) {
        Boolean x = pokupatelService.searchRokupatelByOKPO(okpo, id);
        return "{ \"valid\": " + x + " }";
    }

    @RequestMapping(value = "/valid_sertificat_nomer/{y}", method = RequestMethod.GET)
    @ResponseBody
    public String searchSertificatByNomerID(@PathVariable String y, @RequestParam int id, @RequestParam(required = false) String data, @RequestParam String nomer) throws ParseException {
        Boolean x = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        String sd = format.format(date1);
        if (data != null) {
            sd = data;
        }
        date1 = format.parse(sd);
        LocalDate date = LocalDate.fromDateFields(date1);
        switch (y) {
            case "ik":
                x = sertificatIKService.searchSertificatIKByNomerAndGod(id, nomer, date);
                break;
            case "im":
                x = sertificatIMService.searchSertificatIMByNomerAndGod(id, nomer, date);
                break;
            case "mpn":
                x = sertificatMPNService.searchSertificatMPNByNomerAndGod(id, nomer, date);
            case "mpa":
                x = sertificatMPAService.searchSertificatMPAByNomerAndGod(id, nomer, date);
        }
        return "{ \"valid\": " + x + " }";
    }

    @RequestMapping(value = "/valid_pogruzka_netto", method = RequestMethod.GET)
    @ResponseBody
    public String validNetto(@RequestParam float taraVag, @RequestParam float brutto, @RequestParam float gruzopodyomnost) {
        Boolean x = false;
        if ((brutto - taraVag) > 0 && (gruzopodyomnost - (brutto - taraVag)) > 0) {
            x = true;
        }
        return "{ \"valid\": " + x + " }";
    }

    @RequestMapping(value = "/valid_pogruzka_mkr", method = RequestMethod.GET)
    @ResponseBody
    public String validMKR(@RequestParam int id, @RequestParam int idRV, @RequestParam int idRV_2) {
        Boolean x = false;
        if (id != 0) {
            if (idRV == 2) {
                if (idRV == idRV_2) {
                    x = true;
                } else if (pogruzkaService.searchPogruzkaMKR(id)) {
                    x = true;
                }
            } else {
                x = true;
            }
        } else {
            x = true;
        }
        return "{ \"valid\": " + x + " }";
    }

    @RequestMapping(value = "/valid_vagon_tara", method = RequestMethod.GET)
    @ResponseBody
    public String validVagonTara(@RequestParam int id, @RequestParam float gruzopodyomnost, @RequestParam float tara) {
        Boolean x = false;
        //if(id!=0) {
        if (pogruzkaService.searchPogruzka(id, gruzopodyomnost, tara)) {
            x = true;
        }
        //}
        //else {
        //    x=true;
        //}
        return "{ \"valid\": " + x + " }";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/report")
    public String generatePDFReport(Model model) throws JRException, FileNotFoundException {
        //Map<String,Object> parameterMap = new HashMap<String,Object>();
        List<Vagon> vagonList = vagonService.vagonList();
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(vagonList);
        model.addAttribute("datasource", JRdataSource);
        //ModelAndView modelAndView = new ModelAndView("pdfReport", parameterMap);
        return "pdfReport";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dokumentIK")
    public String generateDokumentIK(@ModelAttribute("listIKSession") PechatDokumentovIK listIK, Model model) throws JRException, FileNotFoundException {
        //Map<String,Object> parameterMap = new HashMap<String,Object>();
        //List<Vagon> vagonList = vagonService.vagonList();
        Collections.sort(listIK.getPogruzkaIKList(), new Comparator<PogruzkaIK>() {
            @Override
            public int compare(PogruzkaIK o1, PogruzkaIK o2) {
                return o1.getSertificatIK().getPokupatel().getName().compareTo(o2.getSertificatIK().getPokupatel().getName());
            }
        });
        //PechatDokumentovIK pechatDokumentovIK = new PechatDokumentovIK();
        //pechatDokumentovIK.setId(1);
        //pechatDokumentovIK.setPogruzkaIKList(listIK);
        //JRDataSource jRdataSource = new JRBeanCollectionDataSource(listIK);
        //ContactFactory factory = new ContactFactory();
        //List<ContactBean> beanList = factory.create();
        List<PechatDokumentovIK> dokumentovIKList = new ArrayList<>();
        dokumentovIKList.add(listIK);
        JRDataSource source = new JRBeanCollectionDataSource(dokumentovIKList);
        //model.addAttribute("datasource", new JREmptyDataSource());
        //model.addAttribute("MySubreportDataSource", jRdataSource);
        //model.addAttribute("p", jRdataSource);
        //model.addAttribute("x", listIK.size());
        //ModelAndView modelAndView = new ModelAndView("pdfReport", parameterMap);
        model.addAttribute("datasource", source);
        return "dokumentIK";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dokumentIM")
    public String generateDokumentIM(@ModelAttribute("listIMSession") PechatDokumentovIM listIM, Model model) throws JRException, FileNotFoundException {
        //Map<String,Object> parameterMap = new HashMap<String,Object>();
        //List<Vagon> vagonList = vagonService.vagonList();
        Collections.sort(listIM.getPogruzkaIMList(), new Comparator<PogruzkaIM>() {
            @Override
            public int compare(PogruzkaIM o1, PogruzkaIM o2) {
                return o1.getSertificatIM().getPokupatel().getName().compareTo(o2.getSertificatIM().getPokupatel().getName());
            }
        });
        //PechatDokumentovIM pechatDokumentovIM = new PechatDokumentovIM();
        //pechatDokumentovIM.setId(1);
        //pechatDokumentovIM.setPogruzkaIMList(listIM);
        //JRDataSource jRdataSource = new JRBeanCollectionDataSource(listIM);
        //ContactFactory factory = new ContactFactory();
        //List<ContactBean> beanList = factory.create();
        List<PechatDokumentovIM> dokumentovIMList = new ArrayList<>();
        dokumentovIMList.add(listIM);
        JRDataSource source = new JRBeanCollectionDataSource(dokumentovIMList);
        //model.addAttribute("datasource", new JREmptyDataSource());
        //model.addAttribute("MySubreportDataSource", jRdataSource);
        //model.addAttribute("p", jRdataSource);
        //model.addAttribute("x", listIK.size());
        //ModelAndView modelAndView = new ModelAndView("pdfReport", parameterMap);
        model.addAttribute("datasource", source);
        return "dokumentIM";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dokumentMPN")
    public String generateDokumentMPN(@ModelAttribute("listMPNSession") PechatDokumentovMPN listMPN, Model model) throws JRException, FileNotFoundException {
        //Map<String,Object> parameterMap = new HashMap<String,Object>();
        //List<Vagon> vagonList = vagonService.vagonList();
        Collections.sort(listMPN.getPogruzkaMPNList(), new Comparator<PogruzkaMPN>() {
            @Override
            public int compare(PogruzkaMPN o1, PogruzkaMPN o2) {
                return o1.getSertificatMPN().getPokupatel().getName().compareTo(o2.getSertificatMPN().getPokupatel().getName());
            }
        });

        //PechatDokumentovMPN pechatDokumentovMPN = new PechatDokumentovMPN();
        //pechatDokumentovMPN.setId(1);
        //pechatDokumentovMPN.setPogruzkaMPNList(listMPN);
        //JRDataSource jRdataSource = new JRBeanCollectionDataSource(listIM);
        //ContactFactory factory = new ContactFactory();
        //List<ContactBean> beanList = factory.create();
        List<PechatDokumentovMPN> dokumentovMPNList = new ArrayList<>();
        dokumentovMPNList.add(listMPN);
        JRDataSource source = new JRBeanCollectionDataSource(dokumentovMPNList);
        //model.addAttribute("datasource", new JREmptyDataSource());
        //model.addAttribute("MySubreportDataSource", jRdataSource);
        //model.addAttribute("p", jRdataSource);
        //model.addAttribute("x", listIK.size());
        //ModelAndView modelAndView = new ModelAndView("pdfReport", parameterMap);
        model.addAttribute("datasource", source);
        return "dokumentMPN";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dokumentMPA")
    public String generateDokumentMPA(@ModelAttribute("listMPASession") PechatDokumentovMPA listMPA, Model model) throws JRException, FileNotFoundException {
        Collections.sort(listMPA.getPogruzkaMPAList(), new Comparator<PogruzkaMPA>() {
            @Override
            public int compare(PogruzkaMPA o1, PogruzkaMPA o2) {
                return o1.getSertificatMPA().getPokupatel().getName().compareTo(o2.getSertificatMPA().getPokupatel().getName());
            }
        });
        List<PechatDokumentovMPA> dokumentovMPAList = new ArrayList<>();
        dokumentovMPAList.add(listMPA);
        JRDataSource source = new JRBeanCollectionDataSource(dokumentovMPAList);
        model.addAttribute("datasource", source);
        return "dokumentMPA";
    }

    public static class SortPogruzkaIKByPokupatelId implements Comparator<PogruzkaIK> {

        @Override
        public int compare(PogruzkaIK o1, PogruzkaIK o2) {
            return o2.getId() - o1.getId();
        }
    }
}
