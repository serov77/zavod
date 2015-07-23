package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.PogruzkaIM;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

public interface PogruzkaIMService {
    public List<PogruzkaIM> pogruzkaIMList();

    public List<PogruzkaIM> pogruzkaIMNaLiniiList();

    public void savePogruzkaIM(PogruzkaIM pogruzkaIM);

    public StatusVaiona searchPogruzkaIMVagonaZaDen(Vagon vagon, Date date);
}
