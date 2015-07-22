package ru.solicom.zavod.fasade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solicom.zavod.domain.Vagon;
import ru.solicom.zavod.service.PogruzkaIKService;
import ru.solicom.zavod.service.PogruzkaIMService;
import ru.solicom.zavod.service.PogruzkaMPNService;
import ru.solicom.zavod.util.StatusVaiona;

import java.util.Date;
@Service
public class PogruzkaServiceimpl implements PogruzkaService {
    @Autowired
    private PogruzkaIKService pogruzkaIKService;
    @Autowired
    private PogruzkaIMService pogruzkaIMService;
    @Autowired
    private PogruzkaMPNService pogruzkaMPNService;

    @Override
    public Boolean searchPogruzka(Vagon vagon) {
       StatusVaiona x = pogruzkaIKService.searchPogruzkaIKVagonaZaDen(vagon, new Date());


        return false;
    }
}
