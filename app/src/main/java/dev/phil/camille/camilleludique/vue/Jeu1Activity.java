package dev.phil.camille.camilleludique.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dev.phil.camille.camilleludique.R;
import dev.phil.camille.camilleludique.modele.De;
import dev.phil.camille.camilleludique.modele.Partie;
import dev.phil.camille.camilleludique.modele.Tour;

public class Jeu1Activity extends AppCompatActivity {

    TextView lblChrono, lblTour, lblScore, lblResReponse;
    ImageView[] tabImgDes = new ImageView[6];
    EditText txtTotalDe;
    Button btnValider;

    final static int NBTOURS = 10;
    int tour = 0;
    int cptTirage = 0;
    int score = 0;
    int niveau = 0;
    int proposition = 0, reponse = 0;

    Partie partie;
    ArrayList<Tour> alTour;
    Tour t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu1);
        init();

        Intent intent = getIntent();
        niveau = Integer.parseInt(intent.getStringExtra("niveau"));

        choixNiveau(niveau);

        alTour = partie.getAlTours();

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtTotalDe.setVisibility(View.VISIBLE);
                t = alTour.get(cptTirage);
                t.jouerTour();

                for (int i = 0; i < partie.getNbDe(); i++) {
                    tabImgDes[i].setVisibility(View.VISIBLE);
                }
                chargerImagesDes(t);

                if (tour >= 1) {
                    String recup = txtTotalDe.getText().toString();
                    if (!recup.equals("")) {
                        proposition = Integer.parseInt(txtTotalDe.getText().toString());
                        if (reponse == proposition) {
                            score++;
                        }
                        if (tour == NBTOURS) {

                            Intent intent = new Intent(Jeu1Activity.this, FinJeu1Activity.class);
                            intent.putExtra("score", String.valueOf(score));
                            intent.putExtra("nbTours", String.valueOf(NBTOURS));
                            startActivity(intent);
                        }
                        lblScore.setText("SCORE : " + score);
                        txtTotalDe.setText("");
                        cptTirage++;
                        tour++;
                    }

                }
                if (tour == 0 || (tour >= 1 && !(txtTotalDe.getText().toString().equals(""))))
                    tour++;

                reponse = t.getTotalDe();
                lblTour.setText(tour + "/" + NBTOURS);
                btnValider.setText("Valider");
            }
        });
    }

    private void choixNiveau(int niv) {
        switch (niv) {
            case 1:
                partie = new Partie(NBTOURS, Partie.Difficulte.NIVEAU1);
                break;
            case 2:
                partie = new Partie(NBTOURS, Partie.Difficulte.NIVEAU2);
                break;
            case 3:
                partie = new Partie(NBTOURS, Partie.Difficulte.NIVEAU3);
                break;
            case 4:
                partie = new Partie(NBTOURS, Partie.Difficulte.NIVEAU4);
                break;
            case 5:
                partie = new Partie(NBTOURS, Partie.Difficulte.NIVEAU5);
                break;
            case 6:
                partie = new Partie(NBTOURS, Partie.Difficulte.NIVEAU6);
                break;
        }
    }

    private void chargerImagesDes(Tour t) {
        int cpt = 0;
        for (De de : t.getAlDes()) {
            switch (de.getNb()) {
                case 1:
                    tabImgDes[cpt].setImageResource(R.drawable.dice1);
                    break;
                case 2:
                    tabImgDes[cpt].setImageResource(R.drawable.dice2);
                    break;
                case 3:
                    tabImgDes[cpt].setImageResource(R.drawable.dice3);
                    break;
                case 4:
                    tabImgDes[cpt].setImageResource(R.drawable.dice4);
                    break;
                case 5:
                    tabImgDes[cpt].setImageResource(R.drawable.dice5);
                    break;
                case 6:
                    tabImgDes[cpt].setImageResource(R.drawable.dice6);
                    break;
            }
            cpt++;

        }

    }

    private void init() {
        lblChrono = (TextView) findViewById(R.id.lblChrono);
        lblTour = (TextView) findViewById(R.id.lblTour);
        lblScore = (TextView) findViewById(R.id.lblScore);
        tabImgDes[0] = (ImageView) findViewById(R.id.imgDe1);
        tabImgDes[1] = (ImageView) findViewById(R.id.imgDe2);
        tabImgDes[2] = (ImageView) findViewById(R.id.imgDe3);
        tabImgDes[3] = (ImageView) findViewById(R.id.imgDe4);
        tabImgDes[4] = (ImageView) findViewById(R.id.imgDe5);
        tabImgDes[5] = (ImageView) findViewById(R.id.imgDe6);
        txtTotalDe = (EditText) findViewById(R.id.txtTotalDe);
        btnValider = (Button) findViewById(R.id.btnValider);
        txtTotalDe.setVisibility(View.INVISIBLE);
    }
}
