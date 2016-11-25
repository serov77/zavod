package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.PogruzkaIM;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import org.joda.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PogruzkaIMService {
    public List<PogruzkaIM> pogruzkaIMList();

    public List<PogruzkaIM> pogruzkaIMNaLiniiList();

    public void savePogruzkaIM(PogruzkaIM pogruzkaIM);

    public StatusVaiona searchPogruzkaIMVagonaZaDen(Vagon vagon, LocalDate date);

    public Boolean searchPogruzkaIMMKR(int id);

    public Boolean searchPogruzkaIM(int id, float gruzopodyomnost, float tara);

    public PogruzkaIM retrivePogruzkaIM(int id);

    public List<PogruzkaIM> searchPogruzkaIMBySertificat(int id);

    public List<PogruzkaIM> searchPogruzkaIMMesyac (LocalDate x1, LocalDate x2);
}
