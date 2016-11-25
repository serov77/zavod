package ru.solicom.zavod.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.base.BaseDomainEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "station")
public class Station extends BaseDomainEntity implements Serializable {

    @Column(name = "kod", unique = true, nullable = false)
    @NotBlank
    private String kod;

    @ManyToMany(targetEntity = Pokupatel.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "stations")
    private Set<Pokupatel> pokupatels = new HashSet<Pokupatel>(0);

    public Station() {

    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @JsonIgnore
    public Set<Pokupatel> getPokupatels() {
        return pokupatels;
    }

    @JsonIgnore
    public void setPokupatels(Set<Pokupatel> pokupatels) {
        this.pokupatels = pokupatels;
    }
}
