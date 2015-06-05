package ru.solicom.zavod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.solicom.zavod.service.RodVagonaService;

@Controller
@RequestMapping("/rod_vagona")
public class RodVagonaController {

    @Autowired
    private RodVagonaService rodVagonaService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listRodVagona(Model model) {
        model.addAttribute("list", rodVagonaService.rodVagonaList());
        return "rod_vagona";
    }
}
