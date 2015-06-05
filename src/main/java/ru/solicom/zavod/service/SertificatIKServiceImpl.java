package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.SertificatIKDAO;
import ru.solicom.zavod.domain.SertificatIK;

import java.util.Date;
import java.util.List;

@Service
public class SertificatIKServiceImpl implements SertificatIKService {

    @Autowired
    private SertificatIKDAO sertificatIKDAO;

    @Transactional
    @Override
    public List<SertificatIK> sertificatIKList() {
        return sertificatIKDAO.sertificatIKList();
    }

    @Transactional
    @Override
    public SertificatIK retriveSertificatIK(int id) {
        return sertificatIKDAO.retriveSertificatIK(id);
    }

    @Transactional
    @Override
    public void saveSertficatIK(SertificatIK sertificatIK) {
        if (sertificatIK.getData() == null) {
            Date today = new Date();
            sertificatIK.setData(today);
        }
        sertificatIKDAO.saveSertificatIK(sertificatIK);
    }

    @Transactional
    @Override
    public Boolean searchSertificatIKByNomerAndGod(int id, String nomer, Date data) {
        return sertificatIKDAO.searchSertificatIKByNomerAndGod(id, nomer, data);
    }
}
