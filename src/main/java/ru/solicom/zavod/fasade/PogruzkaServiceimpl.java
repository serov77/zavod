package ru.solicom.zavod.fasade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.service.PogruzkaIKService;
import ru.solicom.zavod.service.PogruzkaIMService;
import ru.solicom.zavod.service.PogruzkaMPNService;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;

@Service
public class PogruzkaServiceimpl implements PogruzkaService {
    @Autowired
    private PogruzkaIKService pogruzkaIKService;
    @Autowired
    private PogruzkaIMService pogruzkaIMService;
    @Autowired
    private PogruzkaMPNService pogruzkaMPNService;

    @Override
    public PogruzkaIKService getPogruzkaIKService() {
        return pogruzkaIKService;
    }

    @Override
    public PogruzkaIMService getPogruzkaIMService() {
        return pogruzkaIMService;
    }

    @Override
    public PogruzkaMPNService getPogruzkaMPNService() {
        return pogruzkaMPNService;
    }

    @Override
    public StatusVaiona searchPogruzka(Vagon vagon) {
        StatusVaiona ik = pogruzkaIKService.searchPogruzkaIKVagonaZaDen(vagon, new Date());
        StatusVaiona im = pogruzkaIMService.searchPogruzkaIMVagonaZaDen(vagon, new Date());
        StatusVaiona mpn = pogruzkaMPNService.searchPogruzkaMPNVagonaZaDen(vagon, new Date());
        StatusVaiona ok = StatusVaiona.LOST;
        if (ik == StatusVaiona.OK && im == StatusVaiona.OK && mpn == StatusVaiona.OK) {
            ok = StatusVaiona.OK;
        }
        return ok;
    }

}
