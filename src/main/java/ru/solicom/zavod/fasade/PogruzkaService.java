package ru.solicom.zavod.fasade;

import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.util.StatusVaiona;

public interface PogruzkaService {
    public StatusVaiona searchPogruzka(Vagon vagon);
}
