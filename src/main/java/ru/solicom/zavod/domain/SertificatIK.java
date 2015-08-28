package ru.solicom.zavod.domain;

import com.google.gson.annotations.Expose;
import org.codehaus.jackson.annotate.JsonIgnore;
import ru.solicom.zavod.domain.base.BaseDomainSertificatIzvest;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sertificat_izvest_komovaya")
public class SertificatIK extends BaseDomainSertificatIzvest implements Serializable {


    @Column(name = "soder_nepog_zeren", nullable = false)
    @DecimalMin("0.001")
    private float soderNepogZeren;
    @JsonIgnore
    @OneToMany(mappedBy = "sertificatIK", fetch = FetchType.EAGER)
    private Set<PogruzkaIK> pogruzkaIKs = new HashSet<>();

    public SertificatIK() {
    }

    public float getSoderNepogZeren() {
        return soderNepogZeren;
    }

    public void setSoderNepogZeren(float soderNepogZeren) {
        this.soderNepogZeren = soderNepogZeren;
    }

    public Set<PogruzkaIK> getPogruzkaIKs() {
        return pogruzkaIKs;
    }

    public void setPogruzkaIKs(Set<PogruzkaIK> pogruzkaIKs) {
        this.pogruzkaIKs = pogruzkaIKs;
    }
}
