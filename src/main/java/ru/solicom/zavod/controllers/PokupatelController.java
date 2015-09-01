package ru.solicom.zavod.controllers;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.solicom.zavod.domain.Pokupatel;
import ru.solicom.zavod.domain.Station;
import ru.solicom.zavod.service.PokupatelService;
import ru.solicom.zavod.service.StationService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pokupatel")
public class PokupatelController {

    @Autowired
    private PokupatelService pokupatelService;
    @Autowired
    private StationService stationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listPokupatel(Model model) {
        List<Pokupatel> l = pokupatelService.pokupatelList();
        model.addAttribute("pokupatelList", l);
        model.addAttribute("searchPokupatel", new Pokupatel());
        return "pokupatel";
    }

    @RequestMapping("/search")
    public String searchPokupatelAll(@ModelAttribute("searchPokupatel") Pokupatel pokupatel, Model model) {
        model.addAttribute("pokupatelList", pokupatelService.searchPokupatelList(pokupatel.getName()));
        model.addAttribute("pokupatel", pokupatel);
        return "pokupatel";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPokupatel(Model model) {
        model.addAttribute("pokupatel", new Pokupatel());
        model.addAttribute("stationList", stationService.stationList());
        model.addAttribute("title_modal", "Добавление Покупателя");
        return "pokupatel_edit";
    }

//    @RequestMapping(value = "/save")
//    public String savePokupatel(@ModelAttribute("pokupatel") @Valid Pokupatel pokupatel, BindingResult result, Model model) throws UnsupportedEncodingException {
//        String adress = "";
//        int id = pokupatel.getId();
//        if (!pokupatelService.searchPokupatelByName(pokupatel.getName(), id)) {
//            model.addAttribute("x", 1);
//            adress = "pokupatel_add";
//        }
//        if (!pokupatelService.searchPokupatelByKod(pokupatel.getKod(), id)) {
//            model.addAttribute("y", 1);
//            if ("".equals(adress)) {
//                adress = "pokupatel_add";
//            }
//        }
//        if (!pokupatelService.searchRokupatelByOKPO(pokupatel.getOkpo(), id)) {
//            model.addAttribute("z", 1);
//            if ("".equals(adress)) {
//                adress = "pokupatel_add";
//            }
//        }
//        if (result.hasErrors()) {
//            if ("".equals(adress)) {
//                adress = "pokupatel_add";
//            }
//        }
//        if ("".equals(adress)) {
//            pokupatelService.savePokupatel(pokupatel);
//            adress = "redirect:/pokupatel/all";
//        } else {
//            model.addAttribute("stationList", stationService.stationList());
//        }
//        return adress;
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String pokupatelSave(@RequestBody Pokupatel pokupatel) {
        Station station = stationService.retriveStation(pokupatel.getStation().getId());
        pokupatel.setStation(station);
        pokupatelService.savePokupatel(pokupatel);
        return "Изминения успешно внесены!";
    }

    @RequestMapping("/edit/{pokupatelId}")
    public String editPokupatel(@PathVariable("pokupatelId") int pokupatelId, Model model) throws IOException {
        Pokupatel pokupatel = pokupatelService.retrivePokupatel(pokupatelId);
        model.addAttribute("pokupatel", pokupatel);
        model.addAttribute("stationList", stationService.stationList());
        model.addAttribute("title_modal", "Редактирование Покупателя");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pokupatel);
        model.addAttribute("pokupatelJSON", json);
        return "pokupatel_edit" ;
    }
}
