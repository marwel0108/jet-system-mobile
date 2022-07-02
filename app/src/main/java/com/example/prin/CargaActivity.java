package com.example.prin;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.prin.ui.LoginActivity;

public class CargaActivity extends AppCompatActivity {

    private final int DURACION_SPLASH = 2000;
    ProgressBar progreso;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_carga);

        progreso = findViewById(R.id.barra);
        ObjectAnimator.ofInt(progreso, "progress", 20).start();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                ObjectAnimator.ofInt(progreso, "progress", 80).start();
                Intent intent = new Intent(CargaActivity.this, LoginActivity.class);
                startActivity(intent);
                reproducir();
                finish();
            };
        }, DURACION_SPLASH);

    }

    public void reproducir(){
        mp = MediaPlayer.create(this, R.raw.jejeje);
        mp.start();
    }
}