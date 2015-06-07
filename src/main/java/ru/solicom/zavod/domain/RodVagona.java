package ru.solicom.zavod.domain;

import ru.solicom.zavod.domain.base.BaseDomain;
import ru.solicom.zavod.domain.base.BaseDomainEntity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rod_vagona")
public class RodVagona extends BaseDomainEntity implements Serializable {
    public RodVagona() {

    }

    public RodVagona(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
