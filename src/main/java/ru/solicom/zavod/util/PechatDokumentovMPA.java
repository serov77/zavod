package ru.solicom.zavod.util;


import ru.solicom.zavod.domain.PogruzkaMPA;

import java.io.Serializable;
import java.util.List;

public class PechatDokumentovMPA implements Serializable{
    private int kolSertMPA;
    private int spravkaOVzvMPA;
    private List<PogruzkaMPA> pogruzkaMPAList;
    private String master;

    public int getKolSertMPA() {
        return kolSertMPA;
    }

    public void setKolSertMPA(int kolSertMPA) {
        this.kolSertMPA = kolSertMPA;
    }

    public int getSpravkaOVzvMPA() {
        return spravkaOVzvMPA;
    }

    public void setSpravkaOVzvMPA(int spravkaOVzvMPA) {
        this.spravkaOVzvMPA = spravkaOVzvMPA;
    }

    public List<PogruzkaMPA> getPogruzkaMPAList() {
        return pogruzkaMPAList;
    }

    public void setPogruzkaMPAList(List<PogruzkaMPA> pogruzkaMPAList) {
        this.pogruzkaMPAList = pogruzkaMPAList;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public PechatDokumentovMPA(int kolSertMPA, int spravkaOVzvMPA, List<PogruzkaMPA> pogruzkaMPAList, String master) {
        this.kolSertMPA = kolSertMPA;
        this.spravkaOVzvMPA = spravkaOVzvMPA;
        this.pogruzkaMPAList = pogruzkaMPAList;
        this.master=master;
    }
}
