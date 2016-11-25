package ru.solicom.zavod.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import ru.solicom.zavod.domain.base.BaseDomainSertificat;
import ru.solicom.zavod.domain.base.BaseDomainSertificatMP;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sertificat_min_poroshok_neakt")
public class SertificatMPN extends BaseDomainSertificatMP implements Serializable {
    @OneToMany(mappedBy = "sertificatMPN", fetch = FetchType.EAGER)
    private Set<PogruzkaMPN> pogruzkaMPNs = new HashSet<>();

    @JsonIgnore
    public Set<PogruzkaMPN> getPogruzkaMPNs() {
        return pogruzkaMPNs;
    }
    @JsonIgnore
    public void setPogruzkaMPNs(Set<PogruzkaMPN> pogruzkaMPNs) {
        this.pogruzkaMPNs = pogruzkaMPNs;
    }
}
