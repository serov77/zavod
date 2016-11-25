package ru.solicom.zavod.fasade;

import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.service.PogruzkaIKService;
import ru.solicom.zavod.service.PogruzkaIMService;
import ru.solicom.zavod.service.PogruzkaMPAService;
import ru.solicom.zavod.service.PogruzkaMPNService;
import ru.solicom.zavod.util.StatusVaiona;

import java.text.ParseException;

public interface PogruzkaService {
    public PogruzkaIKService getPogruzkaIKService();

    public PogruzkaIMService getPogruzkaIMService();

    public PogruzkaMPNService getPogruzkaMPNService();

    public PogruzkaMPAService getPogruzkaMPAService();

    public StatusVaiona searchPogruzka(Vagon vagon) throws ParseException;

    public Boolean searchPogruzkaMKR(int id);

    public Boolean searchPogruzka(int id, float gruzopodyomnost, float tara);

    public Boolean searchPogruzkaIKBySertificat(int id);

    public Boolean searchPogruzkaIMBySertificat(int id);

    public Boolean searchPogruzkaMPNBySertificat(int id);

    public Boolean searchPogruzkaMPABySertificat(int id);
}
