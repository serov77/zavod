package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.PogruzkaIMDAO;
import ru.solicom.zavod.domain.PogruzkaIM;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PogruzkaIMServiceImpl implements PogruzkaIMService {
    @Autowired
    private PogruzkaIMDAO pogruzkaIMDAO;

    @Override
    public List<PogruzkaIM> pogruzkaIMList() {
        return pogruzkaIMDAO.pogruzkaIMList();
    }

    @Override
    public List<PogruzkaIM> pogruzkaIMNaLiniiList() {
        return pogruzkaIMDAO.pogruzkaIMNaLiniiList();
    }

    @Override
    public StatusVaiona searchPogruzkaIMVagonaZaDen(Vagon vagon, Date date) {
        return pogruzkaIMDAO.searchPogruzkaIMVagonaZaDen(vagon, date);
    }
}
