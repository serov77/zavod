package ru.solicom.zavod.domain.base;

import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.base.BaseDomain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDomainEntity extends BaseDomain {
    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
