package com.example.prestamo;

import android.content.Intent;
import android.drm.DrmStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrestamoActivity extends AppCompatActivity {
    int i= 0;
    int j= 0;

    TextView nombre;
    TextView monto;
    TextView interes;
    TextView plazo;
    TextView fechai;
    TextView fechafin;
    TextView paga;
    TextView cuota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo);
//        ActionBar bar=getSupportActionBar();
//        bar.setSubtitle("Ingresar Credito");



        nombre = findViewById(R.id.cliente);
        monto = findViewById(R.id.monto);
        interes = findViewById(R.id.Inte);
        plazo = findViewById(R.id.Plazo);
        fechai = findViewById(R.id.fechai);
        fechafin = findViewById(R.id.fechafin);
        paga = findViewById(R.id.paga);
        cuota = findViewById(R.id.cuota);

        mostrar();
    }

    public void mostrar()
    {
        nombre.setText(Datos.prestamos.get(i).getNombre());
        monto.setText(String.valueOf(Datos.prestamos.get(i).getMonto()));
        interes.setText(String.valueOf(Datos.prestamos.get(i).getInteres()));
        plazo.setText(String.valueOf(Datos.prestamos.get(i).getPlazo()));
        fechai.setText(Datos.prestamos.get(i).getFechainicio());
        fechafin.setText(Datos.prestamos.get(i).getFechafin());
        paga.setText(String.valueOf(Datos.prestamos.get(i).getPaga()));
        cuota.setText(String.valueOf(Datos.prestamos.get(i).getCuota()));
    }

    public void onClick(View view) {

       if (view.getId() == R.id.btnsig) {
            if (i == Datos.prestamos.size() - 1)
                Toast.makeText(this, "Este es el ultimo registro", Toast.LENGTH_SHORT).show();
            else
            {
                i= i +1;
                mostrar();
            }

        }
        else
        {
            if (i == j)
                Toast.makeText(this, "Este es el primer registro", Toast.LENGTH_SHORT).show();
            else
            {
                i= i -1;
                mostrar();
            }
        }
    }
}
