package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.SertificatIK;

import java.util.Date;
import java.util.List;

public interface SertificatIKService {

    public List<SertificatIK> sertificatIKList();

    public SertificatIK retriveSertificatIK(int id);

    public void saveSertficatIK(SertificatIK sertificatIK);

    public Boolean searchSertificatIKByNomerAndGod(int id, String nomer, Date data);
}
