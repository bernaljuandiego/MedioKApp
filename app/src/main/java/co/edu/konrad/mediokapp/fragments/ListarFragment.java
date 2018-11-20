package co.edu.konrad.mediokapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import co.edu.konrad.mediokapp.entities.Asistencia;
import co.edu.konrad.mediokapp.entities.Asistente;

public class ListarFragment extends Fragment {
    private RecyclerView items;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DatabaseReference baseDeDatos;
    private ArrayList<Asistencia> asistentes;
    private ValueEventListener lisener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Listar Asistentes");
        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos");
        asistentes = new ArrayList<>();
    }

    @Override
    public void onResume() {
        super.onResume();
        StartAnimations();
        lisener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                asistentes.clear();

                for (DataSnapshot asistenteSnapshot: snapshot.getChildren()) {
                    Asistencia asistenteS = asistenteSnapshot.getValue(Asistencia.class);
                    asistentes.add(asistenteS);
                }

                items = (RecyclerView) getView().findViewById(R.id.listaCategoria);
                items.setHasFixedSize(true);

                // use a linear layout manager
                mLayoutManager = new LinearLayoutManager(getContext());
                items.setLayoutManager(mLayoutManager);

                // specify an adapter (see also next example)
                mAdapter = new UsuarioAdapter(asistentes);
                items.setAdapter(mAdapter);
            }
            @Override
            public void onCancelled(DatabaseError firebaseError) {
                Log.e("The read failed: " ,firebaseError.getMessage());
            }
        };
        baseDeDatos.child("Asistencia").orderByValue().addValueEventListener(lisener);
    }

    @Override
    public void onPause() {
        super.onPause();
        baseDeDatos.child("Asistencia").removeEventListener(lisener);
    }


    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        anim = AnimationUtils.loadAnimation(getContext(), R.anim.translate);
        anim.reset();
        RelativeLayout l=(RelativeLayout) getView().findViewById(R.id.card);
        l.clearAnimation();
        l.startAnimation(anim);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // SplashActivity screen pause time
                    while (waited < 1000) {
                        sleep(100);
                        waited += 100;
                    }
                } catch (InterruptedException e) {
                } finally {
                }

            }
        };
        splashTread.start();

    }
}
