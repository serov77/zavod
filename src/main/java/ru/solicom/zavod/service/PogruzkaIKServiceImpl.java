package ru.solicom.zavod.service;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.NomeraOtpravkiDAO;
import ru.solicom.zavod.dao.PogruzkaIKDAO;
import ru.solicom.zavod.domain.NomeraOtpravki;
import ru.solicom.zavod.domain.PogruzkaIK;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.domain.VagoniPoroznie;
import ru.solicom.zavod.util.StatusVaiona;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class PogruzkaIKServiceImpl implements PogruzkaIKService {
    @Autowired
    private PogruzkaIKDAO pogruzkaIKDAO;
    @Autowired
    private NomeraOtpravkiDAO nomeraOtpravkiDAO;
    @Autowired
    private VagoniPoroznieService vagoniPoroznieService;

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
        if (pogruzkaIK.getNomerOtpravki() == 0) {
            int nomerOtpravki;
            try {
                nomerOtpravki = nomeraOtpravkiDAO.posledniyNomer();
            } catch (Exception e) {
                nomeraOtpravkiDAO.saveNomer(new NomeraOtpravki());
                nomerOtpravki = nomeraOtpravkiDAO.posledniyNomer();
            }
            nomeraOtpravkiDAO.saveNomer(new NomeraOtpravki());
            pogruzkaIK.setNomerOtpravki((nomerOtpravki));
        }
        VagoniPoroznie poroznie = pogruzkaIK.getVagonPorozniy();
        poroznie.setDataPogruzki(pogruzkaIK.getDataPogruzki());
        pogruzkaIKDAO.savePogruzkaIK(pogruzkaIK);
        vagoniPoroznieService.otmetkaPogruzen(poroznie);
    }

    @Override
    public StatusVaiona searchPogruzkaIKVagonaZaDen(Vagon vagon, LocalDate date) throws ParseException {
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
            if (x > gruzopodyomnost || !(x > 0)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public PogruzkaIK retrivePogruzkaIK(int id) {
        return pogruzkaIKDAO.retrivePogruzkaIK(id);
    }

    @Override
    public List<PogruzkaIK> searchPogruzkaIKBySertificat(int id) {
        return pogruzkaIKDAO.searchPogruzkaIKBySertificat(id);
    }

    @Override
    public List<PogruzkaIK> searchPogruzkaIKMesyac(LocalDate x1, LocalDate x2) {
        return  pogruzkaIKDAO.searchPogruzkaIKMesyac(x1, x2);
    }
}
