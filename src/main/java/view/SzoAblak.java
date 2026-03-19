package view;

import controller.Program;
import model.Szo;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SzoAblak extends JFrame {
    private JTextArea kijelzo;
    private JButton gombBeolvas;
    private JButton gombStat;

    public SzoAblak() {

        setTitle("Szó Statisztika GUI");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        kijelzo = new JTextArea();
        kijelzo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(kijelzo);
        add(scrollPane, BorderLayout.CENTER);


        JPanel gombPanel = new JPanel();
        gombBeolvas = new JButton("Fájl Beolvasása");
        gombStat = new JButton("Statisztika");

        gombPanel.add(gombBeolvas);
        gombPanel.add(gombStat);
        add(gombPanel, BorderLayout.SOUTH);


        gombBeolvas.addActionListener(e -> {
            List<Szo> szavak = Program.fajlbeolvas();
            kijelzo.setText("Beolvasott szavak:\n");
            for (Szo s : szavak) {
                kijelzo.append("- " + s.getSzo() + "\n");
            }
        });

        gombStat.addActionListener(e -> {
            List<Szo> szavak = Program.fajlbeolvas();
            if (szavak.isEmpty()) {
                kijelzo.setText("Előbb olvasd be a fájlt!");
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Összes szó: ").append(Program.hanySzo(szavak)).append("\n");
            sb.append("Leghosszabb: ").append(Program.leghosszabb_szo(szavak)).append("\n");
            sb.append("Van ismétlődés? ").append(Program.vanE(szavak) ? "Igen" : "Nincs").append("\n");
            sb.append("--- Betűk ---\n");

            kijelzo.setText(sb.toString());
            Program.betuStatisztika(szavak);
        });
    }
}