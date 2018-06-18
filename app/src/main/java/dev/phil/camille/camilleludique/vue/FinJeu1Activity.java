package dev.phil.camille.camilleludique.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import dev.phil.camille.camilleludique.R;

public class FinJeu1Activity extends AppCompatActivity {

    TextView lblScoreFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_jeu1);
        init();
        Intent intent = getIntent();
        String score = intent.getStringExtra("score");
        String nbTours = intent.getStringExtra("nbTours");
        lblScoreFinal.setText(conclusion(Integer.parseInt(score), Integer.parseInt(nbTours)));

    }

    private String conclusion(int score, int max) {
        String ch = null;
        if (score <= 3) {
            ch = "Pas terrible : ";
        } else if (score <= 5) {
            ch = "Moyen : ";
        } else if (score <= 7) {
            ch = "Assez bien : ";
        } else if (score <= 9) {
            ch = "Bien : ";
        } else if (score == 10) {
            ch = "Félicitation : ";
        }
        return ch + String.valueOf(score) + "/" + String.valueOf(max);
    }

    private void init() {
        lblScoreFinal = (TextView) findViewById(R.id.lblScoreFinal);
    }
}
