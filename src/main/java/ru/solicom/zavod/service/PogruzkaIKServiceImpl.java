package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.PogruzkaIKDAO;
import ru.solicom.zavod.domain.PogruzkaIK;

import java.util.List;

@Service
@Transactional
public class PogruzkaIKServiceImpl implements PogruzkaIKService {
    @Autowired
    private PogruzkaIKDAO pogruzkaIKDAO;

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
        pogruzkaIKDAO.savePogruzkaIK(pogruzkaIK);
    }
}
