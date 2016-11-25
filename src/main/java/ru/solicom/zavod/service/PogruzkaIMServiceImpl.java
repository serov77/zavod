package ru.solicom.zavod.service;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.NomeraOtpravkiDAO;
import ru.solicom.zavod.dao.PogruzkaIMDAO;
import ru.solicom.zavod.domain.NomeraOtpravki;
import ru.solicom.zavod.domain.PogruzkaIM;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.domain.VagoniPoroznie;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.List;

@Service
@Transactional
public class PogruzkaIMServiceImpl implements PogruzkaIMService {
    @Autowired
    private PogruzkaIMDAO pogruzkaIMDAO;
    @Autowired
    private NomeraOtpravkiDAO nomeraOtpravkiDAO;
    @Autowired
    private VagoniPoroznieService vagoniPoroznieService;

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
        if (pogruzkaIM.getNomerOtpravki() == 0) {
            int nomerOtpravki;
            try {
                nomerOtpravki = nomeraOtpravkiDAO.posledniyNomer();
            } catch (Exception e) {
                nomeraOtpravkiDAO.saveNomer(new NomeraOtpravki());
                nomerOtpravki = nomeraOtpravkiDAO.posledniyNomer();
            }
            nomeraOtpravkiDAO.saveNomer(new NomeraOtpravki());
            pogruzkaIM.setNomerOtpravki((nomerOtpravki));
        }
        VagoniPoroznie poroznie = pogruzkaIM.getVagonPorozniy();
        poroznie.setDataPogruzki(pogruzkaIM.getDataPogruzki());
        pogruzkaIMDAO.savePogruzkaIM(pogruzkaIM);
        vagoniPoroznieService.otmetkaPogruzen(poroznie);
    }

    @Override
    public StatusVaiona searchPogruzkaIMVagonaZaDen(Vagon vagon, LocalDate date) {
        return pogruzkaIMDAO.searchPogruzkaIMVagonaZaDen(vagon, date);
    }

    @Override
    public Boolean searchPogruzkaIMMKR(int id) {
        return pogruzkaIMDAO.searchPogruzkaIMMKR(id);
    }

    @Override
    public Boolean searchPogruzkaIM(int id, float gruzopodyomnost, float tara) {
        List<PogruzkaIM> list = pogruzkaIMDAO.searchPogruzkaIM(id);
        for (PogruzkaIM p : list) {
            float x = p.getBrutto() - tara;
            if (x > gruzopodyomnost || !(x > 0)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public PogruzkaIM retrivePogruzkaIM(int id) {
        return pogruzkaIMDAO.retrivePogruzkaIM(id);
    }

    @Override
    public List<PogruzkaIM> searchPogruzkaIMBySertificat(int id) {
        return pogruzkaIMDAO.searchPogruzkaIMBySertificat(id);
    }

    @Override
    public List<PogruzkaIM> searchPogruzkaIMMesyac(LocalDate x1, LocalDate x2) {
        return pogruzkaIMDAO.searchPogruzkaIMMesyac(x1, x2);
    }
}
