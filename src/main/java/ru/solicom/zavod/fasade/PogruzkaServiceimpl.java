package ru.solicom.zavod.fasade;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.service.PogruzkaIKService;
import ru.solicom.zavod.service.PogruzkaIMService;
import ru.solicom.zavod.service.PogruzkaMPAService;
import ru.solicom.zavod.service.PogruzkaMPNService;
import ru.solicom.zavod.util.StatusVaiona;

import java.text.ParseException;

@Service
public class PogruzkaServiceimpl implements PogruzkaService {
    @Autowired
    private PogruzkaIKService pogruzkaIKService;
    @Autowired
    private PogruzkaIMService pogruzkaIMService;
    @Autowired
    private PogruzkaMPNService pogruzkaMPNService;
    @Autowired
    private PogruzkaMPAService pogruzkaMPAService;

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
    public PogruzkaMPAService getPogruzkaMPAService() {
        return pogruzkaMPAService;
    }

    @Override
    public StatusVaiona searchPogruzka(Vagon vagon) throws ParseException {
        StatusVaiona ik = pogruzkaIKService.searchPogruzkaIKVagonaZaDen(vagon, LocalDate.now());
        StatusVaiona im = pogruzkaIMService.searchPogruzkaIMVagonaZaDen(vagon, LocalDate.now());
        StatusVaiona mpn = pogruzkaMPNService.searchPogruzkaMPNVagonaZaDen(vagon, LocalDate.now());
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
        if (ik == true && im == true && mpn == true) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean searchPogruzka(int id, float gruzopodyomnost, float tara) {
        Boolean im = pogruzkaIKService.searchPogruzkaIK(id, gruzopodyomnost, tara);
        Boolean ik = pogruzkaIMService.searchPogruzkaIM(id, gruzopodyomnost, tara);
        Boolean mpn = pogruzkaMPNService.searchPogruzkaMPN(id, gruzopodyomnost, tara);
        if (ik == true && im == true && mpn == true) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean searchPogruzkaIKBySertificat(int id) {
        if ((pogruzkaIKService.searchPogruzkaIKBySertificat(id)).size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean searchPogruzkaIMBySertificat(int id) {
        if ((pogruzkaIMService.searchPogruzkaIMBySertificat(id)).size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean searchPogruzkaMPNBySertificat(int id) {
        if ((pogruzkaMPNService.searchPogruzkaMPNBySertificat(id)).size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean searchPogruzkaMPABySertificat(int id) {
        if ((pogruzkaMPAService.searchPogruzkaMPABySertificat(id)).size() == 0) {
            return true;
        }
        return false;
    }

}
