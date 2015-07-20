package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.PogruzkaMPN;

import java.util.List;

public interface PogruzkaMPNService {
    public List<PogruzkaMPN> pogruzkaMPNList();

    public List<PogruzkaMPN> pogruzkaMPNNaLiniiList();
}
