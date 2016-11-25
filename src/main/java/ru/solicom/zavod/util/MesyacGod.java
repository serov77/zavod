package ru.solicom.zavod.util;


import org.joda.time.LocalDate;

public class MesyacGod {
    public static String out(LocalDate date){
        String s = date.toString("MM");
        String god = Integer.toString(date.getYear());
        String x="";
        switch (s){
            case "01":
                x="Январь "+god+ " г.";
                break;
            case "02":
                x="Февраль "+god+ " г.";
                break;
            case "03":
                x="Март "+god+ " г.";
                break;
            case "04":
                x="Апрель "+god+ " г.";
                break;
            case "05":
                x="Май "+god+ " г.";
                break;
            case "06":
                x="Июнь "+god+ " г.";
                break;
            case "07":
                x="Июль "+god+ " г.";
                break;
            case "08":
                x="Август "+god+ " г.";
                break;
            case "09":
                x="Сентябрь "+god+ " г.";
                break;
            case "10":
                x="Октябрь "+god+ " г.";
                break;
            case "11":
                x="Ноябрь "+god+ " г.";
                break;
            case "12":
                x="Декабрь "+god+ " г.";
        }
        return x;
    }
}
