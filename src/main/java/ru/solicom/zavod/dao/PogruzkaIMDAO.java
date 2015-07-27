package ru.solicom.zavod.dao;

import ru.solicom.zavod.domain.PogruzkaIM;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

public interface PogruzkaIMDAO {
    public List<PogruzkaIM> pogruzkaIMList();

    public List<PogruzkaIM> pogruzkaIMNaLiniiList();

    public void savePogruzkaIM(PogruzkaIM pogruzkaIM);

    public StatusVaiona searchPogruzkaIMVagonaZaDen(Vagon vagon, Date date);

    public Boolean searchPogruzkaIMMKR(int id);
}
