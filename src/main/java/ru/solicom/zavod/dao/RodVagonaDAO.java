package ru.solicom.zavod.dao;

import java.util.List;
import ru.solicom.zavod.domain.RodVagona;

public interface RodVagonaDAO {

    public List<RodVagona> rodVagonaList();
    public RodVagona retriveRodVagona(int id);
}
