package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.PogruzkaIK;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

public interface PogruzkaIKService {
    public List<PogruzkaIK> pogruzkaIKList();

    public List<PogruzkaIK> pogruzkaIKNaLiniiList();

    public void savePogruzkaIK(PogruzkaIK pogruzkaIK);

    public StatusVaiona searchPogruzkaIKVagonaZaDen(Vagon vagon, Date date);

    public Boolean searchPogruzkaIKMKR(int id);

    public Boolean searchPogruzkaIK(int id, float gruzopodyomnost, float tara);
}
