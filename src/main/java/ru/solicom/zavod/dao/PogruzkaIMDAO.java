package ru.solicom.zavod.dao;

import ru.solicom.zavod.domain.PogruzkaIM;

import java.util.List;

public interface PogruzkaIMDAO {
    public List<PogruzkaIM> pogruzkaIMList();

    public List<PogruzkaIM> pogruzkaIMNaLiniiList();
}
