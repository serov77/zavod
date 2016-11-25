package ru.solicom.zavod.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import ru.solicom.zavod.domain.base.BaseDomainSertificatIzvest;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sertificat_izvest_molotaya")
public class SertificatIM extends BaseDomainSertificatIzvest implements Serializable {

    @Column(name = "sito_02", nullable = false)
    @DecimalMin("0.001")
    private float sito02;
    @Column(name = "sito_008", nullable = false)
    @DecimalMin("0.001")
    private float sito008;

    @OneToMany(mappedBy = "sertificatIM", fetch = FetchType.EAGER)
    private Set<PogruzkaIM> pogruzkaIMs = new HashSet<>();


    public float getSito02() {
        return sito02;
    }

    public void setSito02(float sito02) {
        this.sito02 = sito02;
    }

    public float getSito008() {
        return sito008;
    }

    public void setSito008(float sito008) {
        this.sito008 = sito008;
    }

    @JsonIgnore
    public Set<PogruzkaIM> getPogruzkaIMs() {
        return pogruzkaIMs;
    }

    @JsonIgnore
    public void setPogruzkaIMs(Set<PogruzkaIM> pogruzkaIMs) {
        this.pogruzkaIMs = pogruzkaIMs;
    }
}
