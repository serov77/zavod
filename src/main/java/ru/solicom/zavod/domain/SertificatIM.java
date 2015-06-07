package ru.solicom.zavod.domain;

import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.base.BaseDomainSertificatIzvest;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sertificat_izvest_molotaya")
public class SertificatIM extends BaseDomainSertificatIzvest implements Serializable {

    @Column(name = "sito_02", nullable = false)
    @DecimalMin("0.001")
    private float sito02;
    @Column(name = "sito_008", nullable = false)
    @DecimalMin("0.001")
    private float sito008;


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

}
