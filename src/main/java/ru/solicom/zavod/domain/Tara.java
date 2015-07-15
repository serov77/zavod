package ru.solicom.zavod.domain;

import ru.solicom.zavod.domain.base.BaseDomainEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tara")
public class Tara extends BaseDomainEntity implements Serializable{
}
