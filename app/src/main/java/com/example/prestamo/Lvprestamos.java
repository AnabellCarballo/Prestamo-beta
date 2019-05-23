package com.example.prestamo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lvprestamos extends AppCompatActivity {
    PrestamoAdapter prestamoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvprestamos);

        ListView lvprestamos =  findViewById(R.id.lvprestamos);
        

        prestamoAdapter = new PrestamoAdapter(this,R.layout.itemprestamo,Datos.prestamos);
        lvprestamos.setAdapter(prestamoAdapter);

       //Toast.makeText(this, Datos.prestamos.get(0).getNombre(), Toast.LENGTH_SHORT).show();





    }
}
