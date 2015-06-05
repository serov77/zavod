
package ru.solicom.zavod.service;

import java.util.List;
import ru.solicom.zavod.domain.RodVagona;

public interface RodVagonaService {
    public List<RodVagona> rodVagonaList();
    public RodVagona retriveRodVagona(int id);
}
