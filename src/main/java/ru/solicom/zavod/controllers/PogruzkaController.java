package ru.solicom.zavod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.solicom.zavod.domain.*;
import ru.solicom.zavod.fasade.PogruzkaService;
import ru.solicom.zavod.fasade.SertificatService;
import ru.solicom.zavod.service.GruzService;
import ru.solicom.zavod.service.TaraService;
import ru.solicom.zavod.service.VagonService;
import ru.solicom.zavod.util.Pogruzka;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pogruzka")
public class PogruzkaController {
    @Autowired
    private PogruzkaService pogruzkaService;
    @Autowired
    private VagonService vagonService;
    @Autowired
    private GruzService gruzService;
    @Autowired
    private TaraService taraService;
    @Autowired
    private SertificatService sertificatService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listPogruzka(Model model) {
        model.addAttribute("pogruzkaIKList", pogruzkaService.getPogruzkaIKService().pogruzkaIKList());
        model.addAttribute("pogruzkaIKNaLiniiList", pogruzkaService.getPogruzkaIKService().pogruzkaIKNaLiniiList());
        model.addAttribute("pogruzkaIMList", pogruzkaService.getPogruzkaIMService().pogruzkaIMList());
        model.addAttribute("pogruzkaIMNaLiniiList", pogruzkaService.getPogruzkaIMService().pogruzkaIMNaLiniiList());
        model.addAttribute("pogruzkaMPNList", pogruzkaService.getPogruzkaMPNService().pogruzkaMPNList());
        model.addAttribute("pogruzkaMPNNaLiniiList", pogruzkaService.getPogruzkaMPNService().pogruzkaMPNNaLiniiList());
        return "pogruzka";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String pogruzkaAdd(@PathVariable int id, Model model) {
        Vagon vagon = vagonService.retriveVagon(id);
        StatusVaiona x = pogruzkaService.searchPogruzka(vagon);
        if (x == StatusVaiona.LOST) {
            return "pogruzka_lost";
        }
        Pogruzka pogruzka = new Pogruzka();
        List<Tara> taraList;
        if (vagon.getRodVagona().getName().equals("полувагон")) {
            taraList = taraService.taraList();
        } else {
            taraList = taraService.taraBezMKRList();
        }
        pogruzka.setVagon(vagon);
        model.addAttribute("taraList", taraList);
        model.addAttribute("gruzList", gruzService.gruzList());
        model.addAttribute("vagon", vagon);
        model.addAttribute("pogruzka", pogruzka);
        model.addAttribute("title_modal", "Взвешивание вагона!");
        return "pogruzka_add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String pogruzkaSave(@RequestBody Pogruzka pogruzka) {
        Vagon vagon = vagonService.retriveVagon(pogruzka.getIdVagon());
        pogruzka.setVagon(vagon);
        pogruzka.setDataPogruzki(new Date());
        switch (pogruzka.getGruz().getId()) {
            case 1:
                PogruzkaIK pogruzkaIK = new PogruzkaIK();
                pogruzkaIK.setVagon(vagon);
                pogruzkaIK.setBrutto(pogruzka.getBrutto());
                pogruzkaIK.setDataPogruzki(pogruzka.getDataPogruzki());
                pogruzkaIK.setDopolneniya(pogruzka.getDopolneniya());
                pogruzkaIK.setTara(pogruzka.getTara());
                SertificatIK sertificatIK = sertificatService.getSertificatIKService().retriveSertificatIK(1);
                pogruzkaIK.setSertificatIK(sertificatIK);
                pogruzkaService.getPogruzkaIKService().savePogruzkaIK(pogruzkaIK);
                break;
            case 2:
                PogruzkaIM pogruzkaIM = new PogruzkaIM();
                pogruzkaIM.setVagon(vagon);
                pogruzkaIM.setBrutto(pogruzka.getBrutto());
                pogruzkaIM.setDataPogruzki(pogruzka.getDataPogruzki());
                pogruzkaIM.setDopolneniya(pogruzka.getDopolneniya());
                pogruzkaIM.setTara(pogruzka.getTara());
                SertificatIM sertificatIM = sertificatService.getSertificatIMService().retriveSertificatIM(1);
                pogruzkaIM.setSertificatIM(sertificatIM);
                pogruzkaService.getPogruzkaIMService().savePogruzkaIM(pogruzkaIM);
                break;
            case 3:
                PogruzkaMPN pogruzkaMPN = new PogruzkaMPN();
                pogruzkaMPN.setVagon(vagon);
                pogruzkaMPN.setBrutto(pogruzka.getBrutto());
                pogruzkaMPN.setDataPogruzki(pogruzka.getDataPogruzki());
                pogruzkaMPN.setDopolneniya(pogruzka.getDopolneniya());
                pogruzkaMPN.setTara(pogruzka.getTara());
                SertificatMPN sertificatMPN = sertificatService.getSertificatMPNService().retriveSertificatMPN(1);
                pogruzkaMPN.setSertificatMPN(sertificatMPN);
                pogruzkaService.getPogruzkaMPNService().savePogruzkaMPN(pogruzkaMPN);
        }
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/saveIK", method = RequestMethod.POST)
    @ResponseBody
    public String pogruzkaIKSave(@ModelAttribute("pogruzka") PogruzkaIK pogruzka){
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/otpravka/{gruz}/{id}", method = RequestMethod.GET)
    public String pogruzkaOtpr(@PathVariable String gruz, @PathVariable int id, Model model) {
        switch (gruz) {
            case "IK":
                model.addAttribute("pogruzka", pogruzkaService.getPogruzkaIKService().retrivePogruzkaIK(id));
                break;
            case "IM":
                model.addAttribute("pogruzka", pogruzkaService.getPogruzkaIMService().retrivePogruzkaIM(id));
                break;
            case "MPN":
                model.addAttribute("pogruzka", pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(id));
                break;
        }
        model.addAttribute("gruz", gruz);
        model.addAttribute("title_modal", "Оформление документов!");
        return "pogruzka_otpr";
    }

    @RequestMapping(value = "/edit/{gruz}/{id}", method = RequestMethod.GET)
    public String pogruzkaEdit(@PathVariable String gruz, @PathVariable int id, Model model) {
        Vagon vagon = new Vagon();
        switch (gruz) {
            case "IK":
                PogruzkaIK pogruzkaIK = pogruzkaService.getPogruzkaIKService().retrivePogruzkaIK(id);
                model.addAttribute("pogruzka", pogruzkaIK);
                vagon = pogruzkaIK.getVagon();
                break;
            case "IM":
                PogruzkaIM pogruzkaIM = pogruzkaService.getPogruzkaIMService().retrivePogruzkaIM(id);
                model.addAttribute("pogruzka", pogruzkaIM);
                vagon = pogruzkaIM.getVagon();
                break;
            case "MPN":
                PogruzkaMPN pogruzkaMPN = pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(id);
                model.addAttribute("pogruzka", pogruzkaMPN);
                vagon = pogruzkaMPN.getVagon();
                break;
        }
        List<Tara> taraList;
        if (vagon.getRodVagona().getName().equals("полувагон")) {
            taraList = taraService.taraList();
        } else {
            taraList = taraService.taraBezMKRList();
        }
        model.addAttribute("taraList", taraList);
        model.addAttribute("gruz", gruz);
        model.addAttribute("title_modal", "Оформление документов!");
        return "pogruzka_edit";
    }

    @RequestMapping(value = "/setDate/{gruz}/{x}/{y}/{z}")
    public String setDate(@PathVariable String gruz, @PathVariable int x, @PathVariable int y, @PathVariable int z, Model model) {
        Date date = new Date((z - 1900), y, x);
        switch (gruz) {
            case "IK":
                model.addAttribute("sertificatList", sertificatService.getSertificatIKService().searchSertificatIKByData(date));
                break;
            case "IM":
                model.addAttribute("sertificatList", sertificatService.getSertificatIMService().searchSertificatIMByData(date));
                break;
            case "MPN":
                model.addAttribute("sertificatList", sertificatService.getSertificatMPNService().searchSertificatMPNByData(date));
                break;
        }
        return "pogr_sert_data";
    }

    @RequestMapping(value = "/otpr/save/{gruz}/{id}/{sertId}")
    @ResponseBody
    public String pogruzkaOtprSave(@PathVariable String gruz, @PathVariable int id, @PathVariable int sertId) {
        //Vagon vagon = vagonService.retriveVagon(pogruzka.getIdVagon());
        //pogruzka.setVagon(vagon);
        //pogruzka.setDataPogruzki(new Date());
        switch (gruz) {
            case "IK":
                PogruzkaIK pogruzkaIK = pogruzkaService.getPogruzkaIKService().retrivePogruzkaIK(id);
                SertificatIK sertificatIK = sertificatService.getSertificatIKService().retriveSertificatIK(sertId);
                pogruzkaIK.setSertificatIK(sertificatIK);
                pogruzkaIK.setDataOtpravleniya(new Date());
                pogruzkaService.getPogruzkaIKService().savePogruzkaIK(pogruzkaIK);
                break;
            case "IM":
                PogruzkaIM pogruzkaIM = pogruzkaService.getPogruzkaIMService().retrivePogruzkaIM(id);
                SertificatIM sertificatIM = sertificatService.getSertificatIMService().retriveSertificatIM(sertId);
                pogruzkaIM.setSertificatIM(sertificatIM);
                pogruzkaIM.setDataOtpravleniya(new Date());
                pogruzkaService.getPogruzkaIMService().savePogruzkaIM(pogruzkaIM);
                break;
            case "MPN":
                PogruzkaMPN pogruzkaMPN = pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(id);
                SertificatMPN sertificatMPN = sertificatService.getSertificatMPNService().retriveSertificatMPN(sertId);
                pogruzkaMPN.setSertificatMPN(sertificatMPN);
                pogruzkaMPN.setDataOtpravleniya(new Date());
                pogruzkaService.getPogruzkaMPNService().savePogruzkaMPN(pogruzkaMPN);
                break;
        }
        return "Изминения успешно внесены!";
    }
}
