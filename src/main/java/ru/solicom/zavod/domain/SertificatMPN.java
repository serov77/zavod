package ru.solicom.zavod.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.Date;

@Entity
@Table(name = "sertificat_min_poroshok_neakt")
public class SertificatMPN {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nomer", nullable = false)
    @NotBlank
    private String nomer;
    @Column(name = "data", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Column(name = "mass_dolya_vlagi", nullable = false)
    @DecimalMin("0.001")
    private float massovayaDolyaVlagi;
    @Column(name = "zern_sost_1250", nullable = false)
    @DecimalMin("0.001")
    private float zerovoySostav1250;
    @Column(name = "zern_sost_0315", nullable = false)
    @DecimalMin("0.001")
    private float zerovoySostav0315;
    @Column(name = "zern_sost_0071", nullable = false)
    @DecimalMin("0.001")
    private float zerovoySostav0071;
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

    public float getMassovayaDolyaVlagi() {
        return massovayaDolyaVlagi;
    }

    public void setMassovayaDolyaVlagi(float massovayaDolyaVlagi) {
        this.massovayaDolyaVlagi = massovayaDolyaVlagi;
    }

    public float getZerovoySostav1250() {
        return zerovoySostav1250;
    }

    public void setZerovoySostav1250(float zerovoySostav1250) {
        this.zerovoySostav1250 = zerovoySostav1250;
    }

    public float getZerovoySostav0315() {
        return zerovoySostav0315;
    }

    public void setZerovoySostav0315(float zerovoySostav0315) {
        this.zerovoySostav0315 = zerovoySostav0315;
    }

    public float getZerovoySostav0071() {
        return zerovoySostav0071;
    }

    public void setZerovoySostav0071(float zerovoySostav0071) {
        this.zerovoySostav0071 = zerovoySostav0071;
    }

    public Pokupatel getPokupatel() {
        return pokupatel;
    }

    public void setPokupatel(Pokupatel pokupatel) {
        this.pokupatel = pokupatel;
    }
}
