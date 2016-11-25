package ru.solicom.zavod.dao;

import ru.solicom.zavod.domain.PogruzkaMPN;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import org.joda.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PogruzkaMPNDAO {
    public List<PogruzkaMPN> pogruzkaMPNList();

    public List<PogruzkaMPN> pogruzkaMPNNaLiniiList();

    public void savePogruzkaMPN(PogruzkaMPN pogruzkaMPN);

    public StatusVaiona searchPogruzkaMPNVagonaZaDen(Vagon vagon, LocalDate date);

    public Boolean searchPogruzkaMPNMKR(int id);

    public List<PogruzkaMPN> searchPogruzkaMPN(int id);

    public PogruzkaMPN retrivePogruzkaMPN(int id);

    public List<PogruzkaMPN> searchPogruzkaMPNBySertificat(int id);

    public List<PogruzkaMPN> searchPogruzkaMPAMesyac (LocalDate x1, LocalDate x2);
}
