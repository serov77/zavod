package ru.solicom.zavod.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name = "gruz")
public class Gruz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "imya", nullable = false, unique = true)
    @NotBlank
    private String imya;
    
    public Gruz(){

    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }
}
