package co.edu.konrad.mediokapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.adapter.MusicAdapter;
import co.edu.konrad.mediokapp.entities.MusicGender;

public class MusicGenderActivity extends AppCompatActivity {

    private ListView items;
    private MusicAdapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_gender);

        items = (ListView) findViewById(R.id.lvItems);
        adaptador = new MusicAdapter(this, GetArrayItems());

        items.setAdapter(adaptador);
    }

    private ArrayList<MusicGender> GetArrayItems() {
        ArrayList<MusicGender> listItems = new ArrayList<>();

        listItems.add(new MusicGender(R.mipmap.ic_salsa,"Salsa",2));
        listItems.add(new MusicGender(R.mipmap.ic_reggeaton,"Reggeaton", 2));

        return listItems;
    }
}
