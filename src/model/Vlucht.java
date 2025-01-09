package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vlucht implements Serializable {
    private static final long serialVersionUID = 1L;
    private String vluchtCode;
    private String eindbestemming;
    private int economyPlaatsen;
    private int businessPlaatsen;
    private List<Passagier> passagiers;
    private List<String> personeel;

    public Vlucht(String vluchtCode, String eindbestemming, int economyPlaatsen, int businessPlaatsen) {
        this.vluchtCode = vluchtCode;
        this.eindbestemming = eindbestemming;
        this.economyPlaatsen = economyPlaatsen;
        this.businessPlaatsen = businessPlaatsen;
        this.passagiers = new ArrayList<>();
        this.personeel = new ArrayList<>();
    }

    // Getters
    public String getVluchtCode() {
        return vluchtCode;
    }

    public String getEindbestemming() {
        return eindbestemming;
    }

    public int getEconomyPlaatsen() {
        return economyPlaatsen;
    }

    public int getBusinessPlaatsen() {
        return businessPlaatsen;
    }

    public List<Passagier> getPassagiers() {
        return passagiers;
    }

    public List<String> getPersoneel() {
        return personeel;
    }

    // Passagier toevoegen
    public void voegPassagierToe(Passagier passagier) {
        if (passagiers.size() < economyPlaatsen + businessPlaatsen) {
            passagiers.add(passagier);
        } else {
            System.out.println("Geen beschikbare plaatsen op deze vlucht.");
        }
    }

    // Personeel toevoegen
    public void voegPersoneelToe(String personeelslid) {
        personeel.add(personeelslid);
    }
}
