package ru.solicom.zavod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.solicom.zavod.domain.PogruzkaIK;
import ru.solicom.zavod.domain.SertificatIK;
import ru.solicom.zavod.domain.Tara;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.fasade.PogruzkaService;
import ru.solicom.zavod.service.*;
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
    private PogruzkaIKService pogruzkaIKService;
    @Autowired
    private VagonService vagonService;
    @Autowired
    private GruzService gruzService;
    @Autowired
    private TaraService taraService;
    @Autowired
    private SertificatIKService sertificatIKService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listPogruzka(Model model) {
        model.addAttribute("pogruzkaIKList", pogruzkaIKService.pogruzkaIKList());
        model.addAttribute("pogruzkaIKNaLiniiList", pogruzkaIKService.pogruzkaIKNaLiniiList());
        return "pogruzka";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String pogruzkaAdd(@PathVariable int id, Model model) {
        Vagon vagon = vagonService.retriveVagon(id);
        StatusVaiona x =  pogruzkaService.searchPogruzka(vagon);
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
                SertificatIK sertificatIK=sertificatIKService.retriveSertificatIK(1);
                pogruzkaIK.setSertificatIK(sertificatIK);
                pogruzkaIKService.savePogruzkaIK(pogruzkaIK);
                break;
        }
        return "Изминения успешно внесены!";
    }
}
