package ru.solicom.zavod.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.base.BaseDomainEntity;

@Entity
@Table(name = "gruz")
public class Gruz extends BaseDomainEntity implements Serializable {

}
