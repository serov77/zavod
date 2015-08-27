package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.PogruzkaIKDAO;
import ru.solicom.zavod.domain.PogruzkaIK;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PogruzkaIKServiceImpl implements PogruzkaIKService {
    @Autowired
    private PogruzkaIKDAO pogruzkaIKDAO;

    @Override
    public List<PogruzkaIK> pogruzkaIKList() {
        return pogruzkaIKDAO.pogruzkaIKList();
    }

    @Override
    public List<PogruzkaIK> pogruzkaIKNaLiniiList() {
        return pogruzkaIKDAO.pogruzkaIKNaLiniiList();
    }

    @Override
    public void savePogruzkaIK(PogruzkaIK pogruzkaIK) {
        pogruzkaIKDAO.savePogruzkaIK(pogruzkaIK);
    }

    @Override
    public StatusVaiona searchPogruzkaIKVagonaZaDen(Vagon vagon, Date date) {
        return pogruzkaIKDAO.searchPogruzkaIKVagonaZaDen(vagon, date);
    }

    @Override
    public Boolean searchPogruzkaIKMKR(int id) {
        return pogruzkaIKDAO.searchPogruzkaIKMKR(id);
    }

    @Override
    public Boolean searchPogruzkaIK(int id, float gruzopodyomnost, float tara) {
        List<PogruzkaIK> list = pogruzkaIKDAO.searchPogruzkaIK(id);
        for (PogruzkaIK p : list) {
            float x = p.getBrutto() - tara;
            if (x > gruzopodyomnost) {
                return false;
            }
        }
        return true;
    }

    @Override
    public PogruzkaIK retrivePogruzkaIK(int id) {
        return pogruzkaIKDAO.retrivePogruzkaIK(id);
    }
}
