package co.edu.konrad.mediokapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.adapter.gymAdapter;
import co.edu.konrad.mediokapp.entities.gymExercises;

public class gymExerciseActivity extends AppCompatActivity {

    private ListView items;
    private gymAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_exercises);

        items = (ListView) findViewById(R.id.lvItems);
        adaptador = new gymAdapter(this, GetArrayItems());

        items.setAdapter(adaptador);
    }

    private ArrayList<gymExercises> GetArrayItems() {
        ArrayList<gymExercises> listItems = new ArrayList<>();

        listItems.add(new gymExercises(R.mipmap.ic_abdominales,"Abdominales",getResources().getString(R.string.descAbdominales)));
        listItems.add(new gymExercises(R.mipmap.ic_brazos,"Brazos",getResources().getString(R.string.descBrazos)));
        listItems.add(new gymExercises(R.mipmap.ic_espalda,"Espalda",getResources().getString(R.string.descEspalda)));
        listItems.add(new gymExercises(R.mipmap.ic_gluteos,"Glúteos",getResources().getString(R.string.descGluteos)));
        listItems.add(new gymExercises(R.mipmap.ic_hombros,"Hombros",getResources().getString(R.string.descHombros)));
        listItems.add(new gymExercises(R.mipmap.ic_pecho,"Pecho",getResources().getString(R.string.descPecho)));
        listItems.add(new gymExercises(R.mipmap.ic_piernas,"Piernas",getResources().getString(R.string.descPiernas)));


        return listItems;
    }
}
