package ru.solicom.zavod.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.GruzDAO;
import ru.solicom.zavod.domain.Gruz;

@Service
public class GruzServiceImpl implements GruzService {

    @Autowired
    private GruzDAO gruzDAO;


    @Transactional
    @Override
    public List<Gruz> gruzList() {
        return gruzDAO.gruzList();
    }

}
