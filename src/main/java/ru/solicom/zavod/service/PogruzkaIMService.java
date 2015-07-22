package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.PogruzkaIM;
import ru.solicom.zavod.domain.Vagon;

import java.util.Date;
import java.util.List;

public interface PogruzkaIMService {
    public List<PogruzkaIM> pogruzkaIMList();

    public List<PogruzkaIM> pogruzkaIMNaLiniiList();

    public Boolean searchPogruzkaIMVagonaZaDen(Vagon vagon, Date date);
}
