package ru.solicom.zavod.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.VagonDAO;
import ru.solicom.zavod.domain.Vagon;

@Service
public class VagonServiceImpl implements VagonService {

    @Autowired
    private VagonDAO vagonDAO;

    @Transactional
    @Override
    public List<Vagon> vagonList() {
        return vagonDAO.vagonList();
    }

    @Transactional
    @Override
    public Vagon retriveVagon(int id) {
        return vagonDAO.retriveVagon(id);
    }

    @Transactional
    @Override
    public void saveVagon(Vagon vagon) {
        if ("".equals(vagon.getNomerVagona())) {
            vagon.setNomerVagona(null);
        }
        if (vagon.getDataDobavleniya() == null) {
            Date today = new Date();
            vagon.setDataDobavleniya(today);
        }
        vagonDAO.saveVagon(vagon);
    }

    @Transactional
    @Override
    public List<Vagon> searchVagonList(String s) {
        return vagonDAO.searchVagonList(s);
    }

    @Transactional
    @Override
    public Boolean searchVagonByNomerVagona(String nomer, int id) {
        return vagonDAO.searchVagonByNomerVagona(nomer, id);
    }

    @Transactional
    @Override
    public int[] kolichectvoVagonov() {
        return vagonDAO.kolichectvoVagonov();
    }

}
