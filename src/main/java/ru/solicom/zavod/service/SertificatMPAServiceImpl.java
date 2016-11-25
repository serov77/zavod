package ru.solicom.zavod.service;


import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.SertificatMPADAO;
import ru.solicom.zavod.domain.SertificatMPA;

import java.util.ArrayList;
import java.util.List;
@Service
public class SertificatMPAServiceImpl implements SertificatMPAService{

    @Autowired
    private SertificatMPADAO sertificatMPADAO;
    @Autowired
    private PokupatelService pokupatelService;
    @Autowired
    private StationService stationService;
    private List<SertificatMPA> sertificatMPANeIspList = new ArrayList<>();
    private List<SertificatMPA> sertificatMPAList = new ArrayList<>();


    @Override
    public List<SertificatMPA> sertificatMPAListDlyaOformleniya() {
        return sertificatMPADAO.sertificatMPAList();
    }

    @Transactional
    @Override
    public List<SertificatMPA> sertificatMPAList() {
        sertificatMPAList.clear();
        sertificatMPANeIspList.clear();
        List<SertificatMPA> list = sertificatMPADAO.sertificatMPAList();
        for (SertificatMPA s : list) {
            if (s.getPogruzkaMPAs().size() == 0) {
                sertificatMPANeIspList.add(s);
            } else {
                sertificatMPAList.add(s);
            }
        }
        return sertificatMPAList;
    }

    @Transactional
    @Override
    public List<SertificatMPA> sertificatMPANeIspList() {
        return sertificatMPANeIspList;
    }

    @Transactional
    @Override
    public List<SertificatMPA> sertificatMPABezPoluchatelyaList() {
        return sertificatMPADAO.sertificatMPABezPoluchatelyaList();
    }

    @Transactional
    @Override
    public SertificatMPA retriveSertificatMPA(int id) {
        return sertificatMPADAO.retriveSertificatMPA(id);
    }

    @Transactional
    @Override
    public void saveSertificatMPA(SertificatMPA sertificatMPA) {
        if (sertificatMPA.getData() == null) {
            LocalDate today = LocalDate.now();
            sertificatMPA.setData(today);
        }
        sertificatMPA.setPokupatel(pokupatelService.retrivePokupatel(sertificatMPA.getPokupatel().getId()));
        sertificatMPA.setStation(stationService.retriveStation(sertificatMPA.getStation().getId()));
        sertificatMPADAO.saveSertificatMPA(sertificatMPA);
    }

    @Transactional
    @Override
    public Boolean searchSertificatMPAByNomerAndGod(int id, String nomer, LocalDate data) {
        return sertificatMPADAO.searchSertificatMPAByNomerAndGod(id, nomer, data);
    }

    @Transactional
    @Override
    public List<SertificatMPA> searchSertificatMPAByData(LocalDate date) {
        return sertificatMPADAO.searchSertificatMPAByData(date);
    }
}
