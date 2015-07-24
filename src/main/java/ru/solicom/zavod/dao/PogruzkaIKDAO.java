package ru.solicom.zavod.dao;


import ru.solicom.zavod.domain.PogruzkaIK;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

public interface PogruzkaIKDAO {
    public List<PogruzkaIK> pogruzkaIKList();

    public List<PogruzkaIK> pogruzkaIKNaLiniiList();

    public void savePogruzkaIK(PogruzkaIK pogruzkaIK);

    public StatusVaiona searchPogruzkaIKVagonaZaDen(Vagon vagon, Date date);

    public Boolean searchPogruzkaIKMKR(Vagon vagon);
}
