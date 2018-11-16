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
import co.edu.konrad.mediokapp.entities.GymExercises;


public class ExercisesFragment extends Fragment {

    private ListView items;
    private GymAdapter adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercises, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Ejercicios Musculares");
        items = (ListView) getView().findViewById(R.id.lvItems);
        adaptador = new GymAdapter(getContext(), GetArrayItems());

        items.setAdapter(adaptador);items = (ListView) getView().findViewById(R.id.lvItems);
        adaptador = new GymAdapter(getContext(), GetArrayItems());

        items.setAdapter(adaptador);
    }

    private ArrayList<GymExercises> GetArrayItems() {
        ArrayList<GymExercises> listItems = new ArrayList<>();
        listItems.add(new GymExercises(R.mipmap.ic_abdominales,"Abdominales",getResources().getString(R.string.descAbdominales)));
        listItems.add(new GymExercises(R.mipmap.ic_brazos,"Brazos",getResources().getString(R.string.descBrazos)));
        listItems.add(new GymExercises(R.mipmap.ic_espalda,"Espalda",getResources().getString(R.string.descEspalda)));
        listItems.add(new GymExercises(R.mipmap.ic_hombros,"Hombros",getResources().getString(R.string.descHombros)));
        listItems.add(new GymExercises(R.mipmap.ic_pecho,"Pecho",getResources().getString(R.string.descPecho)));
        listItems.add(new GymExercises(R.mipmap.ic_piernas,"Piernas",getResources().getString(R.string.descPiernas)));
        return listItems;
    }
}
