package ru.solicom.zavod.dao;

import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.SertificatIM;

import java.util.Date;
import java.util.List;

public interface SertificatIMDAO {
    public List<SertificatIM> sertificatIMList();

    public List<SertificatIM> sertificatIMBezPoluchatelyaList();

    public SertificatIM retriveSertificatIM(int id);

    void saveSertificatIM(SertificatIM sertificatIM);

    public Boolean searchSertificatIMByNomerAndGod(int id, String nomer, LocalDate data);

    public List<SertificatIM> searchSertificatIMByData(LocalDate date);
}
