package ru.solicom.zavod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.solicom.zavod.service.PogruzkaIKService;

@Controller
@RequestMapping("/pogruzka")
public class PogruzkaController {
    @Autowired
    private PogruzkaIKService pogruzkaIKService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listPogruzka(Model model) {
        model.addAttribute("pogruzkaIKList", pogruzkaIKService.pogruzkaIKList());
        model.addAttribute("pogruzkaIKNaLiniiList", pogruzkaIKService.pogruzkaIKNaLiniiList());
        return "pogruzka";
    }
}
