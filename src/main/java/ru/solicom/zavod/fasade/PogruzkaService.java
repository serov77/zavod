package ru.solicom.zavod.fasade;

import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.service.PogruzkaIKService;
import ru.solicom.zavod.service.PogruzkaIMService;
import ru.solicom.zavod.service.PogruzkaMPNService;
import ru.solicom.zavod.util.StatusVaiona;

public interface PogruzkaService {
    public PogruzkaIKService getPogruzkaIKService();

    public PogruzkaIMService getPogruzkaIMService();

    public PogruzkaMPNService getPogruzkaMPNService();

    public StatusVaiona searchPogruzka(Vagon vagon);

    public Boolean searchPogruzkaMKR(int id);
}
