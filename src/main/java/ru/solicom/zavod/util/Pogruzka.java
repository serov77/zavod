package ru.solicom.zavod.util;

import ru.solicom.zavod.domain.Gruz;
import ru.solicom.zavod.domain.Tara;
import ru.solicom.zavod.domain.Vagon;

import java.util.Date;

public class Pogruzka {
    private int id;
    private Vagon vagon;
    private int idVagon;
    private Gruz gruz;
    private float brutto;
    private float netto;
    private Date dataPogruzki;
    private Date dataOtpravleniya;
    private Tara tara;
    private String dopolneniya;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vagon getVagon() {
        return vagon;
    }

    public void setVagon(Vagon vagon) {
        this.vagon = vagon;
    }

    public Gruz getGruz() {
        return gruz;
    }

    public void setGruz(Gruz gruz) {
        this.gruz = gruz;
    }

    public float getBrutto() {
        return brutto;
    }

    public void setBrutto(float brutto) {
        this.brutto = brutto;
    }

    public float getNetto() {
        return netto;
    }

    public void setNetto(float netto) {
        this.netto = netto;
    }

    public Date getDataPogruzki() {
        return dataPogruzki;
    }

    public void setDataPogruzki(Date dataPogruzki) {
        this.dataPogruzki = dataPogruzki;
    }

    public Date getDataOtpravleniya() {
        return dataOtpravleniya;
    }

    public void setDataOtpravleniya(Date dataOtpravleniya) {
        this.dataOtpravleniya = dataOtpravleniya;
    }

    public Tara getTara() {
        return tara;
    }

    public void setTara(Tara tara) {
        this.tara = tara;
    }

    public String getDopolneniya() {
        return dopolneniya;
    }

    public void setDopolneniya(String dopolneniya) {
        this.dopolneniya = dopolneniya;
    }

    public int getIdVagon() {
        return idVagon;
    }

    public void setIdVagon(int idVagon) {
        this.idVagon = idVagon;
    }
}
