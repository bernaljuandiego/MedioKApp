package co.edu.konrad.mediokapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import co.edu.konrad.mediokapp.R;
import co.edu.konrad.mediokapp.adapter.GymAdapter;
import co.edu.konrad.mediokapp.entities.Asistente;
import co.edu.konrad.mediokapp.entities.Exercises;


public class AgregarUsuarioFragment extends Fragment {

    private EditText nombreRegistro;
    private EditText apellidoRegistro;
    private EditText codigoRegistro;
    private EditText cedulaRegistro;
    private Spinner carreraRegistro;
    private Spinner tipoUsuarioRegistro;
    private Button botonRegistro;
    private DatabaseReference baseDeDatos;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agregar_usuario, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Agregar Usuario");

        baseDeDatos = FirebaseDatabase.getInstance().getReference("Asistente");

        nombreRegistro = (EditText) getView().findViewById(R.id.nombreRegistro);
        apellidoRegistro = (EditText) getView().findViewById(R.id.apellidoRegistro);
        codigoRegistro = (EditText) getView().findViewById(R.id.codigoRegistro);
        cedulaRegistro = (EditText) getView().findViewById(R.id.cedulaRegistro);
        carreraRegistro = (Spinner) getView().findViewById(R.id.carreraRegistro);
        tipoUsuarioRegistro = (Spinner) getView().findViewById(R.id.tipoUsuarioRegistro);
        botonRegistro = (Button) getView().findViewById(R.id.botonRegistro);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEstudiante();
            }
        });

    }

    public void registrarEstudiante(){
        String nombre = nombreRegistro.getText().toString();
        String apellido = apellidoRegistro.getText().toString();;
        int codigo = Integer.parseInt(codigoRegistro.getText().toString());
        int cedula = Integer.parseInt(cedulaRegistro.getText().toString());
        //String carrera = carreraRegistro.getSelectedItem().toString();
        //String tipoUsuario = tipoUsuarioRegistro.getSelectedItem().toString();
        if (!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido)){
            String id = baseDeDatos.push().getKey();
            Asistente nuevoRegistro = new Asistente(cedula, codigo, nombre,apellido,null,null,null);
            baseDeDatos.child("Asistente").child(id).setValue(nuevoRegistro);
        }
    }

}
