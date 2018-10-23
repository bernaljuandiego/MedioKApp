package co.edu.konrad.mediokapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.edu.konrad.mediokapp.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void goGym(View view) {
        Intent intent = new Intent(this, GymExerciseActivity.class);
        startActivity(intent);
    }

    public void goMusic(View view) {
        Intent intent = new Intent(this, MusicGenderActivity.class);
        startActivity(intent);
    }

    public void goStatics(View view) {
    }
}
