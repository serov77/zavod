package ru.solicom.zavod.util;

import org.joda.time.LocalDate;
import ru.solicom.zavod.domain.VagoniPoroznie;

import java.util.ArrayList;
import java.util.List;


public class ZayavkaPoroznie {
    private int day;
    private LocalDate date;
    private List<VagoniPoroznie> vagoni;

    public ZayavkaPoroznie(int day, LocalDate date, List<VagoniPoroznie> vagoni) {
        this.day = day;
        this.date = date;
        this.vagoni = vagoni;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<VagoniPoroznie> getVagoni() {
        return vagoni;
    }

    public void setVagoni(List<VagoniPoroznie> vagoni) {
        this.vagoni = vagoni;
    }
}
