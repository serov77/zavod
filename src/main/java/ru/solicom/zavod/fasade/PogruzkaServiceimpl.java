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

    @Override
    public Boolean searchPogruzkaMKR(int id) {
        Boolean im = pogruzkaIKService.searchPogruzkaIKMKR(id);
        Boolean ik = pogruzkaIMService.searchPogruzkaIMMKR(id);
        Boolean mpn = pogruzkaMPNService.searchPogruzkaMPNMKR(id);
        if (ik == true && im == true && mpn == true){
            return true;
        }
        return false;
    }

    @Override
    public Boolean searchPogruzka(int id, float gruzopodyomnost, float tara) {
        Boolean im = pogruzkaIKService.searchPogruzkaIK(id,gruzopodyomnost,tara);
        Boolean ik = pogruzkaIMService.searchPogruzkaIM(id,gruzopodyomnost,tara);
        Boolean mpn = pogruzkaMPNService.searchPogruzkaMPN(id,gruzopodyomnost,tara);
        if (ik == true && im == true && mpn == true){
            return true;
        }
        return false;
    }

}
