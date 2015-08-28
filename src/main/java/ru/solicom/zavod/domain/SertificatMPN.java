package ru.solicom.zavod.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import ru.solicom.zavod.domain.base.BaseDomainSertificat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sertificat_min_poroshok_neakt")
public class SertificatMPN extends BaseDomainSertificat implements Serializable {
    @Column(name = "mass_dolya_vlagi", nullable = false)
    @DecimalMin("0.001")
    private float massovayaDolyaVlagi;
    @Column(name = "zern_sost_1250", nullable = false)
    @DecimalMin("0.001")
    private float zerovoySostav1250;
    @Column(name = "zern_sost_0315", nullable = false)
    @DecimalMin("0.001")
    private float zerovoySostav0315;
    @Column(name = "zern_sost_0071", nullable = false)
    @DecimalMin("0.001")
    private float zerovoySostav0071;
    @JsonIgnore
    @OneToMany(mappedBy = "sertificatMPN", fetch = FetchType.EAGER)
    private Set<PogruzkaMPN> pogruzkaMPNs = new HashSet<>();

    public float getMassovayaDolyaVlagi() {
        return massovayaDolyaVlagi;
    }

    public void setMassovayaDolyaVlagi(float massovayaDolyaVlagi) {
        this.massovayaDolyaVlagi = massovayaDolyaVlagi;
    }

    public float getZerovoySostav1250() {
        return zerovoySostav1250;
    }

    public void setZerovoySostav1250(float zerovoySostav1250) {
        this.zerovoySostav1250 = zerovoySostav1250;
    }

    public float getZerovoySostav0315() {
        return zerovoySostav0315;
    }

    public void setZerovoySostav0315(float zerovoySostav0315) {
        this.zerovoySostav0315 = zerovoySostav0315;
    }

    public float getZerovoySostav0071() {
        return zerovoySostav0071;
    }

    public void setZerovoySostav0071(float zerovoySostav0071) {
        this.zerovoySostav0071 = zerovoySostav0071;
    }

    public Set<PogruzkaMPN> getPogruzkaMPNs() {
        return pogruzkaMPNs;
    }

    public void setPogruzkaMPNs(Set<PogruzkaMPN> pogruzkaMPNs) {
        this.pogruzkaMPNs = pogruzkaMPNs;
    }
}
