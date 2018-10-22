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

        listItems.add(new MusicGender(R.drawable.salsa_dancers, getResources().getString(R.string.descSalsa), 89));
        listItems.add(new MusicGender(R.drawable.reggeaton_dancers, getResources().getString(R.string.descReggeaton), 125));
        listItems.add(new MusicGender(R.drawable.pop_dancers, getResources().getString(R.string.descPop), 210));
        listItems.add(new MusicGender(R.drawable.electronica_dancers, getResources().getString(R.string.descElectronica), 187));
        listItems.add(new MusicGender(R.drawable.bachata_dancers, getResources().getString(R.string.descBachata), 95));
        listItems.add(new MusicGender(R.drawable.ballenato_dancers, getResources().getString(R.string.descBallenato), 150));

        return listItems;
    }
}
