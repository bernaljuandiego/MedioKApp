package co.edu.konrad.mediokapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.entities.Asistente;
import co.edu.konrad.mediokapp.entities.Carreer;
import co.edu.konrad.mediokapp.entities.Faculty;
import co.edu.konrad.mediokapp.entities.Jornada;
import co.edu.konrad.mediokapp.entities.TipoUsuario;


public class AgregarUsuarioFragment extends Fragment {

    private EditText nombreRegistro;
    private EditText apellidoRegistro;
    private EditText codigoRegistro;
    private EditText cedulaRegistro;
    private Spinner carreraRegistro;
    private Spinner jornadaRegistro;
    private Spinner tipoUsuarioRegistro;
    private Button botonRegistro;
    private DatabaseReference baseDeDatos;
    private List<TipoUsuario> listTipoUsuario;
    private List<Carreer> listCarrera;
    private List<Jornada> listJornada;
    private ValueEventListener lisenerTipoUsuario;
    private ValueEventListener lisenerCarrera;
    private ValueEventListener lisenerJornada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agregar_usuario, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Agregar Usuario");

        baseDeDatos = FirebaseDatabase.getInstance().getReference("BaseDatos");

        listTipoUsuario = new ArrayList<>();
        listCarrera = new ArrayList<>();
        listJornada = new ArrayList<>();

        nombreRegistro = (EditText) getView().findViewById(R.id.nombreRegistro);
        apellidoRegistro = (EditText) getView().findViewById(R.id.apellidoRegistro);
        codigoRegistro = (EditText) getView().findViewById(R.id.codigoRegistro);
        cedulaRegistro = (EditText) getView().findViewById(R.id.cedulaRegistro);
        carreraRegistro = (Spinner) getView().findViewById(R.id.carreraRegistro);
        tipoUsuarioRegistro = (Spinner) getView().findViewById(R.id.tipoUsuarioRegistro);
        jornadaRegistro = (Spinner) getView().findViewById(R.id.jornadaRegistro);
        botonRegistro = (Button) getView().findViewById(R.id.botonRegistro);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEstudiante();
            }
        });

    }

    public void registrarEstudiante(){
        try {
            String nombre = nombreRegistro.getText().toString();
            String apellido = apellidoRegistro.getText().toString();
            int codigo = Integer.parseInt(codigoRegistro.getText().toString());
            int cedula = Integer.parseInt(cedulaRegistro.getText().toString());
            Carreer carrera = (Carreer) carreraRegistro.getSelectedItem();
            TipoUsuario tipoUsuario = (TipoUsuario) tipoUsuarioRegistro.getSelectedItem();
            Jornada jornada = (Jornada) jornadaRegistro.getSelectedItem();
            if (!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido)) {
                String id = baseDeDatos.push().getKey();
                Asistente nuevoRegistro = new Asistente(cedula, codigo, nombre, apellido, tipoUsuario, jornada, carrera);
                baseDeDatos.child("Usuario").child(Integer.toString(codigo)).setValue(nuevoRegistro);
                Toast.makeText(getContext(), "Agregado Correctamente", Toast.LENGTH_LONG).show();
                nombreRegistro.setText("");
                apellidoRegistro.setText("");
                codigoRegistro.setText("");
                cedulaRegistro.setText("");
            } else {
                Toast.makeText(getContext(), "Completar los campos!", Toast.LENGTH_LONG).show();
            }
        } catch (NumberFormatException ex){
            Toast.makeText(getContext(), "llenar los campos numericos", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        lisenerTipoUsuario = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listTipoUsuario.clear();
                for (DataSnapshot tipoUsuarioSnapshot: dataSnapshot.getChildren()) {
                    TipoUsuario tipoUsuario = tipoUsuarioSnapshot.getValue(TipoUsuario.class);
                    listTipoUsuario.add(tipoUsuario);
                }
                ArrayAdapter<TipoUsuario> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, listTipoUsuario);
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
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Jornada jornada = snapshot.getValue(Jornada.class);
                    listJornada.add(jornada);
                }
                ArrayAdapter<Jornada> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, listJornada);
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
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Carreer carreer = snapshot.getValue(Carreer.class);
                    listCarrera.add(carreer);
                }
                ArrayAdapter<Carreer> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, listCarrera);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                carreraRegistro.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        baseDeDatos.child("Jornada").addValueEventListener(lisenerJornada);
        baseDeDatos.child("Carreer").addValueEventListener(lisenerCarrera);
        baseDeDatos.child("TipoUsuario").addValueEventListener(lisenerTipoUsuario);
    }

    @Override
    public void onPause() {
        super.onPause();
        baseDeDatos.child("Jornada").removeEventListener(lisenerJornada);
        baseDeDatos.child("Carreer").removeEventListener(lisenerTipoUsuario);
        baseDeDatos.child("TipoUsuario").removeEventListener(lisenerTipoUsuario);
    }
}
