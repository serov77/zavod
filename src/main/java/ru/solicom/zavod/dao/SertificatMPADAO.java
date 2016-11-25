package ru.solicom.zavod.dao;

import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.SertificatMPA;

import java.util.List;

public interface SertificatMPADAO {
    public List<SertificatMPA> sertificatMPAList();

    public List<SertificatMPA> sertificatMPABezPoluchatelyaList();

    public SertificatMPA retriveSertificatMPA(int id);

    void saveSertificatMPA(SertificatMPA sertificatMPN);

    public Boolean searchSertificatMPAByNomerAndGod(int id, String nomer, LocalDate data);

    public List<SertificatMPA> searchSertificatMPAByData(LocalDate date);
}
