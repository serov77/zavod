package ru.solicom.zavod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.service.PogruzkaIKService;
import ru.solicom.zavod.service.VagonService;

@Controller
@RequestMapping("/pogruzka")
public class PogruzkaController {
    @Autowired
    private PogruzkaIKService pogruzkaIKService;
    @Autowired
    private VagonService vagonService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listPogruzka(Model model) {
        model.addAttribute("pogruzkaIKList", pogruzkaIKService.pogruzkaIKList());
        model.addAttribute("pogruzkaIKNaLiniiList", pogruzkaIKService.pogruzkaIKNaLiniiList());
        return "pogruzka";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String pogruzkaAdd(@PathVariable int id, Model model) {
        Vagon vagon = vagonService.retriveVagon(id);

        //model.addAttribute("rodVagonaList", rodVagonaService.rodVagonaList());
        model.addAttribute("vagon", vagon);
        model.addAttribute("title_modal", "Взвешивание вагона!");
        return "pogruzka_add";
    }
}
