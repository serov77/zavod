package ru.solicom.zavod.service;


import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.SertificatIMDAO;
import ru.solicom.zavod.domain.SertificatIM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SertificatIMServiceImpl implements SertificatIMService {

    @Autowired
    private SertificatIMDAO sertificatIMDAO;
    @Autowired
    private PokupatelService pokupatelService;
    @Autowired
    private StationService stationService;
    private List<SertificatIM> sertificatIMNeIspList = new ArrayList<>();
    private List<SertificatIM> sertificatIMList = new ArrayList<>();

    @Transactional
    @Override
    public List<SertificatIM> sertificatIMNeIspList() {
        return sertificatIMNeIspList;
    }

    @Transactional
    @Override
    public List<SertificatIM> sertificatIMListDlyaOformleniya() {
        return sertificatIMDAO.sertificatIMList();
    }

    @Transactional
    @Override
    public List<SertificatIM> sertificatIMList() {
        sertificatIMList.clear();
        sertificatIMNeIspList.clear();
        List<SertificatIM> list = sertificatIMDAO.sertificatIMList();
        for (SertificatIM s : list) {
            if (s.getPogruzkaIMs().size() == 0) {
                sertificatIMNeIspList.add(s);
            } else {
                sertificatIMList.add(s);
            }
        }
        return sertificatIMList;
    }

    @Transactional
    @Override
    public List<SertificatIM> sertificatIMBezPoluchatelyaList() {
        return sertificatIMDAO.sertificatIMBezPoluchatelyaList();
    }

    @Transactional
    @Override
    public SertificatIM retriveSertificatIM(int id) {
        return sertificatIMDAO.retriveSertificatIM(id);
    }

    @Transactional
    @Override
    public void saveSertficatIM(SertificatIM sertificatIM) {
        if (sertificatIM.getData() == null) {
            LocalDate today = LocalDate.now();
            sertificatIM.setData(today);
        }
        sertificatIM.setPokupatel(pokupatelService.retrivePokupatel(sertificatIM.getPokupatel().getId()));
        sertificatIM.setStation(stationService.retriveStation(sertificatIM.getStation().getId()));
        sertificatIMDAO.saveSertificatIM(sertificatIM);
    }

    @Transactional
    @Override
    public Boolean searchSertificatIMByNomerAndGod(int id, String nomer, LocalDate data) {
        return sertificatIMDAO.searchSertificatIMByNomerAndGod(id, nomer, data);
    }

    @Transactional
    @Override
    public List<SertificatIM> searchSertificatIMByData(LocalDate date) {
        return sertificatIMDAO.searchSertificatIMByData(date);
    }
}
