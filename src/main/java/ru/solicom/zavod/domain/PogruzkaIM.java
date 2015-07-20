package ru.solicom.zavod.domain;

import ru.solicom.zavod.domain.base.BaseDomainPogruzka;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "pogruzka_im")
public class PogruzkaIM extends BaseDomainPogruzka implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_sertificat")
    private SertificatIM sertificatIM;

    public SertificatIM getSertificatIM() {
        return sertificatIM;
    }

    public void setSertificatIM(SertificatIM sertificatIM) {
        this.sertificatIM = sertificatIM;
    }
}
