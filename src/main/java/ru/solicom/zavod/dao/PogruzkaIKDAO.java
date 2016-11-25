package ru.solicom.zavod.dao;


import ru.solicom.zavod.domain.PogruzkaIK;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.Pogruzka;
import ru.solicom.zavod.util.StatusVaiona;

import java.text.ParseException;
import org.joda.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PogruzkaIKDAO {
    public List<PogruzkaIK> pogruzkaIKList();

    public List<PogruzkaIK> pogruzkaIKNaLiniiList();

    public void savePogruzkaIK(PogruzkaIK pogruzkaIK);

    public StatusVaiona searchPogruzkaIKVagonaZaDen(Vagon vagon, LocalDate date) throws ParseException;

    public Boolean searchPogruzkaIKMKR(int id);

    public List<PogruzkaIK> searchPogruzkaIK(int id);

    public PogruzkaIK retrivePogruzkaIK(int id);

    public List<PogruzkaIK> searchPogruzkaIKBySertificat(int id);

    public List<PogruzkaIK> searchPogruzkaIKMesyac (LocalDate x1, LocalDate x2);

}
