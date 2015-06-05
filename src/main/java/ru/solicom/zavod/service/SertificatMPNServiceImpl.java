package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.SertificatMPNDAO;
import ru.solicom.zavod.domain.SertificatMPN;

import java.util.Date;
import java.util.List;

@Service
public class SertificatMPNServiceImpl implements SertificatMPNService {
    @Autowired
    private SertificatMPNDAO sertificatMPNDAO;

    @Transactional
    @Override
    public List<SertificatMPN> sertificatMPNList() {
        return sertificatMPNDAO.sertificatMPNList();
    }

    @Transactional
    @Override
    public SertificatMPN retriveSertificatMPN(int id) {
        return sertificatMPNDAO.retriveSertificatMPN(id);
    }

    @Transactional
    @Override
    public void saveSertificatMPN(SertificatMPN sertificatMPN) {
        sertificatMPNDAO.saveSertificatMPN(sertificatMPN);
    }

    @Transactional
    @Override
    public Boolean searchSertificatMPNByNomerAndGod(int id, String nomer, Date data) {
        return sertificatMPNDAO.searchSertificatMPNByNomerAndGod(id, nomer, data);
    }
}
