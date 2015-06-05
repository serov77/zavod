package ru.solicom.zavod.controllers;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.service.RodVagonaService;
import ru.solicom.zavod.service.VagonService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vagon")
public class VagonController {

    @Autowired
    private VagonService vagonService;
    @Autowired
    private RodVagonaService rodVagonaService;
    private List<Vagon> vagonList;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listVagon(Model model) throws JRException, InterruptedException {
        vagonList = vagonService.vagonList();
        model.addAttribute("vagonList", vagonList);
        model.addAttribute("searchVagon", new Vagon());
        return "vagon";
    }

    @RequestMapping("/search")
    public String searchVagonAll(@ModelAttribute("searchVagon") Vagon vagon, Model model) {
        vagonList = vagonService.searchVagonList(vagon.getNomerVagona());
        model.addAttribute("vagonList", vagonList);
        model.addAttribute("vagon", vagon);
        return "vagon";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addVagonGet(Model model) {
        model.addAttribute("vagon", new Vagon());
        model.addAttribute("rodVagonaList", rodVagonaService.rodVagonaList());
        model.addAttribute("title_modal", "Добавление вагона!");
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
    public String vagonSave(@RequestBody Vagon vagon) {
        vagonService.saveVagon(vagon);
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/edit/{input}", method = RequestMethod.GET)
    public String searchVagonById(@PathVariable int input, Model model) {
        Vagon vagon = vagonService.retriveVagon(input);
        model.addAttribute("rodVagonaList", rodVagonaService.rodVagonaList());
        model.addAttribute("vagon", vagon);
        model.addAttribute("title_modal", "Редактирование вагона!");
        return "vagon_edit";
    }
}
