package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.PogruzkaIK;

import java.util.List;

public interface PogruzkaIKService {
    public List<PogruzkaIK> pogruzkaIKList();

    public List<PogruzkaIK> pogruzkaIKNaLiniiList();

    public void savePogruzkaIK(PogruzkaIK pogruzkaIK);
}
