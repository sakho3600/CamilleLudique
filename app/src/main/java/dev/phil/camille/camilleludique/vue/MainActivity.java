package dev.phil.camille.camilleludique.vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import dev.phil.camille.camilleludique.R;
import dev.phil.camille.camilleludique.modele.De;

public class MainActivity extends AppCompatActivity {

    Button btnCommencerJeu1;
    SeekBar seekBarNiveau;
    int niveau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnCommencerJeu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                niveau = seekBarNiveau.getProgress() + 1;
                Intent intentJeu1Activity = new Intent(MainActivity.this, Jeu1Activity.class);
                intentJeu1Activity.putExtra("niveau", String.valueOf(niveau));
                startActivity(intentJeu1Activity);
            }
        });

    }

    private void init() {
        btnCommencerJeu1 = (Button) findViewById(R.id.btnCommencerJeu1);
        seekBarNiveau = (SeekBar) findViewById(R.id.seekBarNiveau);
    }
}
