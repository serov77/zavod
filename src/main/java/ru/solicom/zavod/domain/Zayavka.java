package ru.solicom.zavod.domain;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.base.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "zayavka")
public class Zayavka extends BaseDomain implements Serializable {
    @Column(name = "nomer")
    private int nomer;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "data")
    private LocalDate data;

    public Zayavka() {
    }

    public int getNomer() {
        return nomer;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
