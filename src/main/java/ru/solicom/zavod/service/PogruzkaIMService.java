package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.PogruzkaIM;

import java.util.List;

public interface PogruzkaIMService {
    public List<PogruzkaIM> pogruzkaIMList();

    public List<PogruzkaIM> pogruzkaIMNaLiniiList();
}
