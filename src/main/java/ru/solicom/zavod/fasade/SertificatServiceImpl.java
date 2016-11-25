package ru.solicom.zavod.fasade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import ru.solicom.zavod.domain.*;
import ru.solicom.zavod.service.*;

import java.util.List;
import java.util.Set;

@Service
public class SertificatServiceImpl implements SertificatService {
    @Autowired
    private SertificatIKService sertificatIKService;
    @Autowired
    private SertificatIMService sertificatIMService;
    @Autowired
    private SertificatMPNService sertificatMPNService;
    @Autowired
    private SertificatMPAService sertificatMPAService;
    @Autowired
    private PokupatelService pokupatelService;
    @Autowired
    private PogruzkaService pogruzkaService;

    @Override
    public SertificatIKService getSertificatIKService() {
        return sertificatIKService;
    }

    @Override
    public SertificatIMService getSertificatIMService() {
        return sertificatIMService;
    }

    @Override
    public SertificatMPNService getSertificatMPNService() {
        return sertificatMPNService;
    }

    @Override
    public SertificatMPAService getSertificatMPAService() {
        return sertificatMPAService;
    }

    @Override
    public ModelAndView selectSertificat(String gruz, int id, ModelAndView model) {
        String title = "";
        String view = "";
        List<Pokupatel> pokupatelList = pokupatelService.pokupatelList();

        switch (gruz) {
            case "IK":
                if (!pogruzkaService.searchPogruzkaIKBySertificat(id)) {
                    pokupatelList.clear();
                    pokupatelList = pokupatelService.pokupatelListBezPustogo();
                }
                SertificatIK sertificatIK = sertificatIKService.retriveSertificatIK(id);
                Pokupatel pokupatelIK = sertificatIK.getPokupatel();
                Set<Station> stationListIK = pokupatelIK.getStations();
                model.addObject("sertificat", sertificatIK);
                model.addObject("pokupatelStations", stationListIK);
                model.addObject("stationSize", stationListIK.size());
                title = "Редактирование Сертификата на Известь Комовую";
                view = "sertificatIK_edit";
                break;
            case "IM":
                if (!pogruzkaService.searchPogruzkaIMBySertificat(id)) {
                    pokupatelList.clear();
                    pokupatelList = pokupatelService.pokupatelListBezPustogo();
                }
                SertificatIM sertificatIM = sertificatIMService.retriveSertificatIM(id);
                Pokupatel pokupatelIM = sertificatIM.getPokupatel();
                Set<Station> stationListIM = pokupatelIM.getStations();
                model.addObject("sertificat", sertificatIM);
                model.addObject("pokupatelStations", stationListIM);
                model.addObject("stationSize", stationListIM.size());
                title = "Редактирование Сертификата на Известь Молотую";
                view = "sertificatIM_edit";
                break;
            case "MPN":
                if (!pogruzkaService.searchPogruzkaMPNBySertificat(id)) {
                    pokupatelList.clear();
                    pokupatelList = pokupatelService.pokupatelListBezPustogo();
                }
                SertificatMPN sertificatMPN = sertificatMPNService.retriveSertificatMPN(id);
                Pokupatel pokupatelMPN = sertificatMPN.getPokupatel();
                Set<Station> stationListMPN = pokupatelMPN.getStations();
                model.addObject("sertificat", sertificatMPN);
                model.addObject("pokupatelStations", stationListMPN);
                model.addObject("stationSize", stationListMPN.size());
                title = "Редактирование Сертификата на Порошок Минеральный Неактивированный";
                view = "sertificatMPN_edit";
                break;
            case "MPA":
                if (!pogruzkaService.searchPogruzkaMPABySertificat(id)) {
                    pokupatelList.clear();
                    pokupatelList = pokupatelService.pokupatelListBezPustogo();
                }
                SertificatMPA sertificatMPA = sertificatMPAService.retriveSertificatMPA(id);
                Pokupatel pokupatelMPA = sertificatMPA.getPokupatel();
                Set<Station> stationListMPA = pokupatelMPA.getStations();
                model.addObject("sertificat", sertificatMPA);
                model.addObject("pokupatelStations", stationListMPA);
                model.addObject("stationSize", stationListMPA.size());
                title = "Редактирование Сертификата на Порошок Минеральный Активированный";
                view = "sertificatMPA_edit";
        }
        model.addObject("pokupatelList", pokupatelList);
        model.addObject("title_modal", title);
        model.setViewName(view);
        return model;
    }
}
