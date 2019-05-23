package com.example.prestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText nombre;
    Spinner sexo;
    EditText apellido;
    EditText cedula;
    EditText telefono;
    EditText direccion;
    EditText ocupacion;
    int  pos=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras=getIntent().getExtras();
        nombre = findViewById(R.id.nombre);
        sexo = findViewById(R.id.spinner);
        apellido = findViewById(R.id.apellido);
        cedula = findViewById(R.id.cedula);
        telefono = findViewById(R.id.telefono);
        direccion = findViewById(R.id.direccion);
        ocupacion = findViewById(R.id.ocupacion);

        if(extras!=null){
            pos= Integer.parseInt(extras.getString("posicion"));
            edit(pos);
        }

    }
    public void edit(int i){
        nombre.setText(Datos.clientes.get(i).getNombre());
        if(Datos.clientes.get(i).getSexo().equals("Femenino"))
            sexo.setSelection(0);
        else
            sexo.setSelection(1);
        apellido.setText(Datos.clientes.get(i).getApellido());
        cedula.setText(Datos.clientes.get(i).getCedula());
        telefono.setText(Datos.clientes.get(i).getTelefono());
        direccion.setText(Datos.clientes.get(i).getDireccion());
        ocupacion.setText(Datos.clientes.get(i).getOcupacion());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.prestamosm, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnguardar:

                /*nombre = findViewById(R.id.nombre);
                sexo = findViewById(R.id.spinner);
                apellido = findViewById(R.id.apellido);
                cedula = findViewById(R.id.cedula);
                telefono = findViewById(R.id.telefono);
                direccion = findViewById(R.id.direccion);
                ocupacion = findViewById(R.id.ocupacion);*/

                if(pos==-1){
                    if (!nombre.getText().toString().isEmpty() && !telefono.getText().toString().isEmpty() && !cedula.getText().toString().isEmpty() && !direccion.getText().toString().isEmpty()) {
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

                    setResult(RESULT_OK, intent);
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
                }
                else {
                    Datos.clientes.get(pos).setNombre(nombre.getText().toString());
                    Datos.clientes.get(pos).setApellido(apellido.getText().toString());
                    Datos.clientes.get(pos).setCedula(cedula.getText().toString());
                    Datos.clientes.get(pos).setDireccion(direccion.getText().toString());
                    Datos.clientes.get(pos).setOcupacion(ocupacion.getText().toString());
                    Datos.clientes.get(pos).setTelefono(telefono.getText().toString());
                    Datos.clientes.get(pos).setSexo(sexo.getSelectedItem().toString());
                    pos=-1;
                    Intent intent = getIntent();
                    setResult(RESULT_OK, intent);

                    finish();
                }
                break;
            case R.id.mncancelar:
                Intent intent = getIntent();
                intent.putExtra("valor2", "Cancelo ingreso nuevo cliente");
                setResult(RESULT_CANCELED, intent);

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



