package co.edu.konrad.mediokapp.fragments;


import java.util.List;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.Button;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Spinner;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.text.TextWatcher;
import co.edu.konrad.mediokapp.R;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.support.v4.app.Fragment;
import android.view.animation.Animation;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.annotation.Nullable;
import android.view.animation.AnimationUtils;
import co.edu.konrad.mediokapp.entities.Carreer;
import co.edu.konrad.mediokapp.entities.Jornada;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import co.edu.konrad.mediokapp.entities.Asistente;
import co.edu.konrad.mediokapp.entities.TipoUsuario;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.ValueEventListener;

public class AgregarUsuarioFragment extends Fragment {

    private TextView titulo;
    private Button botonRegistro;
    private EditText nombreRegistro;
    private EditText codigoRegistro;
    private EditText cedulaRegistro;
    private Spinner carreraRegistro;
    private Spinner jornadaRegistro;
    private String nombreRegistroAux;
    private String codigoRegistroAux;
    private List<Carreer> listCarrera;
    private List<Jornada> listJornada;
    private EditText apellidoRegistro;
    private String apellidoRegistroAux;
    private Spinner tipoUsuarioRegistro;
    private TextView textJornadaRegistro;
    private TextView textCarreraRegistro;
    private DatabaseReference baseDeDatos;
    private ValueEventListener lisenerCarrera;
    private ValueEventListener lisenerJornada;
    private List<TipoUsuario> listTipoUsuario;
    private ValueEventListener lisenerTipoUsuario;
    private TextWatcher lisenerCedula;
    private AdapterView.OnItemSelectedListener lisenerx;

