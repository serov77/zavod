package ru.solicom.zavod.dao;

import java.util.List;
import ru.solicom.zavod.domain.Pokupatel;

public interface PokupatelDAO {

    public List<Pokupatel> pokupatelList();

    public List<Pokupatel> pokupatelListBezPustogo();

    public List<Pokupatel> searchPokupatelList(String s);

    public Boolean searchPokupatelByName(String name, int id);

    public Boolean searchPokupatelByKod(String kod, int id);

    public Boolean searchRokupatelByOKPO(String okpo, int id);

    public void savePokupatel(Pokupatel pokupatel);

    public Pokupatel retrivePokupatel(int id);
}
