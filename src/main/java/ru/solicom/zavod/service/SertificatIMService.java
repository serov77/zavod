package ru.solicom.zavod.service;

import ru.solicom.zavod.domain.SertificatIM;

import java.util.Date;
import java.util.List;

public interface SertificatIMService {
    public List<SertificatIM> sertificatIMListDlyaOformleniya();

    public List<SertificatIM> sertificatIMList();

    public List<SertificatIM> sertificatIMNeIspList();

    public List<SertificatIM> sertificatIMBezPoluchatelyaList();

    public SertificatIM retriveSertificatIM(int id);

    public void saveSertficatIM(SertificatIM sertificatIM);

    public Boolean searchSertificatIMByNomerAndGod(int id, String nomer, Date data);

    public List<SertificatIM> searchSertificatIMByData(Date date);
}
