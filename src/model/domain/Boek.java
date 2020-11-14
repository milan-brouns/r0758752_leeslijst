package model.domain;

public class Boek {
    private String titel,auteur;
    private int aantalpaginas;

    public Boek(String titel, String auteur, int aantalpaginas) {

        setTitel(titel);
        setAuteur(auteur);
        setAantalpaginas(aantalpaginas);
    }
    public Boek(){

    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        if (titel== null||titel.trim().isEmpty())
            throw new IllegalArgumentException("Dit is geen geldige titel.");
        this.titel = titel;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        if (auteur==null||auteur.trim().isEmpty()){
            throw new IllegalArgumentException("Dit is geen geldige auteur.");}
        this.auteur = auteur;
    }

    public int getAantalpaginas() {
        return aantalpaginas;
    }

    public void setAantalpaginas(int aantalpaginas) {
        if (aantalpaginas<5){
            throw new IllegalArgumentException("Een boek moet minstens 5 pagina's hebben.");
        }
        this.aantalpaginas = aantalpaginas;
    }


    @Override
    public String toString() {
        return  "\'"+titel + "\' geschreven door " + auteur + " en telt " + aantalpaginas +" pagina's.";
    }

}
