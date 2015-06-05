package ru.solicom.zavod.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.RodVagonaDAO;
import ru.solicom.zavod.domain.RodVagona;

@Service
public class RodVagonaServiceImpl implements RodVagonaService {

    @Autowired
    private RodVagonaDAO rodVagonaDao;

    @Transactional
    @Override
    public List<RodVagona> rodVagonaList() {
        return rodVagonaDao.rodVagonaList();
    }

    @Transactional
    @Override
    public RodVagona retriveRodVagona(int id) {
        return rodVagonaDao.retriveRodVagona(id);
    }

}
