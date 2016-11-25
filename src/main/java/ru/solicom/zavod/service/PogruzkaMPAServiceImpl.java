package ru.solicom.zavod.service;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.NomeraOtpravkiDAO;
import ru.solicom.zavod.dao.PogruzkaMPADAO;
import ru.solicom.zavod.domain.NomeraOtpravki;
import ru.solicom.zavod.domain.PogruzkaMPA;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.domain.VagoniPoroznie;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.List;

@Service
@Transactional
public class PogruzkaMPAServiceImpl implements PogruzkaMPAService {

    @Autowired
    private PogruzkaMPADAO pogruzkaMPADAO;
    @Autowired
    private NomeraOtpravkiDAO nomeraOtpravkiDAO;
    @Autowired
    private VagoniPoroznieService vagoniPoroznieService;

    @Override
    public List<PogruzkaMPA> pogruzkaMPAList() {
        return pogruzkaMPADAO.pogruzkaMPAList();
    }

    @Override
    public List<PogruzkaMPA> pogruzkaMPANaLiniiList() {
        return pogruzkaMPADAO.pogruzkaMPANaLiniiList();
    }

    @Override
    public void savePogruzkaMPA(PogruzkaMPA pogruzkaMPA) {
        if (pogruzkaMPA.getNomerOtpravki() == 0) {
            int nomerOtpravki;
            try {
                nomerOtpravki = nomeraOtpravkiDAO.posledniyNomer();
            } catch (Exception e) {
                nomeraOtpravkiDAO.saveNomer(new NomeraOtpravki());
                nomerOtpravki = nomeraOtpravkiDAO.posledniyNomer();
            }
            nomeraOtpravkiDAO.saveNomer(new NomeraOtpravki());
            pogruzkaMPA.setNomerOtpravki((nomerOtpravki));
        }
        VagoniPoroznie poroznie = pogruzkaMPA.getVagonPorozniy();
        poroznie.setDataPogruzki(pogruzkaMPA.getDataPogruzki());
        pogruzkaMPADAO.savePogruzkaMPA(pogruzkaMPA);
        vagoniPoroznieService.otmetkaPogruzen(poroznie);
    }

    @Override
    public StatusVaiona searchPogruzkaMPAVagonaZaDen(Vagon vagon, LocalDate date) {
        return pogruzkaMPADAO.searchPogruzkaMPAVagonaZaDen(vagon, date);
    }

    @Override
    public Boolean searchPogruzkaMPAMKR(int id) {
        return pogruzkaMPADAO.searchPogruzkaMPAMKR(id);
    }

    @Override
    public Boolean searchPogruzkaMPA(int id, float gruzopodyomnost, float tara) {
        List<PogruzkaMPA> list = pogruzkaMPADAO.searchPogruzkaMPA(id);
        for (PogruzkaMPA p : list) {
            float x = p.getBrutto() - tara;
            if (x > gruzopodyomnost || !(x > 0)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public PogruzkaMPA retrivePogruzkaMPA(int id) {
        return pogruzkaMPADAO.retrivePogruzkaMPA(id);
    }

    @Override
    public List<PogruzkaMPA> searchPogruzkaMPABySertificat(int id) {
        return pogruzkaMPADAO.searchPogruzkaMPABySertificat(id);
    }

    @Override
    public List<PogruzkaMPA> searchPogruzkaMPAMesyac(LocalDate x1, LocalDate x2) {
        return pogruzkaMPADAO.searchPogruzkaMPAMesyac(x1, x2);
    }
}
