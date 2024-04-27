package com.ikub.motidatabase.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name= "moti")
@NoArgsConstructor
@AllArgsConstructor

public class Moti {

    @Id
    @Column(name="matje_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matje_id;
    @Column(name="qyteti")
    private String qyteti;
    @Column(name="dita")
    private String dita;
    @Column(name="temperatura")
    private String temperatura;
    @Column(name="lageshtia")
    private String lageshtia;


    public int getMatje_id() {
        return matje_id;
    }

    public void setMatje_id(int matje_id) {
        this.matje_id = matje_id;
    }

    public String getQyteti() {
        return qyteti;
    }

    public void setQyteti(String qyteti) {
        this.qyteti = qyteti;
    }

    public String getDita() {
        return dita;
    }

    public void setDita(String dita) {
        this.dita = dita;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getLageshtia() {
        return lageshtia;
    }

    public void setLageshtia(String lageshtia) {
        this.lageshtia = lageshtia;
    }
}

