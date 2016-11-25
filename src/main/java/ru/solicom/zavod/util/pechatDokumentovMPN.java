package ru.solicom.zavod.util;

import ru.solicom.zavod.domain.PogruzkaMPN;

import java.io.Serializable;
import java.util.List;

public class PechatDokumentovMPN implements Serializable {
    private int kolSertMPN;
    private int spravkaOVzvMPN;
    private List<PogruzkaMPN> pogruzkaMPNList;
    private String master;

    public int getKolSertMPN() {
        return kolSertMPN;
    }

    public void setKolSertMPN(int kolSertMPN) {
        this.kolSertMPN = kolSertMPN;
    }

    public int getSpravkaOVzvMPN() {
        return spravkaOVzvMPN;
    }

    public void setSpravkaOVzvMPN(int spravkaOVzvMPN) {
        this.spravkaOVzvMPN = spravkaOVzvMPN;
    }

    public List<PogruzkaMPN> getPogruzkaMPNList() {
        return pogruzkaMPNList;
    }

    public void setPogruzkaMPNList(List<PogruzkaMPN> pogruzkaMPNList) {
        this.pogruzkaMPNList = pogruzkaMPNList;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public PechatDokumentovMPN(int kolSertMPN, int spravkaOVzvMPN, List<PogruzkaMPN> pogruzkaMPNList, String master) {
        this.kolSertMPN = kolSertMPN;
        this.spravkaOVzvMPN = spravkaOVzvMPN;
        this.pogruzkaMPNList = pogruzkaMPNList;
        this.master = master;
    }
}
