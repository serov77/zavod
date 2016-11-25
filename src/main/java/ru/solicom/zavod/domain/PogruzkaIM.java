package ru.solicom.zavod.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    @JoinColumn(name = "id_sertificat")
    private SertificatIM sertificatIM;

    public SertificatIM getSertificatIM() {
        return sertificatIM;
    }

    public void setSertificatIM(SertificatIM sertificatIM) {
        this.sertificatIM = sertificatIM;
    }
}
