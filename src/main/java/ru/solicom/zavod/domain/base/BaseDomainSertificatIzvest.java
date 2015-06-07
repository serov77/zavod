package ru.solicom.zavod.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.DecimalMin;

@MappedSuperclass
public class BaseDomainSertificatIzvest extends BaseDomainSertificat {
    @Column(name = "aktivnost", nullable = false)
    @DecimalMin("0.001")
    protected float aktivnost;
    @Column(name = "vremya_gascheniya", nullable = false)
    @DecimalMin("0.001")
    protected float vremyaGascheniya;
    @Column(name = "temperatura_gascheniya", nullable = false)
    @DecimalMin("0.001")
    protected float temperaturaGascheniya;
    @Column(name = "soder_uglekisloti", nullable = false)
    @DecimalMin("0.001")
    protected float soderUglekisloti;

    public float getAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(float aktivnost) {
        this.aktivnost = aktivnost;
    }

    public float getVremyaGascheniya() {
        return vremyaGascheniya;
    }

    public void setVremyaGascheniya(float vremyaGascheniya) {
        this.vremyaGascheniya = vremyaGascheniya;
    }

    public float getTemperaturaGascheniya() {
        return temperaturaGascheniya;
    }

    public void setTemperaturaGascheniya(float temperaturaGascheniya) {
        this.temperaturaGascheniya = temperaturaGascheniya;
    }

    public float getSoderUglekisloti() {
        return soderUglekisloti;
    }

    public void setSoderUglekisloti(float soderUglekisloti) {
        this.soderUglekisloti = soderUglekisloti;
    }
}
