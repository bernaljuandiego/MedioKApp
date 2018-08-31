package co.edu.konrad.mediokapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                cambioPantalla();
            }
        }, 2000);
    }

    private void cambioPantalla() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);

    }
}
