package ru.solicom.zavod.fasade;

import org.springframework.web.servlet.ModelAndView;
import ru.solicom.zavod.service.SertificatIKService;
import ru.solicom.zavod.service.SertificatIMService;
import ru.solicom.zavod.service.SertificatMPNService;

public interface SertificatService {
    public SertificatIKService getSertificatIKService();

    public SertificatIMService getSertificatIMService();

    public SertificatMPNService getSertificatMPNService();

    ModelAndView selectSertificat(String gruz, int id, ModelAndView model);
}
