package ru.solicom.zavod.domain.base;

import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.Pokupatel;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseDomainSertificat extends BaseDomain{
    @Column(name = "nomer", nullable = false)
    @NotBlank
    protected String nomer;
    @Column(name = "data", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date data;
    @ManyToOne
    @JoinColumn(name = "id_pokupatel")
    protected Pokupatel pokupatel;

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Pokupatel getPokupatel() {
        return pokupatel;
    }

    public void setPokupatel(Pokupatel pokupatel) {
        this.pokupatel = pokupatel;
    }
}
