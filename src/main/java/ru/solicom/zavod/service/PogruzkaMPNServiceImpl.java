package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.PogruzkaMPNDAO;
import ru.solicom.zavod.domain.PogruzkaMPN;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PogruzkaMPNServiceImpl implements PogruzkaMPNService{
    @Autowired
    private PogruzkaMPNDAO pogruzkaMPNDAO;
    @Override
    public List<PogruzkaMPN> pogruzkaMPNList() {
        return pogruzkaMPNDAO.pogruzkaMPNList();
    }

    @Override
    public List<PogruzkaMPN> pogruzkaMPNNaLiniiList() {
        return pogruzkaMPNDAO.pogruzkaMPNNaLiniiList();
    }

    @Override
    public void savePogruzkaMPN(PogruzkaMPN pogruzkaMPN) {
        pogruzkaMPNDAO.savePogruzkaMPN(pogruzkaMPN);
    }

    @Override
    public StatusVaiona searchPogruzkaMPNVagonaZaDen(Vagon vagon, Date date) {
        return pogruzkaMPNDAO.searchPogruzkaMPNVagonaZaDen(vagon, date);
    }

    @Override
    public Boolean searchPogruzkaMPNMKR(int id) {
        return pogruzkaMPNDAO.searchPogruzkaMPNMKR(id);
    }

    @Override
    public Boolean searchPogruzkaMPN(int id, float gruzopodyomnost, float tara) {
        List<PogruzkaMPN> list = pogruzkaMPNDAO.searchPogruzkaMPN(id);
        for(PogruzkaMPN p: list){
            if (p.getBrutto() - tara > gruzopodyomnost) {
                return false;
            }
        }
        return true;
    }

    @Override
    public PogruzkaMPN retrivePogruzkaMPN(int id) {
        return pogruzkaMPNDAO.retrivePogruzkaMPN(id);
    }


}
