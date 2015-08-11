package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.SertificatIK;

import java.util.Date;
import java.util.List;

public interface SertificatIKService {

    public List<SertificatIK> sertificatIKListDlyaOformleniya();

    public List<SertificatIK> sertificatIKList();

    public List<SertificatIK> sertificatIKNeIspList();

    public List<SertificatIK> sertificatIKBezPoluchatelyaList();

    public SertificatIK retriveSertificatIK(int id);

    public void saveSertficatIK(SertificatIK sertificatIK);

    public Boolean searchSertificatIKByNomerAndGod(int id, String nomer, Date data);

    public List<SertificatIK> searchSertificatIKByData(Date date);
}
