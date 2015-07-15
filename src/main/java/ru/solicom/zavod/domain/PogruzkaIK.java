package ru.solicom.zavod.domain;

import ru.solicom.zavod.domain.base.BaseDomainPogruzka;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "pogruzka_ik")
public class PogruzkaIK extends BaseDomainPogruzka implements Serializable{
    @ManyToOne
    @JoinColumn(name = "id_sertificat")
    private SertificatIK sertificatIK;

    public SertificatIK getSertificatIK() {
        return sertificatIK;
    }

    public void setSertificatIK(SertificatIK sertificatIK) {
        this.sertificatIK = sertificatIK;
    }
}
