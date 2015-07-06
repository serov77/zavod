package ru.solicom.zavod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.solicom.zavod.domain.User;
import ru.solicom.zavod.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listRodVagona(Model model) {

        Object o =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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

    @RequestMapping(value = "/valid_sertificat_nomer", method = RequestMethod.GET)
    @ResponseBody
    public String searchSertificatByNomerID( @RequestParam int id, @RequestParam String data, @RequestParam String nomer) throws ParseException {
        String sd = data;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(sd);
        Boolean x = sertificatIKService.searchSertificatIKByNomerAndGod(id, nomer, date);
        return "{ \"valid\": " + x + " }";
    }

}
