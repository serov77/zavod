package ru.solicom.zavod.dao;

import ru.solicom.zavod.domain.SertificatIM;
import ru.solicom.zavod.domain.SertificatMPN;

import java.util.Date;
import java.util.List;

public interface SertificatMPNDAO {
    public List<SertificatMPN> sertificatMPNList();

    public SertificatMPN retriveSertificatMPN(int id);

    void saveSertificatMPN(SertificatMPN sertificatMPN);

    public Boolean searchSertificatMPNByNomerAndGod(int id, String nomer, Date data);
}
