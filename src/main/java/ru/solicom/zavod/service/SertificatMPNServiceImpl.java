package ru.solicom.zavod.service;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.SertificatMPNDAO;
import ru.solicom.zavod.domain.SertificatMPN;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SertificatMPNServiceImpl implements SertificatMPNService {
    @Autowired
    private SertificatMPNDAO sertificatMPNDAO;
    @Autowired
    private PokupatelService pokupatelService;
    @Autowired
    private StationService stationService;
    private List<SertificatMPN> sertificatMPNNeIspList = new ArrayList<>();
    private List<SertificatMPN> sertificatMPNList = new ArrayList<>();


    @Override
    public List<SertificatMPN> sertificatMPNListDlyaOformleniya() {
        return sertificatMPNDAO.sertificatMPNList();
    }

    @Transactional
    @Override
    public List<SertificatMPN> sertificatMPNList() {
        sertificatMPNList.clear();
        sertificatMPNNeIspList.clear();
        List<SertificatMPN> list = sertificatMPNDAO.sertificatMPNList();
        for (SertificatMPN s : list) {
            if (s.getPogruzkaMPNs().size() == 0) {
                sertificatMPNNeIspList.add(s);
            } else {
                sertificatMPNList.add(s);
            }
        }
        return sertificatMPNList;
    }

    @Transactional
    @Override
    public List<SertificatMPN> sertificatMPNNeIspList() {
        return sertificatMPNNeIspList;
    }

    @Transactional
    @Override
    public List<SertificatMPN> sertificatMPNBezPoluchatelyaList() {
        return sertificatMPNDAO.sertificatMPNBezPoluchatelyaList();
    }

    @Transactional
    @Override
    public SertificatMPN retriveSertificatMPN(int id) {
        return sertificatMPNDAO.retriveSertificatMPN(id);
    }

    @Transactional
    @Override
    public void saveSertificatMPN(SertificatMPN sertificatMPN) {
        if (sertificatMPN.getData() == null) {
            LocalDate today = LocalDate.now();
            sertificatMPN.setData(today);
        }
        sertificatMPN.setPokupatel(pokupatelService.retrivePokupatel(sertificatMPN.getPokupatel().getId()));
        sertificatMPN.setStation(stationService.retriveStation(sertificatMPN.getStation().getId()));
        sertificatMPNDAO.saveSertificatMPN(sertificatMPN);
    }

    @Transactional
    @Override
    public Boolean searchSertificatMPNByNomerAndGod(int id, String nomer, LocalDate data) {
        return sertificatMPNDAO.searchSertificatMPNByNomerAndGod(id, nomer, data);
    }

    @Transactional
    @Override
    public List<SertificatMPN> searchSertificatMPNByData(LocalDate date) {
        return sertificatMPNDAO.searchSertificatMPNByData(date);
    }
}
