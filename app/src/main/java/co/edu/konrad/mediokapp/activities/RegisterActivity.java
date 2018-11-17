 package co.edu.konrad.mediokapp.activities;

 import android.os.Bundle;
 import android.support.annotation.NonNull;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.ArrayAdapter;
 import android.widget.EditText;
 import android.widget.Toast;

 import com.google.firebase.FirebaseApp;
 import com.google.firebase.database.DataSnapshot;
 import com.google.firebase.database.DatabaseError;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.ValueEventListener;

 import java.util.ArrayList;
 import java.util.List;

 import co.edu.konrad.mediokapp.R;
 import co.edu.konrad.mediokapp.entities.Persona;

 public class RegisterActivity extends AppCompatActivity {

    private List<Persona> listPersona = new ArrayList<Persona>();
    ArrayAdapter<Persona> arrayAdapterPersona;

    EditText fechaP, codigoP;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fechaP = findViewById(R.id.txtFecha);
        codigoP = findViewById(R.id.txtCodigo);

        inicializarFirebase();

        listarDatos();

    }

     private void listarDatos() {

        final String codigo = "506132020";
        final boolean flag = false;

        databaseReference.child("Estudiante").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listPersona.clear();
                for(DataSnapshot objSnapshot : dataSnapshot.getChildren()) {


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

     }

     private void inicializarFirebase() {
         FirebaseApp.initializeApp(this);
         firebaseDatabase = FirebaseDatabase.getInstance();
         databaseReference = firebaseDatabase.getReference();
     }

     public void Registrar(View view) {

        String codigo = fechaP.getText().toString();
        String fecha = codigoP.getText().toString();

        if (codigo.equals("") || fecha.equals("")) {
            validacion();
        } else {
            Toast.makeText(this, "Bienvenido " + codigo, Toast.LENGTH_SHORT).show();
            limpiarTexto();
        }

     }

     private void limpiarTexto() {
        codigoP.setText("");
        fechaP.setText("");
     }

     private void validacion() {

        String codigo = codigoP.getText().toString();
        String fecha = fechaP.getText().toString();

        if (codigo.equals("")) {
            codigoP.setError("Recuerda que tu código es importante para el registro");
        } else if (fecha.equals("")){
            fechaP.setError("No olvides ingresar la fecha");
         }

     }
 }
