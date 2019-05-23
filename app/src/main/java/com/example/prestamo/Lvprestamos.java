package com.example.prestamo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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





    }
}
