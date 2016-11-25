package ru.solicom.zavod.util;

import ru.solicom.zavod.domain.PogruzkaIM;

import java.io.Serializable;
import java.util.List;

public class PechatDokumentovIM implements Serializable {
    private int kolSertIM;
    private int spravkaOVzvIM;
    private int svidOTeshnSostIM;
    private List<PogruzkaIM> pogruzkaIMList;
    private String master;

    public int getKolSertIM() {
        return kolSertIM;
    }

    public void setKolSertIM(int kolSertIM) {
        this.kolSertIM = kolSertIM;
    }

    public int getSpravkaOVzvIM() {
        return spravkaOVzvIM;
    }

    public void setSpravkaOVzvIM(int spravkaOVzvIM) {
        this.spravkaOVzvIM = spravkaOVzvIM;
    }

    public int getSvidOTeshnSostIM() {
        return svidOTeshnSostIM;
    }

    public void setSvidOTeshnSostIM(int svidOTeshnSostIM) {
        this.svidOTeshnSostIM = svidOTeshnSostIM;
    }

    public List<PogruzkaIM> getPogruzkaIMList() {
        return pogruzkaIMList;
    }

    public void setPogruzkaIMList(List<PogruzkaIM> pogruzkaIMList) {
        this.pogruzkaIMList = pogruzkaIMList;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public PechatDokumentovIM(int kolSertIM, int spravkaOVzvIM, int svidOTeshnSostIM, List<PogruzkaIM> pogruzkaIMList, String master) {
        this.kolSertIM = kolSertIM;
        this.spravkaOVzvIM = spravkaOVzvIM;
        this.svidOTeshnSostIM = svidOTeshnSostIM;
        this.pogruzkaIMList = pogruzkaIMList;
        this.master = master;
    }

}
