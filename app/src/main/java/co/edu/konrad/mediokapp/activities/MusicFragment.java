package co.edu.konrad.mediokapp.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.adapter.GymAdapter;
import co.edu.konrad.mediokapp.adapter.MusicAdapter;
import co.edu.konrad.mediokapp.entities.GymExercises;
import co.edu.konrad.mediokapp.entities.MusicGender;


public class MusicFragment extends Fragment {

    private ListView items;
    private MusicAdapter adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Musica Bailable");
        items = (ListView) getView().findViewById(R.id.lvItems);
        adaptador = new MusicAdapter(getContext(), GetArrayItems());
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
