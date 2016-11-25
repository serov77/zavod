package ru.solicom.zavod.service;

import java.util.List;
import ru.solicom.zavod.domain.Gruz;

public interface GruzService {

    public List<Gruz> gruzList();
    public Gruz retriveGruz(int id);
    public List<Gruz> opasniyGrusList();
    public List<Gruz> neOpasniyGrusList();
}
