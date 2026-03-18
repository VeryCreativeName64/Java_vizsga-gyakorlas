import model.Szo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    public static int hanySzo(List<Szo> lista) {
        return lista.size();
    }

    public static String leghosszabb_szo(List<Szo> lista){
        if (lista.isEmpty()) return "";

        String leghosszabb = lista.get(0).getSzo();

        for (Szo elem : lista) {
            if (elem.getSzo().length() > leghosszabb.length()) {
                leghosszabb = elem.getSzo();
            }
        }
        return leghosszabb;
    }

    public static int hanybanVanE(List<Szo> lista) {
        int db = 0;
        for (Szo elem : lista) {
            if (elem.getSzo().toLowerCase().contains("e")) {
                db++;
            }
        }
        return db;
    }

    public static String elsoUtolsoCsere(String szo) {
        if (szo == null || szo.length() < 2) {
            return szo;
        }

        char elso = szo.charAt(0);
        char utolso = szo.charAt(szo.length() - 1);


        String kozepe = szo.substring(1, szo.length() - 1);


        return utolso + kozepe + elso;
    }

    public static boolean vanE(List<Szo> lista) {
        Set<String> halmaz = new HashSet<>();
        for (Szo s : lista) {
            if (!halmaz.add(s.getSzo().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void betuStatisztika(List<Szo> lista) {
        for (Szo s : lista) {
            String aktualisSzo = s.getSzo().toLowerCase();
            System.out.println("Szó: " + aktualisSzo);

            String vizsgaltBetuk = "";

            for (int i = 0; i < aktualisSzo.length(); i++) {
                char aktualisBetu = aktualisSzo.charAt(i);

                if (vizsgaltBetuk.indexOf(aktualisBetu) == -1) {
                    int db = 0;
                    for (int j = 0; j < aktualisSzo.length(); j++) {
                        if (aktualisSzo.charAt(j) == aktualisBetu) {
                            db++;
                        }
                    }
                    System.out.println("  - " + aktualisBetu + ": " + db + " db");
                    vizsgaltBetuk += aktualisBetu;
                }
            }
            System.out.println("--------------------");
        }
    }



}