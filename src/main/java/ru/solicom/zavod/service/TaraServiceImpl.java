package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.TaraDAO;
import ru.solicom.zavod.domain.Tara;

import java.util.List;

@Service
@Transactional
public class TaraServiceImpl implements TaraService {
    @Autowired
    private TaraDAO taraDAO;

    @Override
    public List<Tara> taraList() {
        return taraDAO.taraList();
    }

    @Override
    public List<Tara> taraBezMKRList() {
        return taraDAO.taraBezMKRList();
    }
}
