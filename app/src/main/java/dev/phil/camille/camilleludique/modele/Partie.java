package dev.phil.camille.camilleludique.modele;

import java.util.ArrayList;

public class Partie {


    public enum Difficulte{
        NIVEAU1, NIVEAU2, NIVEAU3, NIVEAU4, NIVEAU5, NIVEAU6;

    }

    private ArrayList<Tour> alTours = new ArrayList<>();
    private int nbDe;

    public Partie(int nbTours,Difficulte difficulte) {
        this.setDifficulte(difficulte);
        for(int i=0;i<nbTours;i++){
            addTour(new Tour(nbDe));
        }
    }

    public void setDifficulte(Difficulte difficulte){
        switch (difficulte){
            case NIVEAU1:
                this.nbDe = 1;
                break;
            case NIVEAU2:
                this.nbDe = 2;
                break;
            case NIVEAU3:
                this.nbDe = 3;
                break;
            case NIVEAU4:
                this.nbDe = 4;
                break;
            case NIVEAU5:
                this.nbDe = 5;
                break;
            case NIVEAU6:
                this.nbDe = 6;
                break;
        }
    }

    public ArrayList<Tour> getAlTours() {
        return alTours;
    }

    private void addTour(Tour t){
        alTours.add(t);
    }

    public int getNbDe() {
        return nbDe;
    }
}
