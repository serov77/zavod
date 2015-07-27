package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.PogruzkaIMDAO;
import ru.solicom.zavod.domain.PogruzkaIM;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PogruzkaIMServiceImpl implements PogruzkaIMService {
    @Autowired
    private PogruzkaIMDAO pogruzkaIMDAO;

    @Override
    public List<PogruzkaIM> pogruzkaIMList() {
        return pogruzkaIMDAO.pogruzkaIMList();
    }

    @Override
    public List<PogruzkaIM> pogruzkaIMNaLiniiList() {
        return pogruzkaIMDAO.pogruzkaIMNaLiniiList();
    }

    @Override
    public void savePogruzkaIM(PogruzkaIM pogruzkaIM) {
        pogruzkaIMDAO.savePogruzkaIM(pogruzkaIM);
    }

    @Override
    public StatusVaiona searchPogruzkaIMVagonaZaDen(Vagon vagon, Date date) {
        return pogruzkaIMDAO.searchPogruzkaIMVagonaZaDen(vagon, date);
    }

    @Override
    public Boolean searchPogruzkaIMMKR(int id) {
        return pogruzkaIMDAO.searchPogruzkaIMMKR(id);
    }

    @Override
    public Boolean searchPogruzkaIM(int id, float gruzopodyomnost, float tara) {
        List<PogruzkaIM> list = pogruzkaIMDAO.searchPogruzkaIM(id);
        for(PogruzkaIM p: list){
            if (p.getBrutto() - tara > gruzopodyomnost) {
                return false;
            }
        }
        return true;
    }
}
