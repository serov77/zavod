package ru.solicom.zavod.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.solicom.zavod.domain.Station;
import ru.solicom.zavod.service.StationService;

@Controller
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "/all")
    public String stationList(Model model) {
        model.addAttribute("stationList", stationService.stationList());
        model.addAttribute("searchStation", new Station());
        return "station";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStationGet(Model model) {
        model.addAttribute("title_modal","Добавление Станции");
        model.addAttribute("station", new Station());
        return "station_edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String vagonSave(@RequestBody Station station) {
        stationService.saveStation(station);
        return "Изминения успешно внесены!";
    }
    
//    @RequestMapping(value = "/save")
//    public String saveStation(@ModelAttribute("station") @Valid Station station, BindingResult result, Model model) throws UnsupportedEncodingException {
//        String adress = "";
//        if (!stationService.searchStationByName(station.getName(), station.getId())) {
//            model.addAttribute("x", 1);
//            adress = "station_add";
//        }
//        if (!stationService.searchStationByKod(station.getKod(), station.getId())) {
//            model.addAttribute("y", 1);
//            adress = "station_add";
//        }
//        if (result.hasErrors()) {
//            adress = "station_add";
//        }
//        if ("".equals(adress)) {
//            stationService.saveStation(station);
//            adress = "redirect:/station/all";
//        }
//
//        return adress;
//    }

    @RequestMapping("/edit/{stationId}")
    public String editStation(@PathVariable("stationId") int stationId, Model model) {

        Station station = stationService.retriveStation(stationId);
        model.addAttribute("title_modal","Редактирование станции");
        model.addAttribute("station", station);
        return "station_edit";
    }

    @RequestMapping("/search")
    public String searchStationAll(@ModelAttribute("searchStation") Station station, Model model) {
        model.addAttribute("stationList", stationService.searchStationList(station.getNameStation()));
        model.addAttribute("station", station);
        return "station";
    }
}
