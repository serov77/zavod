package ru.solicom.zavod.fasade;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface SertificatService {
    ModelAndView selectSertificat(String gruz, int id, ModelAndView model);
}
