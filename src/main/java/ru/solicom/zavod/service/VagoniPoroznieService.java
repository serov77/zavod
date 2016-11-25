package ru.solicom.zavod.service;

import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.domain.VagoniPoroznie;
import java.util.List;

public interface VagoniPoroznieService {
    public List<VagoniPoroznie> vagoniPoroznieList();
    public List<VagoniPoroznie> vagoniPoroznieIzvestList();
    public List<VagoniPoroznie> vagoniPoroznieListZayavka(LocalDate date);
    public void saveVagonPorozniy(VagoniPoroznie vagoniPoroznie);
    public int maxNomerSvidetelstva();
    public Boolean statusPoroznegoVagona(Vagon vagon);
    public VagoniPoroznie retriveVagonPorozniy (int id);
    public void otmetkaPogruzen (VagoniPoroznie id);
    public void deleteOtmetkaPogruzen (VagoniPoroznie id);
}
