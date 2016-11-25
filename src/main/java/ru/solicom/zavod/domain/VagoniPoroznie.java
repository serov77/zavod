package ru.solicom.zavod.domain;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.base.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vagoni_poroznie")
public class VagoniPoroznie extends BaseDomain implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_vagon")
    private Vagon vagon;
    @ManyToOne
    @JoinColumn(name = "id_gruz")
    private Gruz gruz;
    @Column(name = "nomer_svidetelstva")
    private int nomerSvidetelstva;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "data_pribitiya")
    private LocalDate dataPribitiya;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "data_pogruzki")
    private LocalDate dataPogruzki;
    @Column(name = "pogruzen")
    private Boolean pogruzen;
    @ManyToOne
    @JoinColumn(name = "id_zayavka")
    private Zayavka zayavka;

    public VagoniPoroznie() {

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

    public int getNomerSvidetelstva() {
        return nomerSvidetelstva;
    }

    public void setNomerSvidetelstva(int nomerSvidetelstva) {
        this.nomerSvidetelstva = nomerSvidetelstva;
    }

    public LocalDate getDataPribitiya() {
        return dataPribitiya;
    }

    public void setDataPribitiya(LocalDate dataPribitiya) {
        this.dataPribitiya = dataPribitiya;
    }

    public LocalDate getDataPogruzki() {
        return dataPogruzki;
    }

    public void setDataPogruzki(LocalDate dataPogruzki) {
        this.dataPogruzki = dataPogruzki;
    }

    public Boolean getPogruzen() {
        return pogruzen;
    }

    public void setPogruzen(Boolean pogruzen) {
        this.pogruzen = pogruzen;
    }

    public Zayavka getZayavka() {
        return zayavka;
    }

    public void setZayavka(Zayavka zayavka) {
        this.zayavka = zayavka;
    }
}
