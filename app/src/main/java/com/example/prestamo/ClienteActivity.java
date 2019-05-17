package com.example.prestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ClienteActivity extends AppCompatActivity {

    public  TextView nombre ;
    public  TextView apellido ;
    public TextView telefono ;
    public  TextView cedula ;
    public  TextView direccion ;
    public  TextView ocupacion;
    public  TextView sexo;

   int i=0,temp=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);



        nombre = findViewById(R.id.nombre);

        telefono =findViewById(R.id.telefono);
        cedula = findViewById(R.id.cedula);
        direccion = findViewById(R.id.direccion);
        ocupacion =  findViewById(R.id.ocupacion);

        mostrar();

    }
    public  void mostrar (){

        nombre.setText(Datos.clientes.get(i).getNombre());
        apellido.setText(Datos.clientes.get(i).getApellido());
        telefono.setText(Datos.clientes.get(i).getTelefono());
        cedula.setText(Datos.clientes.get(i).getCedula());
        direccion.setText(Datos.clientes.get(i).getDireccion());
        ocupacion.setText(Datos.clientes.get(i).getOcupacion());
        sexo.setText(Datos.clientes.get(i).getSexo());

    }

    public void onClick3(View view) {
        if (view.getId() == R.id.npres) {
            Intent intent1 = new Intent(ClienteActivity.this, Main2ActivityRegistro.class);
            //intent1.putExtra("res",nombre.getText().toString());
            startActivity(intent1);
        } else if (view.getId() == R.id.btnsig) {
                if (i == Datos.clientes.size() - 1)
                    Toast.makeText(this, "Este es el ultimo registro", Toast.LENGTH_SHORT).show();
                else
                {
                    i= i +1;
                    mostrar();
                }

            }
            else
                {
                    if (i == temp )
                        Toast.makeText(this, "Este es el primer registro", Toast.LENGTH_SHORT).show();
                    else
                    {
                        i= i -1;
                        mostrar();
                    }
                }


        }}
