package ru.solicom.zavod.domain.base;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.Pokupatel;
import ru.solicom.zavod.domain.Station;
import ru.solicom.zavod.util.JsonDateDeserializer;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseDomainSertificat extends BaseDomain{
    @Column(name = "nomer", nullable = false)
    @NotBlank
    protected String nomer;
    @Column(name = "data", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    protected LocalDate data;
    @ManyToOne
    @JoinColumn(name = "id_pokupatel")
    protected Pokupatel pokupatel;
    @Column(name = "otmetki")
    protected String otmetki;
    @ManyToOne
    @JoinColumn(name = "id_station")
    protected Station station;

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Pokupatel getPokupatel() {
        return pokupatel;
    }

    public void setPokupatel(Pokupatel pokupatel) {
        this.pokupatel = pokupatel;
    }


    public String getOtmetki() {
        return otmetki;
    }

    public void setOtmetki(String otmetki) {
        this.otmetki = otmetki;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
