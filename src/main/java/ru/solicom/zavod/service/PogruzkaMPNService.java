package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.PogruzkaMPN;
import ru.solicom.zavod.domain.Vagon;

import java.util.Date;
import java.util.List;

public interface PogruzkaMPNService {
    public List<PogruzkaMPN> pogruzkaMPNList();

    public List<PogruzkaMPN> pogruzkaMPNNaLiniiList();

    public Boolean searchPogruzkaMPNVagonaZaDen(Vagon vagon, Date date);
}
