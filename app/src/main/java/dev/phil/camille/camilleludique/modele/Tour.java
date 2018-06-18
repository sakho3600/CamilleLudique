package dev.phil.camille.camilleludique.modele;

import java.util.ArrayList;

public class Tour {
    private static int num = 0;
    private int nbDe;
    private ArrayList<De> alDes = new ArrayList<>();
    private int totalDe;

    public Tour(int nbDe) {
        this.nbDe=nbDe;
        this.totalDe = 0;
        for (int i = 0; i < nbDe; i++) {
            De de = new De();
            alDes.add(de);
        }
        num++;
    }

    public void jouerTour(){
        for (int i = 0; i < nbDe; i++) {
           alDes.get(i).jeter();
        }
    }

    public int getTotalDe() {
        this.totalDe=0;
        for (int i = 0; i < nbDe; i++) {
            this.totalDe += alDes.get(i).getNb();
        }
        return this.totalDe;
    }

    public ArrayList<De> getAlDes() {
        return alDes;
    }

    public static int getNum() {
        return num;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i;
        for(i = 0; i<nbDe;i++){
            sb.append(alDes.get(i).getNb());
            if(i != nbDe-1)sb.append("+");
        }
        sb.append(" = ");
        sb.append(getTotalDe());
        return sb.toString();
    }
}
