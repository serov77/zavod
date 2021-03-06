package ru.solicom.zavod.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.DecimalMin;

@MappedSuperclass
public class BaseDomainSertificatMP extends BaseDomainSertificat{
    @Column(name = "mass_dolya_vlagi", nullable = false)
    @DecimalMin("0.001")
    protected float massovayaDolyaVlagi;
    @Column(name = "zern_sost_1250", nullable = false)
    @DecimalMin("0.001")
    protected float zerovoySostav1250;
    @Column(name = "zern_sost_0315", nullable = false)
    @DecimalMin("0.001")
    protected float zerovoySostav0315;
    @Column(name = "zern_sost_0071", nullable = false)
    @DecimalMin("0.001")
    protected float zerovoySostav0071;

    public float getMassovayaDolyaVlagi() {
        return massovayaDolyaVlagi;
    }

    public void setMassovayaDolyaVlagi(float massovayaDolyaVlagi) {
        this.massovayaDolyaVlagi = massovayaDolyaVlagi;
    }

    public float getZerovoySostav0071() {
        return zerovoySostav0071;
    }

    public void setZerovoySostav0071(float zerovoySostav0071) {
        this.zerovoySostav0071 = zerovoySostav0071;
    }

    public float getZerovoySostav0315() {
        return zerovoySostav0315;
    }

    public void setZerovoySostav0315(float zerovoySostav0315) {
        this.zerovoySostav0315 = zerovoySostav0315;
    }

    public float getZerovoySostav1250() {
        return zerovoySostav1250;
    }

    public void setZerovoySostav1250(float zerovoySostav1250) {
        this.zerovoySostav1250 = zerovoySostav1250;
    }
}
