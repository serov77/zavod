package ru.solicom.zavod.controllers;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.solicom.zavod.domain.User;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.fasade.PogruzkaService;
import ru.solicom.zavod.service.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
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
    private PogruzkaService pogruzkaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listRodVagona(Model model) {
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user = "Гость";
        if (!o.toString().equals("anonymousUser")) {
            user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getLogin();
        }
        model.addAttribute("list", rodVagonaService.rodVagonaList());
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping(value = "/sbit", method = RequestMethod.GET)
    public String sbitHome() {
        return "sbit_home";
    }

    @RequestMapping(value = "/valid_vagon", method = RequestMethod.GET)
    @ResponseBody
    public String searchVagonByNomerId(@RequestParam String nomerVagona, @RequestParam int id) {
        Boolean x = vagonService.searchVagonByNomerVagona(nomerVagona, id);
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
    public String searchSertificatByNomerID(@PathVariable String y, @RequestParam int id, @RequestParam String data, @RequestParam String nomer) throws ParseException {
        Boolean x = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String sd = format.format(date);
        if (data != "") {
            sd = data;
        }
        date = format.parse(sd);
        switch (y) {
            case "ik":
                x = sertificatIKService.searchSertificatIKByNomerAndGod(id, nomer, date);
                break;
            case "im":
                x = sertificatIMService.searchSertificatIMByNomerAndGod(id, nomer, date);
                break;
            case "mpn":
                x = sertificatMPNService.searchSertificatMPNByNomerAndGod(id, nomer, date);
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
        if (idRV == 2) {
            if (idRV == idRV_2) {
                x = true;
            } else if (pogruzkaService.searchPogruzkaMKR(id)) {
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
        if (pogruzkaService.searchPogruzka(id, gruzopodyomnost, tara)) {
            x = true;
        }
        return "{ \"valid\": " + x + " }";
    }

    @RequestMapping(method = RequestMethod.GET , value = "/report")
    public String generatePDFReport(Model model) throws JRException, FileNotFoundException {
        //Map<String,Object> parameterMap = new HashMap<String,Object>();
        List<Vagon> vagonList = vagonService.vagonList();
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(vagonList);
        model.addAttribute("datasource", JRdataSource);
        //ModelAndView modelAndView = new ModelAndView("pdfReport", parameterMap);
        return "pdfReport";
    }
}
