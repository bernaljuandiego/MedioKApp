package co.edu.konrad.mediokapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.entities.Asistencia;
import co.edu.konrad.mediokapp.entities.Asistente;
import co.edu.konrad.mediokapp.entities.Carreer;


public class AsistenciaFragment extends Fragment {

    private EditText codigoRegistro;
    private Spinner jornadaRegistro;
    private Button botonRegistro;
    private DatabaseReference baseDeDatos;
    private List<String> listJornada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_asistencia, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Agregar Asistencia");

        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos");

        listJornada = new ArrayList<>();

        codigoRegistro = (EditText) getView().findViewById(R.id.codigoRegistro);
        jornadaRegistro = (Spinner) getView().findViewById(R.id.carreraRegistro);
        botonRegistro = (Button) getView().findViewById(R.id.botonRegistroAsistencia);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEstudiante();
            }
        });

        listJornada.add(new String("Gimnasio"));
        listJornada.add(new String("Salon de danza"));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, listJornada);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jornadaRegistro.setAdapter(adapter);

    }

    public void registrarEstudiante(){
        try {
            int codigo = Integer.parseInt(codigoRegistro.getText().toString());
            baseDeDatos.child("Usuario").orderByChild("codigoAsistente")
                    .equalTo(codigo)
                    .limitToFirst(1)
                    .addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            String jornada = (String) jornadaRegistro.getSelectedItem();
                            Asistente asistente = dataSnapshot.getValue(Asistente.class);
                            Date date = new Date();
                            Date newDate = new Date(date.getTime() + (604800000L * 2) + (24 * 60 * 60));
                            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                            String stringdate = dt.format(newDate);
                            String id = baseDeDatos.push().getKey();
                            Asistencia nuevoRegistro = new Asistencia(asistente,stringdate,jornada);
                            baseDeDatos.child("Asistencia").child(id).setValue(nuevoRegistro);
                            Toast.makeText(getContext(), "Agregado Correctamente", Toast.LENGTH_LONG).show();
                            codigoRegistro.setText("");
                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
            Toast.makeText(getContext(), "Usuario no registrado!", Toast.LENGTH_LONG).show();
        } catch (NumberFormatException ex){
            Toast.makeText(getContext(), "INGRESE UN CODIGO VALIDO!", Toast.LENGTH_LONG).show();
        }
    }


    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        anim = AnimationUtils.loadAnimation(getContext(), R.anim.translate);
        anim.reset();
        CardView l=(CardView) getView().findViewById(R.id.card);
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

    @Override
    public void onResume() {
        super.onResume();
        StartAnimations();
    }
}
