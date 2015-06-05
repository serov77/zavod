package ru.solicom.zavod.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.SertificatIMDAO;
import ru.solicom.zavod.domain.SertificatIM;

import java.util.Date;
import java.util.List;

@Service
public class SertificatIMServiceImpl implements SertificatIMService {

    @Autowired
    private SertificatIMDAO sertificatIMDAO;

    @Transactional
    @Override
    public List<SertificatIM> sertificatIMList() {
        return sertificatIMDAO.sertificatIMList();
    }

    @Transactional
    @Override
    public SertificatIM retriveSertificatIM(int id) {
        return sertificatIMDAO.retriveSertificatIM(id);
    }

    @Transactional
    @Override
    public void saveSertficatIM(SertificatIM sertificatIM) {
        if (sertificatIM.getData() == null) {
            Date today = new Date();
            sertificatIM.setData(today);
        }
        sertificatIMDAO.saveSertificatIM(sertificatIM);
    }

    @Transactional
    @Override
    public Boolean searchSertificatIMByNomerAndGod(int id, String nomer, Date data) {
        return sertificatIMDAO.searchSertificatIMByNomerAndGod(id, nomer, data);
    }
}
