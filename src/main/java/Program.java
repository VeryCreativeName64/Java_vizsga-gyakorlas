import model.Szo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static List<Szo> fajlbeolvas() {
        List<Szo> lista = new ArrayList<>();
        File file = new File("src/adatok.txt");

        try (Scanner sc = new Scanner(file)) {

            sc.useDelimiter(";");

            while (sc.hasNext()) {
                String adat = sc.next().trim();
                if (!adat.isEmpty()) {
                    lista.add(new Szo(adat));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Hiba: A fájl nem található! " + e.getMessage());
        }

        return lista;
    }
}