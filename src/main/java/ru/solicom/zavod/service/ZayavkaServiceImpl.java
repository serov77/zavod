package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.ZayavkaDAO;
import ru.solicom.zavod.domain.Zayavka;

@Service
public class ZayavkaServiceImpl implements ZayavkaService {
    @Autowired
    private ZayavkaDAO zayavkaDAO;

    @Transactional
    @Override
    public Zayavka nullZayavka() {
        return zayavkaDAO.nullZayavka();
    }
}
