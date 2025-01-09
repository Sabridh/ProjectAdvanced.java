package model;

import java.io.Serializable;

public class Passagier implements Serializable {
    private static final long serialVersionUID = 1L;
    private String naam;
    private int leeftijd;
    private String adres;

    public Passagier(String naam, int leeftijd, String adres) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
    }

    public String getNaam() {
        return naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getAdres() {
        return adres;
    }
}
