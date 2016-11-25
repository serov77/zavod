package ru.solicom.zavod.dao;

import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.SertificatIM;
import ru.solicom.zavod.domain.SertificatMPN;

import java.util.Date;
import java.util.List;

public interface SertificatMPNDAO {
    public List<SertificatMPN> sertificatMPNList();

    public List<SertificatMPN> sertificatMPNBezPoluchatelyaList();

    public SertificatMPN retriveSertificatMPN(int id);

    void saveSertificatMPN(SertificatMPN sertificatMPN);

    public Boolean searchSertificatMPNByNomerAndGod(int id, String nomer, LocalDate data);

    public List<SertificatMPN> searchSertificatMPNByData(LocalDate date);
}
