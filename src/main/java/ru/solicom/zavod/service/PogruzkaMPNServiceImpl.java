package ru.solicom.zavod.service;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.NomeraOtpravkiDAO;
import ru.solicom.zavod.dao.PogruzkaMPNDAO;
import ru.solicom.zavod.domain.NomeraOtpravki;
import ru.solicom.zavod.domain.PogruzkaMPN;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.domain.VagoniPoroznie;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.List;

@Service
@Transactional
public class PogruzkaMPNServiceImpl implements PogruzkaMPNService {
    @Autowired
    private PogruzkaMPNDAO pogruzkaMPNDAO;
    @Autowired
    private NomeraOtpravkiDAO nomeraOtpravkiDAO;
    @Autowired
    private VagoniPoroznieService vagoniPoroznieService;

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
        if (pogruzkaMPN.getNomerOtpravki() == 0) {
            int nomerOtpravki;
            try {
                nomerOtpravki = nomeraOtpravkiDAO.posledniyNomer();
            } catch (Exception e) {
                nomeraOtpravkiDAO.saveNomer(new NomeraOtpravki());
                nomerOtpravki = nomeraOtpravkiDAO.posledniyNomer();
            }
            nomeraOtpravkiDAO.saveNomer(new NomeraOtpravki());
            pogruzkaMPN.setNomerOtpravki((nomerOtpravki));
        }
        VagoniPoroznie poroznie = pogruzkaMPN.getVagonPorozniy();
        poroznie.setDataPogruzki(pogruzkaMPN.getDataPogruzki());
        pogruzkaMPNDAO.savePogruzkaMPN(pogruzkaMPN);
        vagoniPoroznieService.otmetkaPogruzen(poroznie);
    }

    @Override
    public StatusVaiona searchPogruzkaMPNVagonaZaDen(Vagon vagon, LocalDate date) {
        return pogruzkaMPNDAO.searchPogruzkaMPNVagonaZaDen(vagon, date);
    }

    @Override
    public Boolean searchPogruzkaMPNMKR(int id) {
        return pogruzkaMPNDAO.searchPogruzkaMPNMKR(id);
    }

    @Override
    public Boolean searchPogruzkaMPN(int id, float gruzopodyomnost, float tara) {
        List<PogruzkaMPN> list = pogruzkaMPNDAO.searchPogruzkaMPN(id);
        for (PogruzkaMPN p : list) {
            float x = p.getBrutto() - tara;
            if (x > gruzopodyomnost || !(x > 0)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public PogruzkaMPN retrivePogruzkaMPN(int id) {
        return pogruzkaMPNDAO.retrivePogruzkaMPN(id);
    }

    @Override
    public List<PogruzkaMPN> searchPogruzkaMPNBySertificat(int id) {
        return pogruzkaMPNDAO.searchPogruzkaMPNBySertificat(id);
    }

    @Override
    public List<PogruzkaMPN> searchPogruzkaMPNMesyac(LocalDate x1, LocalDate x2) {
        return pogruzkaMPNDAO.searchPogruzkaMPAMesyac(x1, x2);
    }
}
