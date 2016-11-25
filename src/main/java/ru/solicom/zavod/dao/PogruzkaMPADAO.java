package ru.solicom.zavod.dao;

import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.PogruzkaMPA;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.List;

public interface PogruzkaMPADAO {

    public List<PogruzkaMPA> pogruzkaMPAList();

    public List<PogruzkaMPA> pogruzkaMPANaLiniiList();

    public void savePogruzkaMPA(PogruzkaMPA pogruzkaMPA);

    public StatusVaiona searchPogruzkaMPAVagonaZaDen(Vagon vagon, LocalDate date);

    public Boolean searchPogruzkaMPAMKR(int id);

    public List<PogruzkaMPA> searchPogruzkaMPA(int id);

    public PogruzkaMPA retrivePogruzkaMPA(int id);

    public List<PogruzkaMPA> searchPogruzkaMPABySertificat(int id);

    public List<PogruzkaMPA> searchPogruzkaMPAMesyac (LocalDate x1, LocalDate x2);
}
