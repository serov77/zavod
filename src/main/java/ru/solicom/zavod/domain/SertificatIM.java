package ru.solicom.zavod.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sertificat_izvest_molotaya")
public class SertificatIM implements Serializable{
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
    @Column(name = "soder_uglekisloti", nullable = false)
    @DecimalMin("0.001")
    private float soderUglekisloti;
    @Column(name = "sito_02", nullable = false)
    @DecimalMin("0.001")
    private float sito02;
    @Column(name = "sito_008", nullable = false)
    @DecimalMin("0.001")
    private float sito008;
    @ManyToOne
    @JoinColumn(name = "id_pokupatel")
    private Pokupatel pokupatel;

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

    public float getSoderUglekisloti() {
        return soderUglekisloti;
    }

    public void setSoderUglekisloti(float soderUglekisloti) {
        this.soderUglekisloti = soderUglekisloti;
    }

    public float getSito02() {
        return sito02;
    }

    public void setSito02(float sito02) {
        this.sito02 = sito02;
    }

    public float getSito008() {
        return sito008;
    }

    public void setSito008(float sito008) {
        this.sito008 = sito008;
    }

    public Pokupatel getPokupatel() {
        return pokupatel;
    }

    public void setPokupatel(Pokupatel pokupatel) {
        this.pokupatel = pokupatel;
    }
}
