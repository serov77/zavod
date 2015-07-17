package ru.solicom.zavod.domain.base;

import org.hibernate.validator.constraints.NotBlank;
import ru.solicom.zavod.domain.SertificatIK;
import ru.solicom.zavod.domain.Tara;
import ru.solicom.zavod.domain.Vagon;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseDomainPogruzka extends BaseDomain{
    @ManyToOne
    @JoinColumn(name = "id_vagon")
    protected Vagon vagon;
    @Column(name = "brutto", nullable = false)
    @NotBlank
    protected float brutto;
    @Column(name = "data_pogruzki")
    protected Date dataPogruzki;
    @Column(name = "data_otpravleniya")
    protected Date dataOtpravleniya;
    @ManyToOne
    @JoinColumn(name = "id_tara")
    protected Tara tara;
    @Column(name = "dopolneniya")
    protected String dopolneniya;

    public float getBrutto() {
        return brutto;
    }

    public String getDopolneniya() {
        return dopolneniya;
    }

    public Tara getTara() {
        return tara;
    }

    public Date getDataOtpravleniya() {
        return dataOtpravleniya;
    }

    public Date getDataPogruzki() {
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

    public void setDataOtpravleniya(Date dataOtpravleniya) {
        this.dataOtpravleniya = dataOtpravleniya;
    }

    public void setDataPogruzki(Date dataPogruzki) {
        this.dataPogruzki = dataPogruzki;
    }

    public Vagon getVagon() {
        return vagon;
    }

    public void setVagon(Vagon vagon) {
        this.vagon = vagon;
    }
}
