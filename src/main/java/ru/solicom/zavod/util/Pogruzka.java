package ru.solicom.zavod.util;

import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.*;

public class Pogruzka {
    private int id;
    private Vagon vagon;
    private int idVagon;
    private Gruz gruz;
    private float brutto;
    private float netto;
    private LocalDate dataPogruzki;
    private LocalDate dataOtpravleniya;
    private Tara tara;
    private String dopolneniya;
    private String dataPribitiyaVagona;
    private VagoniPoroznie vagonPorozniy;
    private User pogruzil;

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

    public LocalDate getDataPogruzki() {
        return dataPogruzki;
    }

    public void setDataPogruzki(LocalDate dataPogruzki) {
        this.dataPogruzki = dataPogruzki;
    }

    public LocalDate getDataOtpravleniya() {
        return dataOtpravleniya;
    }

    public void setDataOtpravleniya(LocalDate dataOtpravleniya) {
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

    public String getDataPribitiyaVagona() {
        return dataPribitiyaVagona;
    }

    public void setDataPribitiyaVagona(String dataPribitiyaVagona) {
        this.dataPribitiyaVagona = dataPribitiyaVagona;
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
}