    public void registrarEstudiante() {
        try {
            int cedula = Integer.parseInt(cedulaRegistro.getText().toString());
            String nombre = nombreRegistro.getText().toString();
            String apellido = apellidoRegistro.getText().toString();
            TipoUsuario tipoUsuario = (TipoUsuario) tipoUsuarioRegistro.getSelectedItem();
            //registro Estudiante
            if (!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido) && tipoUsuario.getNombreTipoUsuario().equals("Estudiante")) {
                String codigo = codigoRegistro.getText().toString();
                Carreer carrera = (Carreer) carreraRegistro.getSelectedItem();
                Jornada jornada = (Jornada) jornadaRegistro.getSelectedItem();
                Asistente nuevoRegistro = new Asistente(cedula, codigo, nombre, apellido, tipoUsuario, jornada, carrera);
                baseDeDatos.child("Usuario").child(Integer.toString(cedula)).setValue(nuevoRegistro);
                Toast.makeText(getContext(), "Exito!", Toast.LENGTH_LONG).show();
                vaciarCampos();
            }
            if (!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido) && !tipoUsuario.getNombreTipoUsuario().equals("Estudiante")) {
                Asistente nuevoRegistro = new Asistente(cedula, nombre, apellido, tipoUsuario);
                baseDeDatos.child("Usuario").child(Integer.toString(cedula)).setValue(nuevoRegistro);
                Toast.makeText(getContext(), "Exito!", Toast.LENGTH_LONG).show();
                vaciarCampos();
            }
        } catch (NumberFormatException ex) {
            Toast.makeText(getContext(), "llenar los campos ", Toast.LENGTH_LONG).show();
        }
    }

    private void lisenerCodigo() {
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEstudiante();
            }
        });
        lisenerCedula = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    int cedula = Integer.parseInt(cedulaRegistro.getText().toString());
                    baseDeDatos.child("Usuario").orderByChild("cedulaAsistente")
                            .equalTo(cedula)
                            .limitToFirst(1)
                            .addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    final Asistente asistente = dataSnapshot.getValue(Asistente.class);
                                    actualizarCampos(asistente);
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
                } catch (NumberFormatException ex) {
                    dejarComoEstabanCampos();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
        lisenerx = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TipoUsuario tipoUsuario = (TipoUsuario) tipoUsuarioRegistro.getSelectedItem();
                if(tipoUsuario.getNombreTipoUsuario().equals("Estudiante")){
                    textCarreraRegistro.setVisibility(View.VISIBLE);
                    textJornadaRegistro.setVisibility(View.VISIBLE);
                    jornadaRegistro.setVisibility(View.VISIBLE);
                    carreraRegistro.setVisibility(View.VISIBLE);
                    codigoRegistro.setVisibility(View.VISIBLE);
                } else {
                    textCarreraRegistro.setVisibility(View.GONE);
                    textJornadaRegistro.setVisibility(View.GONE);
                    jornadaRegistro.setVisibility(View.GONE);
                    carreraRegistro.setVisibility(View.GONE);
                    codigoRegistro.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        tipoUsuarioRegistro.setOnItemSelectedListener(lisenerx);
        cedulaRegistro.addTextChangedListener(lisenerCedula);
    }

    private void instanciasComponentes() {
        listTipoUsuario = new ArrayList<>();
        listCarrera = new ArrayList<>();
        listJornada = new ArrayList<>();
        nombreRegistroAux = "";
        apellidoRegistroAux = "";
        codigoRegistroAux = "";
    }

    private void obtenerComponentes() {
        titulo = (TextView) getView().findViewById(R.id.titulo);
        textCarreraRegistro = (TextView) getView().findViewById(R.id.textCarreraRegistro);
        textJornadaRegistro = (TextView) getView().findViewById(R.id.textJornadaRegistro);
        nombreRegistro = (EditText) getView().findViewById(R.id.nombreRegistro);
        apellidoRegistro = (EditText) getView().findViewById(R.id.apellidoRegistro);
        codigoRegistro = (EditText) getView().findViewById(R.id.codigoRegistro);
        cedulaRegistro = (EditText) getView().findViewById(R.id.cedulaRegistro);
        carreraRegistro = (Spinner) getView().findViewById(R.id.carreraRegistro);
        tipoUsuarioRegistro = (Spinner) getView().findViewById(R.id.tipoUsuarioRegistro);
        jornadaRegistro = (Spinner) getView().findViewById(R.id.jornadaRegistro);
        botonRegistro = (Button) getView().findViewById(R.id.botonRegistro);
    }

    private void actualizarCampos(Asistente asistente) {
        titulo.setText("Edición de Usuario");
        botonRegistro.setText("EDITAR!");
        botonRegistro.setVisibility(View.VISIBLE);

        nombreRegistroAux = nombreRegistro.getText().toString();
        apellidoRegistroAux = apellidoRegistro.getText().toString();
        codigoRegistroAux = codigoRegistro.getText().toString();

        nombreRegistro.setText(asistente.getNombreAsistente());
        apellidoRegistro.setText(asistente.getApellidoAsistente());
        codigoRegistro.setText(asistente.getCodigoAsistente());
    }

    private void dejarComoEstabanCampos() {
        botonRegistro.setText("REGISTRAR!");
        titulo.setText("Registro de usuarios");
        botonRegistro.setVisibility(View.VISIBLE);
        nombreRegistro.setText(nombreRegistroAux);
        apellidoRegistro.setText(apellidoRegistroAux);
        codigoRegistro.setText(codigoRegistroAux);
    }

    private void vaciarCampos() {
        titulo.setText("Registro de usuarios");
        nombreRegistro.setText("");
        apellidoRegistro.setText("");
        codigoRegistro.setText("");
        cedulaRegistro.setText("");
    }

    private void crearLiseners() {
        lisenerTipoUsuario = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listTipoUsuario.clear();
                for (DataSnapshot tipoUsuarioSnapshot : dataSnapshot.getChildren()) {
                    TipoUsuario tipoUsuario = tipoUsuarioSnapshot.getValue(TipoUsuario.class);
                    listTipoUsuario.add(tipoUsuario);
                }
                ArrayAdapter<TipoUsuario> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, listTipoUsuario);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                tipoUsuarioRegistro.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        lisenerJornada = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listJornada.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Jornada jornada = snapshot.getValue(Jornada.class);
                    listJornada.add(jornada);
                }
                ArrayAdapter<Jornada> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, listJornada);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                jornadaRegistro.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        lisenerCarrera = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listCarrera.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Carreer carreer = snapshot.getValue(Carreer.class);
                    listCarrera.add(carreer);
                }
                ArrayAdapter<Carreer> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, listCarrera);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                carreraRegistro.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        anim = AnimationUtils.loadAnimation(getContext(), R.anim.translate);
        anim.reset();
        CardView l = (CardView) getView().findViewById(R.id.card);
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
        StartAnimations();
        super.onResume();
        lisenerCodigo();
        crearLiseners();
        baseDeDatos.child("Jornada").addValueEventListener(lisenerJornada);
        baseDeDatos.child("Carreer").addValueEventListener(lisenerCarrera);
        baseDeDatos.child("TipoUsuario").addValueEventListener(lisenerTipoUsuario);
    }

    @Override
    public void onPause() {
        super.onPause();
        tipoUsuarioRegistro.setOnItemSelectedListener(lisenerx);
        cedulaRegistro.removeTextChangedListener(lisenerCedula);
        baseDeDatos.child("Jornada").removeEventListener(lisenerJornada);
        baseDeDatos.child("Carreer").removeEventListener(lisenerTipoUsuario);
        baseDeDatos.child("TipoUsuario").removeEventListener(lisenerTipoUsuario);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Agregar Usuario");
        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos");
        obtenerComponentes();
        instanciasComponentes();
        lisenerCodigo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agregar_usuario, container, false);
    }

}
