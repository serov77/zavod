package ru.solicom.zavod.domain.base;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.*;

import javax.persistence.*;
import org.joda.time.LocalDate;
import ru.solicom.zavod.util.JsonDateDeserializer;

import java.util.Date;

@MappedSuperclass
public class BaseDomainPogruzka extends BaseDomain{
    @ManyToOne
    @JoinColumn(name = "id_vagon")
    protected Vagon vagon;
    @Column(name = "brutto", nullable = false)
    protected float brutto;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "data_pogruzki")
    protected LocalDate dataPogruzki;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "data_otpravleniya")
    protected LocalDate dataOtpravleniya;
    @ManyToOne
    @JoinColumn(name = "id_tara")
    protected Tara tara;
    @Column(name = "dopolneniya")
    protected String dopolneniya;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "data_pribitiya_vagona")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    protected LocalDate dataPribitiyaVagona;
    @Column(name = "nomer_otpravki")
    protected int nomerOtpravki;
    @ManyToOne
    @JoinColumn(name = "vagon_porozniy_id")
    protected VagoniPoroznie vagonPorozniy;
    @ManyToOne
    @JoinColumn(name = "id_pogruzil")
    protected User pogruzil;
    @ManyToOne
    @JoinColumn(name = "id_otpravil")
    protected User otpravil;

    public float getBrutto() {
        return brutto;
    }

    public String getDopolneniya() {
        return dopolneniya;
    }

    public Tara getTara() {
        return tara;
    }

    public LocalDate getDataOtpravleniya() {
        return dataOtpravleniya;
    }

    public LocalDate getDataPogruzki() {
        return dataPogruzki;
    }

    public void setBrutto(float brutto) {
        this.brutto = brutto;
    }

    public void setDopolneniya(String dopolneniya) {
        this.dopolneniya = dopolneniya;
    }

    public void setTara(Tara tara) {
        this.tara = tara;
    }

    public void setDataOtpravleniya(LocalDate dataOtpravleniya) {
        this.dataOtpravleniya = dataOtpravleniya;
    }

    public void setDataPogruzki(LocalDate dataPogruzki) {
        this.dataPogruzki = dataPogruzki;
    }

    public Vagon getVagon() {
        return vagon;
    }

    public void setVagon(Vagon vagon) {
        this.vagon = vagon;
    }

    public LocalDate getDataPribitiyaVagona() {
        return dataPribitiyaVagona;
    }

    public void setDataPribitiyaVagona(LocalDate dataPribitiyaVagona) {
        this.dataPribitiyaVagona = dataPribitiyaVagona;
    }

    public int getNomerOtpravki() {
        return nomerOtpravki;
    }

    public void setNomerOtpravki(int nomerOtpravki) {
        this.nomerOtpravki = nomerOtpravki;
    }

    public VagoniPoroznie getVagonPorozniy() {
        return vagonPorozniy;
    }

    public void setVagonPorozniy(VagoniPoroznie vagonPorozniy) {
        this.vagonPorozniy = vagonPorozniy;
    }

    public User getPogruzil() {
        return pogruzil;
    }

    public void setPogruzil(User pogruzil) {
        this.pogruzil = pogruzil;
    }

    public User getOtpravil() {
        return otpravil;
    }

    public void setOtpravil(User otpravil) {
        this.otpravil = otpravil;
    }
}
