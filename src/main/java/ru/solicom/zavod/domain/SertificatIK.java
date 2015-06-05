package ru.solicom.zavod.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.DecimalMin;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "sertificat_izvest_komovaya")
public class SertificatIK implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nomer", nullable = false)
    @NotBlank
    private String nomer;
    @Column(name = "data", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Column(name = "aktivnost", nullable = false)
    @DecimalMin("0.001")
    private float aktivnost;
    @Column(name = "vremya_gascheniya", nullable = false)
    @DecimalMin("0.001")
    private float vremyaGascheniya;
    @Column(name = "temperatura_gascheniya", nullable = false)
    @DecimalMin("0.001")
    private float temperaturaGascheniya;
    @Column(name = "soder_nepog_zeren", nullable = false)
    @DecimalMin("0.001")
    private float soderNepogZeren;
    @Column(name = "soder_uglekisloti", nullable = false)
    @DecimalMin("0.001")
    private float soderUglekisloti;
    @ManyToOne
    @JoinColumn(name = "id_pokupatel")
    private Pokupatel pokupatel;

    public SertificatIK() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public float getAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(float aktivnost) {
        this.aktivnost = aktivnost;
    }

    public float getVremyaGascheniya() {
        return vremyaGascheniya;
    }

    public void setVremyaGascheniya(float vremyaGascheniya) {
        this.vremyaGascheniya = vremyaGascheniya;
    }

    public float getTemperaturaGascheniya() {
        return temperaturaGascheniya;
    }

    public void setTemperaturaGascheniya(float temperaturaGascheniya) {
        this.temperaturaGascheniya = temperaturaGascheniya;
    }

    public float getSoderNepogZeren() {
        return soderNepogZeren;
    }

    public void setSoderNepogZeren(float soderNepogZeren) {
        this.soderNepogZeren = soderNepogZeren;
    }

    public float getSoderUglekisloti() {
        return soderUglekisloti;
    }

    public void setSoderUglekisloti(float soderUglekisloti) {
        this.soderUglekisloti = soderUglekisloti;
    }

    public Pokupatel getPokupatel() {
        return pokupatel;
    }

    public void setPokupatel(Pokupatel pokupatel) {
        this.pokupatel = pokupatel;
    }

}
