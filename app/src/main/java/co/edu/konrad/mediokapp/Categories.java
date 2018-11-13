package co.edu.konrad.mediokapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.entities.Categoria;

public class Categories extends AppCompatActivity {

    private RecyclerView items;
    private AdapterCategoria adaptador;
    private Button btnVolverCatalogo;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        items = (RecyclerView) findViewById(R.id.listaCategoria);


        items.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        items.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new AdapterCategoria(GetArrayItems());
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
