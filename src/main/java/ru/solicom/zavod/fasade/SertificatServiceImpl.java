package ru.solicom.zavod.fasade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import ru.solicom.zavod.service.PokupatelService;
import ru.solicom.zavod.service.SertificatIKService;
import ru.solicom.zavod.service.SertificatIMService;
import ru.solicom.zavod.service.SertificatMPNService;

@Service
public class SertificatServiceImpl implements SertificatService {
    @Autowired
    private SertificatIKService sertificatIKService;
    @Autowired
    private SertificatIMService sertificatIMService;
    @Autowired
    private SertificatMPNService sertificatMPNService;
    @Autowired
    private PokupatelService pokupatelService;

    @Override
    public ModelAndView selectSertificat(String gruz, int id, ModelAndView model) {
        String title = "";
        String view = "";
        switch (gruz) {
            case "IK":
                model.addObject("sertificat", sertificatIKService.retriveSertificatIK(id));
                title = "Редактирование Сертификата на Известь Комовую";
                view = "sertificatIK_edit";
                break;
            case "IM":
                model.addObject("sertificat", sertificatIMService.retriveSertificatIM(id));
                title = "Редактирование Сертификата на Известь Молотую";
                view = "sertificatIM_edit";
                break;
            case "MPN":
                model.addObject("sertificat", sertificatMPNService.retriveSertificatMPN(id));
                title = "Редактирование Сертификата на Порошок Минеральный Неактивированный";
                view = "sertificatMPN_edit";
        }
        model.addObject("pokupatelList", pokupatelService.pokupatelList());
        model.addObject("title_modal", title);
        model.setViewName(view);
        return model;
    }
}
