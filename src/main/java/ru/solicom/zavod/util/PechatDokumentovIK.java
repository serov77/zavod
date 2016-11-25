package ru.solicom.zavod.util;

import ru.solicom.zavod.domain.PogruzkaIK;

import java.io.Serializable;
import java.util.List;

public class PechatDokumentovIK implements Serializable {
    private int kolSertIK;
    private int spravkaOVzvIK;
    private int svidOTeshnSostIK;
    private List<PogruzkaIK> pogruzkaIKList;
    private String master;

    public int getKolSertIK() {
        return kolSertIK;
    }

    public void setKolSertIK(int kolSertIK) {
        this.kolSertIK = kolSertIK;
    }

    public int getSpravkaOVzvIK() {
        return spravkaOVzvIK;
    }

    public void setSpravkaOVzvIK(int spravkaOVzvIK) {
        this.spravkaOVzvIK = spravkaOVzvIK;
    }


    public int getSvidOTeshnSostIK() {
        return svidOTeshnSostIK;
    }

    public void setSvidOTeshnSostIK(int svidOTeshnSostIK) {
        this.svidOTeshnSostIK = svidOTeshnSostIK;
    }

    public List<PogruzkaIK> getPogruzkaIKList() {
        return pogruzkaIKList;
    }

    public void setPogruzkaIKList(List<PogruzkaIK> pogruzkaIKList) {
        this.pogruzkaIKList = pogruzkaIKList;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public PechatDokumentovIK(int kolSertIK, int spravkaOVzvIK, int svidOTeshnSostIK, List<PogruzkaIK> pogruzkaIKList, String master) {
        this.kolSertIK = kolSertIK;
        this.spravkaOVzvIK = spravkaOVzvIK;
        this.svidOTeshnSostIK = svidOTeshnSostIK;
        this.pogruzkaIKList = pogruzkaIKList;
        this.master = master;
    }
}
