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
    public Boolean searchPogruzkaMPNMKR(Vagon vagon) {
        return pogruzkaMPNDAO.searchPogruzkaMPNMKR(vagon);
    }
}
