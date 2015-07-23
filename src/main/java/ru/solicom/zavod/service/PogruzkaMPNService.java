package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.PogruzkaMPN;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
import java.util.List;

public interface PogruzkaMPNService {
    public List<PogruzkaMPN> pogruzkaMPNList();

    public List<PogruzkaMPN> pogruzkaMPNNaLiniiList();

    public StatusVaiona searchPogruzkaMPNVagonaZaDen(Vagon vagon, Date date);
}
