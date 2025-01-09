package utils;

import model.Luchthaven;

import java.io.*;

public class BestandBeheer {
    public static void slaLuchthavenGegevensOp(Luchthaven luchthaven) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("luchthaven.data"))) {
            oos.writeObject(luchthaven);
            System.out.println("Gegevens succesvol opgeslagen.");
        } catch (IOException e) {
            System.err.println("Fout bij het opslaan van gegevens: " + e.getMessage());
        }
    }

    public static void laadLuchthavenGegevens(Luchthaven luchthaven) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("luchthaven.data"))) {
            Luchthaven geladen = (Luchthaven) ois.readObject();
            luchthaven = geladen;
            System.out.println("Gegevens succesvol geladen.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fout bij het laden van gegevens: " + e.getMessage());
        }
    }
}
