package ru.solicom.zavod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.solicom.zavod.domain.Tara;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.service.GruzService;
import ru.solicom.zavod.service.PogruzkaIKService;
import ru.solicom.zavod.service.TaraService;
import ru.solicom.zavod.service.VagonService;
import ru.solicom.zavod.util.Pogruzka;

import java.util.List;

@Controller
@RequestMapping("/pogruzka")
public class PogruzkaController {
    @Autowired
    private PogruzkaIKService pogruzkaIKService;
    @Autowired
    private VagonService vagonService;
    @Autowired
    private GruzService gruzService;
    @Autowired
    private TaraService taraService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listPogruzka(Model model) {
        model.addAttribute("pogruzkaIKList", pogruzkaIKService.pogruzkaIKList());
        model.addAttribute("pogruzkaIKNaLiniiList", pogruzkaIKService.pogruzkaIKNaLiniiList());
        return "pogruzka";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String pogruzkaAdd(@PathVariable int id, Model model) {
        Vagon vagon = vagonService.retriveVagon(id);
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
}
