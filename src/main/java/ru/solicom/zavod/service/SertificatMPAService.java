package ru.solicom.zavod.service;


import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.SertificatMPA;

import java.util.List;

public interface SertificatMPAService {
    public List<SertificatMPA> sertificatMPAListDlyaOformleniya();

    public List<SertificatMPA> sertificatMPAList();

    public List<SertificatMPA> sertificatMPANeIspList();

    public List<SertificatMPA> sertificatMPABezPoluchatelyaList();

    public SertificatMPA retriveSertificatMPA(int id);

    void saveSertificatMPA(SertificatMPA sertificatMPA);

    public Boolean searchSertificatMPAByNomerAndGod(int id, String nomer, LocalDate data);

    public List<SertificatMPA> searchSertificatMPAByData(LocalDate date);
}
