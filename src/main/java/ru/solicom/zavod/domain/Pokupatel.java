package ru.solicom.zavod.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.base.BaseDomainEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pokupatel")
public class Pokupatel extends BaseDomainEntity implements Serializable {

    @Column(name = "kod")
    @NotBlank
    private String kod;
    @Column(name = "okpo")
    @NotBlank
    private String okpo;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Station.class)
    @JoinTable(name = "pokupatel_station", joinColumns = @JoinColumn(name = "id_pokupatel"), inverseJoinColumns = @JoinColumn(name = "id_station"))
    private Set<Station> stations = new HashSet<Station>(0);
    //@ManyToOne
    //@JoinColumn(name = "id_station")
    //private Station station;

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

    //@JsonIgnore
    public Set<Station> getStations() {
        return stations;
    }

    //@JsonIgnore
    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }

    //public Station getStation() {
    //    return station;
    //}

    //public void setStation(Station station) {
    //    this.station = station;
    //}

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pokupatel && ((Pokupatel) o).getId() == this.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
