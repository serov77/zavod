package ru.solicom.zavod.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "station")
public class Station implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", unique = true, nullable = false)
    @NotBlank
    private String nameStation;
    @Column(name = "kod", unique = true, nullable = false)
    @NotBlank
    private String kod;

    public Station() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }
}
