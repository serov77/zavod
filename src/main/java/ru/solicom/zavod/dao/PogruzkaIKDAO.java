package ru.solicom.zavod.dao;


import ru.solicom.zavod.domain.PogruzkaIK;

import java.util.List;

public interface PogruzkaIKDAO {
    public List<PogruzkaIK> pogruzkaIKList();

    public List<PogruzkaIK> pogruzkaIKNaLiniiList();
}
