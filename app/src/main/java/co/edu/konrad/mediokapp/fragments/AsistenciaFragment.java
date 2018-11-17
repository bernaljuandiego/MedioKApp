package co.edu.konrad.mediokapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
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
    private ValueEventListener lisenerJornada;

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
        botonRegistro = (Button) getView().findViewById(R.id.botonRegistro);
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
            String codigo = codigoRegistro.getText().toString();
            String jornada = (String) jornadaRegistro.getSelectedItem();
            Asistente asistente = (Asistente) null;
            Date date = new Date();
            Date newDate = new Date(date.getTime() + (604800000L * 2) + (24 * 60 * 60));
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            String stringdate = dt.format(newDate);
            Asistencia nuevoRegistro = new Asistencia(asistente,stringdate,jornada);
            baseDeDatos.child("Asistencia").child(codigo).setValue(nuevoRegistro);
                Toast.makeText(getContext(), "Agregado Correctamente", Toast.LENGTH_LONG).show();
                codigoRegistro.setText("");
        } catch (NumberFormatException ex){
            Toast.makeText(getContext(), "llenar los campos numericos", Toast.LENGTH_LONG).show();
        }
    }


}
