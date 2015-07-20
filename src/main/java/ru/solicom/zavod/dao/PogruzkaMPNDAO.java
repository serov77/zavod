package ru.solicom.zavod.dao;

import ru.solicom.zavod.domain.PogruzkaMPN;

import java.util.List;

public interface PogruzkaMPNDAO {
    public List<PogruzkaMPN> pogruzkaMPNList();

    public List<PogruzkaMPN> pogruzkaMPNNaLiniiList();
}
