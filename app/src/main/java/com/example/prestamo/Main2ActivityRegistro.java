package com.example.prestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.example.prestamo.Datos.*;


public class Main2ActivityRegistro extends AppCompatActivity {
    private Spinner spcliente;
    private String recibido=null;
    private  ArrayAdapter<String> adapter;

        //declaraciones
    Spinner  rcliente;
        Spinner interes;
        EditText fecha ;
        EditText fechafin ;
        EditText plazo ;
        EditText monto ;
        TextView paga;
        TextView cuota;
    Date cal = Calendar.getInstance().getTime();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


    int p = 1;
    int m = 0;
    int in;
    public List<String> temp = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_registro);

        interes = findViewById(R.id.interes);
        fecha = findViewById(R.id.fecha);
        fechafin = findViewById(R.id.fechafin);
        monto = findViewById(R.id.monto);
        paga = findViewById(R.id.paga);
        cuota = findViewById(R.id.cuota);
        interes = findViewById(R.id.interes);
        plazo = findViewById(R.id.plazo);
        rcliente = findViewById(R.id.spcliente);

        for ( int j = 0;j <Datos.clientes.size();j++){
            String b = Datos.clientes.get(j).getNombre();
            String o = b + " " + Datos.clientes.get(j).getApellido();
            temp.add(o);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,temp);
            //Asignar Adaptador
            rcliente.setAdapter(adapter);
        }

        Button btn = findViewById(R.id.btnguardar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Prestamo m = new Prestamo();

              m.setFechainicio(fecha.getText().toString());
              m.setFechafin(fechafin.getText().toString());
              m.setNombre(rcliente.getSelectedItem().toString());
              m.setMonto(monto.getText().toString());
              m.setInteres(interes.getSelectedItem().toString());
              m.setCuota(cuota.getText().toString());
              m.setPlazo(plazo.getText().toString().toString());
              m.setPaga(paga.getText().toString());


                Datos.prestamos.add(m);
                Intent intent = getIntent();
                intent.putExtra("valor", "Ingreso de nuevo Prestamo");
                setResult(RESULT_OK,intent);
                finish();



            }
        });


        //usamos la propiedad formatter para poder asiggnar el formato de la fecha el cual recibe un objeto tipo date
        String dt = formatter.format(cal);
        fecha.setText(dt);
        if (plazo.getText().toString().isEmpty()) {

            Calendar calo = Calendar.getInstance();
            calo.setTime(cal);
            calo.add(Calendar.MONTH, 1);
            Date datees = calo.getTime();
            String dto = formatter.format(datees);
            fechafin.setText(dto);
        }


        monto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    m = Integer.parseInt(s.toString());
                    calcular();


                }
                else {
                m =0;
                calcular();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //confirmar si el plazo esta vacio


            }
        });




        interes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    in = Integer.parseInt(adapterView.getSelectedItem().toString());
                    calcular();


            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        plazo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty())
                {
                    p = Integer.parseInt(s.toString());
                    calcular();
                }
                else
                {
                    p =1;
                    calcular();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


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

                Prestamo m = new Prestamo();

                m.setFechainicio(fecha.getText().toString());
                m.setFechafin(fechafin.getText().toString());
                m.setNombre(rcliente.getSelectedItem().toString());
                m.setMonto(monto.getText().toString());
                m.setInteres(interes.getSelectedItem().toString());
                m.setCuota(cuota.getText().toString());
                m.setPlazo(plazo.getText().toString().toString());
                m.setPaga(paga.getText().toString());


                Datos.prestamos.add(m);
                Intent intent = getIntent();
                intent.putExtra("valor", "Ingreso de nuevo Prestamo");
                setResult(RESULT_OK,intent);
                finish();


                break;

            case R.id.mncancelar:
                Intent intent2 = getIntent();
                intent2.putExtra("valor2", "Cancelo ingreso nuevo Prestamo");
                setResult(RESULT_CANCELED, intent2);
                finish();
                break;


        }
        return super.onOptionsItemSelected(item);
    }
    public void calcular()
    {

        double a = ((in  * m) / 100)*p;
         double r = m + a;
        double c = r / p;

        String res = String.valueOf(r);
        String reso = String.valueOf(c);
        paga.setText(res);
        cuota.setText(reso);

        Calendar calo = Calendar.getInstance();
        calo.setTime(cal);
        calo.add(Calendar.MONTH,p);
        Date datees = calo.getTime();
        String dto = formatter.format(datees);
        fechafin.setText(dto);


    }



    public void onClick2(View view) {

        Intent intent = getIntent();
        intent.putExtra("valor2", "Cancelo ingreso nuevo Prestamo");
            setResult(RESULT_CANCELED, intent);
        finish();


    }
}

