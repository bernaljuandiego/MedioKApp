package co.edu.konrad.mediokapp.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.adapter.UsuarioAdapter;
import co.edu.konrad.mediokapp.entities.Categoria;

public class ListarFragment extends Fragment {
    private RecyclerView items;
    private UsuarioAdapter adaptador;
    private Button btnVolverCatalogo;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Listar Asistentes");
        items = (RecyclerView) getView().findViewById(R.id.listaCategoria);
        items.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        items.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new UsuarioAdapter(GetArrayItems());
        items.setAdapter(mAdapter);
    }








    private ArrayList<Categoria> GetArrayItems() {
        ArrayList<Categoria> listItems = new ArrayList<>();
        listItems.add(new Categoria("Juan",R.mipmap.ic_launcher_round, "holi"));
        listItems.add(new Categoria("jaime",R.mipmap.ic_launcher_round, "holi"));
        listItems.add(new Categoria("pepito",R.mipmap.ic_launcher_round, "holi"));
        listItems.add(new Categoria("diego",R.mipmap.ic_launcher_round, "holi"));
        listItems.add(new Categoria("carolina",R.mipmap.ic_launcher_round, "holi"));
        listItems.add(new Categoria("jessica",R.mipmap.ic_launcher_round, "holi"));
        listItems.add(new Categoria("andrea",R.mipmap.ic_launcher_round, "holi"));
        listItems.add(new Categoria("andres",R.mipmap.ic_launcher_round, "holi"));
        listItems.add(new Categoria("camila",R.mipmap.ic_launcher_round, "holi"));
        listItems.add(new Categoria("diana",R.mipmap.ic_launcher_round, "holi"));

        return listItems;
    }

}
