package ru.solicom.zavod.dao;

import ru.solicom.zavod.domain.SertificatIM;

import java.util.Date;
import java.util.List;

public interface SertificatIMDAO {
    public List<SertificatIM> sertificatIMList();

    public List<SertificatIM> sertificatIMBezPoluchatelyaList();

    public SertificatIM retriveSertificatIM(int id);

    void saveSertificatIM(SertificatIM sertificatIM);

    public Boolean searchSertificatIMByNomerAndGod(int id, String nomer, Date data);

    public List<SertificatIM> searchSertificatIMByData(Date date);
}
