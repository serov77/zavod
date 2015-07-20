package ru.solicom.zavod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.PogruzkaMPNDAO;
import ru.solicom.zavod.domain.PogruzkaMPN;

import java.util.List;

@Service
@Transactional
public class PogruzkaMPNServiceImpl implements PogruzkaMPNService{
    @Autowired
    private PogruzkaMPNDAO pogruzkaMPNDAO;
    @Override
    public List<PogruzkaMPN> pogruzkaMPNList() {
        return pogruzkaMPNDAO.pogruzkaMPNList();
    }

    @Override
    public List<PogruzkaMPN> pogruzkaMPNNaLiniiList() {
        return pogruzkaMPNDAO.pogruzkaMPNNaLiniiList();
    }
}
