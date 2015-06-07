package ru.solicom.zavod.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.base.BaseDomainEntity;

@Entity
@Table(name = "pokupatel")
public class Pokupatel extends BaseDomainEntity implements Serializable {

    @Column(name = "kod")
    @NotBlank
    private String kod;
    @Column(name = "okpo")
    @NotBlank
    private String okpo;
    @ManyToOne
    @JoinColumn(name = "id_station")
    private Station station;

    public Pokupatel() {

    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
