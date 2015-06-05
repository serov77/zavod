package ru.solicom.zavod.dao;

import ru.solicom.zavod.domain.SertificatIM;

import java.util.Date;
import java.util.List;

public interface SertificatIMDAO {
    public List<SertificatIM> sertificatIMList();
    public SertificatIM retriveSertificatIM(int id);

    void saveSertificatIM(SertificatIM sertificatIM);

    public Boolean searchSertificatIMByNomerAndGod(int id, String nomer, Date data);
}
