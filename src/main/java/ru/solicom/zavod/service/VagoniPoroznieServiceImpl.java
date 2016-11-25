package ru.solicom.zavod.service;


import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.VagoniPoroznieDAO;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.domain.VagoniPoroznie;

import java.util.List;

@Service
public class VagoniPoroznieServiceImpl implements VagoniPoroznieService {

    @Autowired
    private VagoniPoroznieDAO vagoniPoroznieDAO;

    @Transactional
    @Override
    public List<VagoniPoroznie> vagoniPoroznieList() {
        return vagoniPoroznieDAO.vagoniPoroznieList();
    }

    @Transactional
    @Override
    public List<VagoniPoroznie> vagoniPoroznieIzvestList() {
        return vagoniPoroznieDAO.vagoniPoroznieIzvestList();
    }

    @Transactional
    @Override
    public List<VagoniPoroznie> vagoniPoroznieListZayavka(LocalDate date) {
        return vagoniPoroznieDAO.vagoniPoroznieListZayavka(date);
    }

    @Transactional
    @Override
    public void saveVagonPorozniy(VagoniPoroznie vagoniPoroznie) {
        vagoniPoroznieDAO.saveVagonPorozniy(vagoniPoroznie);
    }

    @Transactional
    @Override
    public int maxNomerSvidetelstva() {
        try {
            int i = vagoniPoroznieDAO.maxNomerSvidetelstva();
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

    @Transactional
    @Override
    public Boolean statusPoroznegoVagona(Vagon vagon) {
        try {
            return vagoniPoroznieDAO.statusPoroznegoVagona(vagon);
        } catch (Exception e) {
            return true;
        }
    }

    @Transactional
    @Override
    public VagoniPoroznie retriveVagonPorozniy(int id) {
        return vagoniPoroznieDAO.retriveVagonPorozniy(id);
    }

    @Override
    public void otmetkaPogruzen(VagoniPoroznie id) {
        vagoniPoroznieDAO.otmetkaPogruzen(id);
    }

    @Override
    public void deleteOtmetkaPogruzen(VagoniPoroznie vagon) {
        vagoniPoroznieDAO.deleteOtmetkaPogruzen(vagon);
    }
}
