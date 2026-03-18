import model.Szo;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Szo> szavak = Program.fajlbeolvas();


        if (szavak.isEmpty()) {
            System.out.println("A lista üres, ellenőrizd az adatok.txt fájlt!");
            return;
        }

        System.out.println("=== SZÓSTATISZTIKA JAVÁBAN ===");

        System.out.println("Beolvasott szavak száma: " + Program.hanySzo(szavak));
        System.out.println("A leghosszabb szó a listában: " + Program.leghosszabb_szo(szavak));
        System.out.println("Szavak száma, amiben van 'e' betű: " + Program.hanybanVanE(szavak));
        System.out.println("Van-e ismétlődő szó a listában? " + (Program.vanE(szavak) ? "Igen" : "Nincs"));

        System.out.println("\n--- Részletes betűstatisztika ---");
        Program.betuStatisztika(szavak);

        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Interaktív betűcsere ---");
        System.out.println("Válassz egy szót a listából (0 - " + (szavak.size() - 1) + "):");


        for (int i = 0; i < szavak.size(); i++) {
            System.out.println(i + ". " + szavak.get(i).getSzo());
        }

        System.out.print("\nAdd meg a kiválasztott szó sorszámát: ");
        if (sc.hasNextInt()) {
            int valasztottIndex = sc.nextInt();

            if (valasztottIndex >= 0 && valasztottIndex < szavak.size()) {
                String eredetiSzo = szavak.get(valasztottIndex).getSzo();
                String modositottSzo = Program.elsoUtolsoCsere(eredetiSzo);

                System.out.println("\nEredeti szó: " + eredetiSzo);
                System.out.println("Módosított (megcserélt) szó: " + modositottSzo);
            } else {
                System.out.println("Hiba: Ilyen sorszámú szó nem szerepel a listában!");
            }
        } else {
            System.out.println("Hiba: Kérlek számot adj meg!");
        }

        sc.close();
        System.out.println("\nProgram vége.");
    }
}