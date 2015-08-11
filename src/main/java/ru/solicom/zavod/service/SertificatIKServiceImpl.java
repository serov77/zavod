package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.SertificatIKDAO;
import ru.solicom.zavod.domain.SertificatIK;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SertificatIKServiceImpl implements SertificatIKService {

    @Autowired
    private SertificatIKDAO sertificatIKDAO;
    @Autowired
    private PokupatelService pokupatelService;
    private List<SertificatIK> sertificatIKNeIspList = new ArrayList<>();
    private List<SertificatIK> sertificatIKList = new ArrayList<>();

    @Transactional
    @Override
    public List<SertificatIK> sertificatIKListDlyaOformleniya() {
        return sertificatIKDAO.sertificatIKList();
    }

    @Transactional
    @Override
    public List<SertificatIK> sertificatIKList() {
        sertificatIKList.clear();
        sertificatIKNeIspList.clear();
        List<SertificatIK> list = sertificatIKDAO.sertificatIKList();
        for (SertificatIK s : list) {
            if (s.getPogruzkaIKs().size() == 0) {
                sertificatIKNeIspList.add(s);
            } else {
                sertificatIKList.add(s);
            }
        }
        return sertificatIKList;
    }

    public List<SertificatIK> sertificatIKNeIspList() {
        return sertificatIKNeIspList;
    }

    @Transactional
    @Override
    public List<SertificatIK> sertificatIKBezPoluchatelyaList() {
        return sertificatIKDAO.sertificatIKBezPoluchatelyaList();
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
        sertificatIK.setPokupatel(pokupatelService.retrivePokupatel(sertificatIK.getPokupatel().getId()));
        sertificatIKDAO.saveSertificatIK(sertificatIK);
    }

    @Transactional
    @Override
    public Boolean searchSertificatIKByNomerAndGod(int id, String nomer, Date data) {
        return sertificatIKDAO.searchSertificatIKByNomerAndGod(id, nomer, data);
    }

    @Transactional
    @Override
    public List<SertificatIK> searchSertificatIKByData(Date date) {
        return sertificatIKDAO.searchSertificatIKByData(date);
    }
}
