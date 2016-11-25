package ru.solicom.zavod.dao;

import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.SertificatIK;

import java.util.Date;
import java.util.List;

public interface SertificatIKDAO {

    public List<SertificatIK> sertificatIKList();

    public List<SertificatIK> sertificatIKBezPoluchatelyaList();

    public SertificatIK retriveSertificatIK(int id);

    public void saveSertificatIK(SertificatIK sertificatIK);

    public Boolean searchSertificatIKByNomerAndGod(int id, String nomer, LocalDate data);

    public List<SertificatIK> searchSertificatIKByData(LocalDate date);
}
