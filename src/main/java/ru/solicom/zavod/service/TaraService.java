package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.Tara;

import java.util.List;

public interface TaraService {
    public List<Tara> taraList();

    public List<Tara> taraBezMKRList();
}
