package co.edu.konrad.mediokapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.adapter.UsuarioAdapter;
import co.edu.konrad.mediokapp.entities.Asistente;

public class ListarFragment extends Fragment {
    private RecyclerView items;
    private UsuarioAdapter adaptador;
    private Button btnVolverCatalogo;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DatabaseReference baseDeDatos;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Listar Asistentes");
        baseDeDatos = FirebaseDatabase.getInstance().getReference("Asistente");
        baseDeDatos.child("Asistente/Asistente").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                GenericTypeIndicator<ArrayList<Asistente>> t = new GenericTypeIndicator<ArrayList<Asistente>>() {};
                ArrayList<Asistente> yourStringArray = snapshot.getValue(t);
                items = (RecyclerView) getView().findViewById(R.id.listaCategoria);
                items.setHasFixedSize(true);

                // use a linear layout manager
                mLayoutManager = new LinearLayoutManager(getContext());
                items.setLayoutManager(mLayoutManager);

                // specify an adapter (see also next example)
                mAdapter = new UsuarioAdapter(yourStringArray);
                items.setAdapter(mAdapter);
            }
            @Override
            public void onCancelled(DatabaseError firebaseError) {
                Log.e("The read failed: " ,firebaseError.getMessage());
            }
        });



    }
}
