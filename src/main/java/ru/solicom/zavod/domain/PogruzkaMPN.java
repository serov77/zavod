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
@Table(name = "pogruzka_mpn")
public class PogruzkaMPN extends BaseDomainPogruzka implements Serializable{
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_sertificat")
    private SertificatMPN sertificatMPN;

    public SertificatMPN getSertificatMPN() {
        return sertificatMPN;
    }

    public void setSertificatMPN(SertificatMPN sertificatMPN) {
        this.sertificatMPN = sertificatMPN;
    }
}
