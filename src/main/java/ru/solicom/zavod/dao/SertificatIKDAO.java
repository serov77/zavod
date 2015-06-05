package ru.solicom.zavod.dao;

import ru.solicom.zavod.domain.SertificatIK;

import java.util.Date;
import java.util.List;

public interface SertificatIKDAO {

    public List<SertificatIK> sertificatIKList();

    public SertificatIK retriveSertificatIK(int id);

    public void saveSertificatIK(SertificatIK sertificatIK);

    public Boolean searchSertificatIKByNomerAndGod(int id, String nomer, Date data);
}
