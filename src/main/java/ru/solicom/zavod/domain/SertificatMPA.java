package ru.solicom.zavod.domain;


import org.codehaus.jackson.annotate.JsonIgnore;
import ru.solicom.zavod.domain.base.BaseDomainSertificatMP;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sertificat_min_poroshok_akt")
public class SertificatMPA extends BaseDomainSertificatMP implements Serializable {
    @Column(name = "ud_radio", nullable = false)
    @DecimalMin("0.001")
    private float udRadio;
    @Column(name = "poristost", nullable = false)
    @DecimalMin("0.001")
    private float poristost;
    @Column(name = "nabuchanie", nullable = false)
    private float nabuchanie;
    @Column(name = "gidrofobnost", nullable = false)
    private String gidrofobnost;

    @OneToMany(mappedBy = "sertificatMPA", fetch = FetchType.EAGER)
    private Set<PogruzkaMPA> pogruzkaMPAs = new HashSet<>();



    public float getUdRadio() {
        return udRadio;
    }

    public void setUdRadio(float udRadio) {
        this.udRadio = udRadio;
    }

    public String getGidrofobnost() {
        return gidrofobnost;
    }

    public void setGidrofobnost(String gidrofobnost) {
        this.gidrofobnost = gidrofobnost;
    }

    public float getNabuchanie() {
        return nabuchanie;
    }

    public void setNabuchanie(float nabuchanie) {
        this.nabuchanie = nabuchanie;
    }

    public float getPoristost() {
        return poristost;
    }

    public void setPoristost(float poristost) {
        this.poristost = poristost;
    }

    @JsonIgnore
    public Set<PogruzkaMPA> getPogruzkaMPAs() {
        return pogruzkaMPAs;
    }
    @JsonIgnore
    public void setPogruzkaMPAs(Set<PogruzkaMPA> pogruzkaMPAs) {
        this.pogruzkaMPAs = pogruzkaMPAs;
    }
}
