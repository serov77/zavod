package ru.solicom.zavod.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.DecimalMin;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "vagon")
public class Vagon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDobavleniya;

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

    public Date getDataDobavleniya() {
        return dataDobavleniya;
    }

    public void setDataDobavleniya(Date dataDobavleniya) {
        this.dataDobavleniya = dataDobavleniya;
    }
}
