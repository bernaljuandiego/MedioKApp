package co.edu.konrad.mediokapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.adapter.gymAdapter;
import co.edu.konrad.mediokapp.adapter.musicAdapter;
import co.edu.konrad.mediokapp.entities.musicGender;

public class musicGenderActivity extends AppCompatActivity {

    private ListView items;
    private musicAdapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_gender);

        items = (ListView) findViewById(R.id.lvItems);
        adaptador = new musicAdapter(this, GetArrayItems());

        items.setAdapter(adaptador);
    }

    private ArrayList<musicGender> GetArrayItems() {
        ArrayList<musicGender> listItems = new ArrayList<>();

        listItems.add(new musicGender(R.mipmap.ic_abdominales,"Salsa",2));
        listItems.add(new musicGender(R.mipmap.ic_brazos,"Reggeaton", 2));

        return listItems;
    }
}
