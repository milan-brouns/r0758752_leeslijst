package model.DB;

import model.domain.Boek;

import java.util.ArrayList;

public class LeesLijst {
    private ArrayList<Boek> boekenlijst;

    public LeesLijst() {
        this.boekenlijst = new ArrayList<>();
        Boek theOneThing = new Boek("The one thing", "Garr Keler en Jay Papsan", 239);
        Boek gastrofysica = new Boek("Gastrofysica", "Charles Spence", 397);
        Boek richdadpoordad = new Boek("Rich dad poor dad", "Robert Kyosaki", 336);
        Boek startwithwhy = new Boek("Start with why", "Simon Sinek", 255);
        Boek gettingthingsdone = new Boek("Getting things done", "David Allen", 267);
        boekenlijst.add(theOneThing);
        boekenlijst.add(gastrofysica);
        boekenlijst.add(richdadpoordad);
        boekenlijst.add(startwithwhy);
        boekenlijst.add(gettingthingsdone);
    }

    public ArrayList<Boek> getBoekenlijst() {
        return boekenlijst;
    }

    public Boek zoekBoek(String titel) {
        for (Boek boek : boekenlijst) {
            if (boek.getTitel().toLowerCase().equals(titel.toLowerCase())) {
                return boek;
            }
        }
        return null;
    }

    public void voegBoekToe(Boek boek) {
        if (!(boek instanceof Boek)) {
            throw new IllegalArgumentException("geeft een geldig boek object mee.");
        }
        boekenlijst.add(boek);
    }

    public void verwijder(String titel) {
        Boek boek = zoekBoek(titel);
        boekenlijst.remove(boek);

    }

    public String getDunsteBoek(int minimumDikte) {
        Boek boekres = null;
        for (Boek boek : boekenlijst) {
            if (boekres == null) {
                if (boek.getAantalpaginas() > minimumDikte) {
                    boekres = boek;
                }
            } else {
                if (minimumDikte < boek.getAantalpaginas() && boek.getAantalpaginas() < boekres.getAantalpaginas()) {
                    boekres = boek;
                }
            }
        }
        if (boekres !=null) {
            return boekres.toString();
        }return null;
    }

    public String getDiksteBoek(int minimumDikte) {
        Boek boekres = null;
        for (Boek boek : boekenlijst) {
            if (boekres == null) {
                if (boek.getAantalpaginas() > minimumDikte) {
                    boekres = boek;
                }
            } else {
                if (boek.getAantalpaginas() > boekres.getAantalpaginas()) {
                    boekres = boek;
                }
            }
        }
        if (boekres !=null) {
            return boekres.toString();
        }return null;
    }
}
