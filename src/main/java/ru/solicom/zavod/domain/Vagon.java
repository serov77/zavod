package ru.solicom.zavod.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

//import org.codehaus.jackson.map.ext.JodaDeserializers;
//import org.codehaus.jackson.map.ext.JodaDeserializers.LocalDateDeserializer;
//import org.codehaus.jackson.map.annotate.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import org.codehaus.jackson.map.ext.JodaDeserializers;
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//import org.codehaus.jackson.map.ext.JodaDeserializers;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.base.BaseDomain;
import ru.solicom.zavod.util.JsonDateDeserializer;
import ru.solicom.zavod.util.JsonDateSerializer;


@Entity
@Table(name = "vagon")
public class Vagon extends BaseDomain implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_rod_vagona")
    private RodVagona rodVagona;
    @NotEmpty
    @Column(name = "nomer_vagona")
    private String nomerVagona;
    @DecimalMin("0.001")
    @Column(name = "tara")
    private float tara;
    @DecimalMin("0.001")
    @Column(name = "gruzopodyomnost")
    private float gruzopodyomnost;
    @Column(name = "kolichestvo_zpu")
    private byte kolichestvoZpu;
    @Column(name = "data_dobavleniya")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    //@JsonDeserialize(using = JsonDateDeserializer.class)
    //@JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate dataDobavleniya;

    public Vagon() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RodVagona getRodVagona() {
        return rodVagona;
    }

    public void setRodVagona(RodVagona rodVagona) {
        this.rodVagona = rodVagona;
    }

    public String getNomerVagona() {
        return nomerVagona;
    }

    public void setNomerVagona(String nomerVagona) {
        this.nomerVagona = nomerVagona;
    }

    public float getTara() {
        return tara;
    }

    public void setTara(float tara) {
        this.tara = tara;
    }

    public float getGruzopodyomnost() {
        return gruzopodyomnost;
    }

    public void setGruzopodyomnost(float gruzopodyomnost) {
        this.gruzopodyomnost = gruzopodyomnost;
    }

    public byte getKolichestvoZpu() {
        return kolichestvoZpu;
    }

    public void setKolichestvoZpu(byte kolichestvoZpu) {
        this.kolichestvoZpu = kolichestvoZpu;
    }

    public LocalDate getDataDobavleniya() {
        return dataDobavleniya;
    }

    public void setDataDobavleniya(LocalDate dataDobavleniya) {
        this.dataDobavleniya = dataDobavleniya;
    }
}
