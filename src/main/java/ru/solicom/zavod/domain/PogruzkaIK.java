package ru.solicom.zavod.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import ru.solicom.zavod.domain.base.BaseDomainPogruzka;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "pogruzka_ik")
public class PogruzkaIK extends BaseDomainPogruzka implements Serializable{
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_sertificat")
    private SertificatIK sertificatIK;

    public SertificatIK getSertificatIK() {
        return sertificatIK;
    }

    public void setSertificatIK(SertificatIK sertificatIK) {
        this.sertificatIK = sertificatIK;
    }
}
