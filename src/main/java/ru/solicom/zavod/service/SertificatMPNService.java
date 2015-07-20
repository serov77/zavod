package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.SertificatMPN;

import java.util.Date;
import java.util.List;

public interface SertificatMPNService {
    public List<SertificatMPN> sertificatMPNList();

    public List<SertificatMPN> sertificatMPNNeIspList();

    public List<SertificatMPN> sertificatMPNBezPoluchatelyaList();

    public SertificatMPN retriveSertificatMPN(int id);

    void saveSertificatMPN(SertificatMPN sertificatMPN);

    public Boolean searchSertificatMPNByNomerAndGod(int id, String nomer, Date data);
}
