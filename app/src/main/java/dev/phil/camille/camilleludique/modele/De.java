package dev.phil.camille.camilleludique.modele;

import android.util.Log;
import android.widget.ImageView;

import java.util.Random;

public class De {
    private int nb;

    public De() {
        this.nb = 0;
    }

    public void jeter(){
        Random r = new Random();
        this.nb = r.nextInt(6)+1;
    }

    public int getNb() {
        return nb;
    }

}
