package com.example.prestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button continuar = findViewById(R.id.btncontinuar);
        continuar.setOnClickListener(new View.OnClickListener() {




            public void onClick(View v ) {
                nombre = findViewById(R.id.nombre);
                Spinner sexo = findViewById(R.id.spinner);
                EditText  apellido = findViewById(R.id.apellido);
                EditText cedula = findViewById(R.id.cedula);
                EditText telefono = findViewById(R.id.telefono);
                EditText direccion = findViewById(R.id.direccion);
                EditText ocupacion = findViewById(R.id.ocupacion);




                if (!nombre.getText().toString().isEmpty() && !telefono.getText().toString().isEmpty() && !cedula.getText().toString().isEmpty() && !direccion.getText().toString().isEmpty()) {

//                    Intent intent = new Intent(getApplicationContext(), Main2ActivityRegistro.class);
//                    startActivity(intent);

                    Cliente n = new Cliente();

                    n.setNombre(nombre.getText().toString());
                    n.setApellido(apellido.getText().toString());
                    n.setCedula(cedula.getText().toString());
                    n.setDireccion(direccion.getText().toString());
                    n.setOcupacion(ocupacion.getText().toString());
                    n.setSexo(sexo.getSelectedItem().toString());
                    n.setTelefono(telefono.getText().toString());

                     Datos.clientes.add(n);
                    Intent intent = getIntent();
                    String h = nombre.getText().toString();
                    intent.putExtra("valor", "Ingreso de nuevo cliente " + h);

                    setResult(RESULT_OK,intent);
                    finish();

                } else {
                    if (nombre.getText().toString().isEmpty()) {
                        nombre.setError("Debe ser llenado el campo");
                    } else if (telefono.getText().toString().isEmpty()) {
                        telefono.setError("Debe ser llenado el campo");
                    } else if (cedula.getText().toString().isEmpty()) {
                        cedula.setError("Debe ser llenado el campo");
                    } else if (direccion.getText().toString().isEmpty()) {
                        direccion.setError("Debe ser llenado el campo");
                    }

                }
            };
        });}



    public void onClick2(View view) {
        Intent intent = getIntent();
        intent.putExtra("valor2", "Cancelo ingreso nuevo cliente");
        setResult(RESULT_CANCELED, intent);

        finish();


    }
}


