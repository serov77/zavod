package ru.solicom.zavod.service;

import java.util.List;
import ru.solicom.zavod.domain.Vagon;

public interface VagonService {

    public List<Vagon> vagonList();

    public Vagon retriveVagon(int id);

    public void saveVagon(Vagon vagon);

    public List<Vagon> searchVagonList(String s);

    public Boolean searchVagonByNomerVagona(String nomer, int id);

    public int[] kolichectvoVagonov();
}
