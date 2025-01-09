package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Luchthaven implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Passagier> passagiers;
    private List<Vlucht> vluchten;

    public Luchthaven() {
        this.passagiers = new ArrayList<>();
        this.vluchten = new ArrayList<>();
    }

    public void voegPassagierToe(Scanner scanner) {
        System.out.print("Geef de naam van de passagier: ");
        String naam = scanner.nextLine();
        System.out.print("Geef de leeftijd: ");
        int leeftijd = scanner.nextInt();
        scanner.nextLine(); // Verwijder de newline
        System.out.print("Geef het adres: ");
        String adres = scanner.nextLine();

        Passagier passagier = new Passagier(naam, leeftijd, adres);
        passagiers.add(passagier);
        System.out.println("Passagier toegevoegd: " + passagier.getNaam());
    }

    public void maakVluchtAan(Scanner scanner) {
        System.out.print("Geef de vluchtcode: ");
        String vluchtCode = scanner.nextLine();
        System.out.print("Geef de eindbestemming: ");
        String eindbestemming = scanner.nextLine();
        System.out.print("Geef het aantal economy plaatsen: ");
        int economyPlaatsen = scanner.nextInt();
        System.out.print("Geef het aantal business plaatsen: ");
        int businessPlaatsen = scanner.nextInt();
        scanner.nextLine(); // Verwijder de newline

        Vlucht nieuweVlucht = new Vlucht(vluchtCode, eindbestemming, economyPlaatsen, businessPlaatsen);
        vluchten.add(nieuweVlucht);
        System.out.println("Vlucht toegevoegd: " + nieuweVlucht.getVluchtCode());
    }

    public void toonVluchtInfo(Scanner scanner) {
        System.out.print("Geef de vluchtcode: ");
        String vluchtCode = scanner.nextLine();

        for (Vlucht vlucht : vluchten) {
            if (vlucht.getVluchtCode().equalsIgnoreCase(vluchtCode)) {
                System.out.println("Vluchtcode: " + vlucht.getVluchtCode());
                System.out.println("Eindbestemming: " + vlucht.getEindbestemming());
                System.out.println("Passagiers: " + vlucht.getPassagiers().size());
                System.out.println("Personeel: " + vlucht.getPersoneel().size());
                return;
            }
        }

        System.out.println("Geen vlucht gevonden met de code: " + vluchtCode);
    }

    public void genereerTicket() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("\n=== Ticket Récapitulatif ===\n");

        ticket.append("\n--- Passagiers ---\n");
        for (Passagier passagier : passagiers) {
            ticket.append("Naam: ").append(passagier.getNaam())
                    .append(", Leeftijd: ").append(passagier.getLeeftijd())
                    .append(", Adres: ").append(passagier.getAdres())
                    .append("\n");
        }

        ticket.append("\n--- Vluchten ---\n");
        for (Vlucht vlucht : vluchten) {
            ticket.append("Vluchtcode: ").append(vlucht.getVluchtCode())
                    .append(", Eindbestemming: ").append(vlucht.getEindbestemming())
                    .append(", Economy plaatsen: ").append(vlucht.getEconomyPlaatsen())
                    .append(", Business plaatsen: ").append(vlucht.getBusinessPlaatsen())
                    .append("\n");

            if (!vlucht.getPassagiers().isEmpty()) {
                ticket.append("Passagiers op de vlucht:\n");
                for (Passagier passagier : vlucht.getPassagiers()) {
                    ticket.append("  - ").append(passagier.getNaam()).append("\n");
                }
            } else {
                ticket.append("Geen passagiers toegewezen.\n");
            }
        }

        System.out.println(ticket);

        try (FileWriter writer = new FileWriter("ticket_recapitulatie.txt")) {
            writer.write(ticket.toString());
            System.out.println("\nTicket succesvol opgeslagen.");
        } catch (IOException e) {
            System.err.println("Fout bij het opslaan van het ticket: " + e.getMessage());
        }
    }
}

