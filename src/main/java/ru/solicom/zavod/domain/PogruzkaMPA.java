package ru.solicom.zavod.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ru.solicom.zavod.domain.base.BaseDomainPogruzka;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "pogruzka_mpa")
public class PogruzkaMPA extends BaseDomainPogruzka implements Serializable{
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_sertificat")
    private SertificatMPA sertificatMPA;

    public SertificatMPA getSertificatMPA() {
        return sertificatMPA;
    }

    public void setSertificatMPA(SertificatMPA sertificatMPA) {
        this.sertificatMPA = sertificatMPA;
    }
}
