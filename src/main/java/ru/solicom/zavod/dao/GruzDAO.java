package ru.solicom.zavod.dao;

import java.util.List;
import ru.solicom.zavod.domain.Gruz;

public interface GruzDAO {

    public List<Gruz> gruzList();
    public Gruz retriveGruz(int id);
    public List<Gruz> opasniyGrusList();
    public List<Gruz> neOpasniyGrusList();
}
