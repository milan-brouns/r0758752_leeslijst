package model.domain;

public class Boek {
    private String titel,auteur;
    private int aantalpaginas;

    public Boek(String titel, String auteur, int aantalpaginas) {
        if (titel== null||titel.trim().isEmpty())
            throw new IllegalArgumentException("Dit is gen geldige titel.");
        if (auteur==null||auteur.trim().isEmpty()){
            throw new IllegalArgumentException("Dit is geen geldige auteur.");
        }
        if (aantalpaginas<5){
            throw new IllegalArgumentException("Een boek moet minstens 5 pagina's hebben.");
        }
        this.titel = titel;
        this.auteur = auteur;
        this.aantalpaginas = aantalpaginas;
    }

    public String getTitel() {
        return titel;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAantalpaginas() {
        return aantalpaginas;
    }

    public void setAantalpaginas(int aantalpaginas) {
        this.aantalpaginas = aantalpaginas;
    }


    @Override
    public String toString() {
        return  "\'"+titel + "\' geschreven door " + auteur + " en telt " + aantalpaginas +" pagina's.";
    }

}
