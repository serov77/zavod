package ru.solicom.zavod.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.base.BaseDomainEntity;

@Entity
@Table(name = "station")
public class Station extends BaseDomainEntity implements Serializable {

    @Column(name = "kod", unique = true, nullable = false)
    @NotBlank
    private String kod;

    public Station() {

    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }
}
