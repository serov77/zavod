package ru.solicom.zavod.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solicom.zavod.dao.PokupatelDAO;
import ru.solicom.zavod.domain.Pokupatel;

@Service
public class PokupatelServiceImpl implements PokupatelService {

    @Autowired
    private PokupatelDAO pokupatelDAO;

    @Transactional
    @Override
    public List<Pokupatel> pokupatelList() {
        return pokupatelDAO.pokupatelList();
    }

    @Transactional
    @Override
    public List<Pokupatel> searchPokupatelList(String s) {
        return pokupatelDAO.searchPokupatelList(s);
    }

    @Transactional
    @Override
    public Boolean searchPokupatelByName(String name, int id) {
        return pokupatelDAO.searchPokupatelByName(name, id);
    }

    @Transactional
    @Override
    public Boolean searchPokupatelByKod(String kod, int id) {
        return pokupatelDAO.searchPokupatelByKod(kod, id);
    }

    @Transactional
    @Override
    public Boolean searchRokupatelByOKPO(String okpo, int id) {
        return pokupatelDAO.searchRokupatelByOKPO(okpo, id);
    }

    @Transactional
    @Override
    public void savePokupatel(Pokupatel pokupatel) {
        pokupatelDAO.savePokupatel(pokupatel);
    }

    @Transactional
    @Override
    public Pokupatel retrivePokupatel(int id) {
        return pokupatelDAO.retrivePokupatel(id);
    }

}
