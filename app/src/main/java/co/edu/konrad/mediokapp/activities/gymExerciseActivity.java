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

        listItems.add(new gymExercises(R.mipmap.ic_abdominales,"Abdominales","Descripción 1"));
        listItems.add(new gymExercises(R.mipmap.ic_brazos,"Brazos","Descripción 1"));
        listItems.add(new gymExercises(R.mipmap.ic_espalda,"Espalda","Descripción 1"));
        listItems.add(new gymExercises(R.mipmap.ic_gluteos,"Glúteos","Descripción 1"));
        listItems.add(new gymExercises(R.mipmap.ic_hombros,"Hombros","Descripción 1"));
        listItems.add(new gymExercises(R.mipmap.ic_pecho,"Pecho","Descripción 1"));
        listItems.add(new gymExercises(R.mipmap.ic_piernas,"Piernas","Descripción 1"));


        return listItems;
    }
}
