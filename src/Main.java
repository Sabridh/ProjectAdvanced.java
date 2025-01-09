
import model.Luchthaven;
import utils.BestandBeheer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Luchthaven luchthaven = new Luchthaven();
        Scanner scanner = new Scanner(System.in);
        boolean actief = true;

        while (actief) {
            System.out.println("\n=== Luchthaven Management Systeem ===");
            System.out.println("1. Voeg een nieuwe passagier toe");
            System.out.println("2. Maak een nieuwe vlucht aan");
            System.out.println("3. Toon vluchtinformatie");
            System.out.println("4. Sla gegevens op");
            System.out.println("5. Laad gegevens");
            System.out.println("6. Sluiten");
            System.out.println("7. Genereer een ticket");
            System.out.print("Kies een optie: ");

            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1 -> luchthaven.voegPassagierToe(scanner);
                case 2 -> luchthaven.maakVluchtAan(scanner);
                case 3 -> luchthaven.toonVluchtInfo(scanner);
                case 4 -> BestandBeheer.slaLuchthavenGegevensOp(luchthaven);
                case 5 -> BestandBeheer.laadLuchthavenGegevens(luchthaven);
                case 6 -> {
                    System.out.println("Bedankt voor het gebruik van het systeem. Tot ziens!");
                    actief = false;
                }
                case 7 -> luchthaven.genereerTicket();
                default -> System.out.println("Ongeldige keuze. Probeer het opnieuw.");
            }
        }
        scanner.close();
    }
}
