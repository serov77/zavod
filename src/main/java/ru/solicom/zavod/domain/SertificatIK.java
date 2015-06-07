package ru.solicom.zavod.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.DecimalMin;
import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.base.BaseDomainSertificatIzvest;

@Entity
@Table(name = "sertificat_izvest_komovaya")
public class SertificatIK extends BaseDomainSertificatIzvest implements Serializable {


    @Column(name = "soder_nepog_zeren", nullable = false)
    @DecimalMin("0.001")
    private float soderNepogZeren;

    public SertificatIK() {

    }

    public float getSoderNepogZeren() {
        return soderNepogZeren;
    }

    public void setSoderNepogZeren(float soderNepogZeren) {
        this.soderNepogZeren = soderNepogZeren;
    }

}
