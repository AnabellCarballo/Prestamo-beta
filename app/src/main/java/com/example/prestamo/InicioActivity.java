package com.example.prestamo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InicioActivity extends AppCompatActivity {
     public  TextView historial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
    //
    public boolean onCreateOptionsMenu(Menu inicio) {
        getMenuInflater().inflate(R.menu.inicio,inicio); // parametro es el archivo que se creo y donde
        return super.onCreateOptionsMenu(inicio);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mnnuevocl:
                Intent intent = new Intent(InicioActivity.this,MainActivity.class);
                startActivityForResult( intent, 4444 );
                break;
            case R.id.mncancelar:
                Intent intent1 = new Intent(InicioActivity.this,Main2ActivityRegistro.class);
                //intent1.putExtra("res",nombre.getText().toString());
                startActivityForResult( intent1, 4434 );


                break;
            case R.id.mncliente:
                //Log.d("prueba","MenuCliente");
               Intent intent2 = new Intent(this,LvClientes.class);
               startActivity(intent2);

                break;
            case R.id.mnprestamo:
                Intent intent3 = new Intent(InicioActivity.this,Lvprestamos.class);
                startActivity(intent3);
                break;
            case R.id.acerca:
                Toast.makeText(this, "Electiva Android", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        historial=findViewById(R.id.historial);
        registerForContextMenu(historial);
        String h;
        if (requestCode==4444)
        {
            if (resultCode== RESULT_CANCELED) {
                h = data.getExtras().getString("valor2");
                historial.append("\n");
                historial.append(h);
            }
            else
            {
                h = data.getExtras().getString("valor");
                historial.append("\n");
                historial.append(h);
            }


        }
        else if (requestCode==4434)
        {
            if (resultCode== RESULT_CANCELED)
            {
                h = data.getExtras().getString("valor2");
                historial.append("\n");
                historial.append(h);
            }

            else {
                h = data.getExtras().getString("valor");
                historial.append("\n");
                historial.append(h);
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu, menu);


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.copiar:
                String text = historial.getText().toString();
                ClipboardManager myClipboard;
                myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText( " ",text);


                myClipboard.setPrimaryClip(clipData);
                break;
            case R.id.borrar:
                historial.setText(" ");

        }
        return super.onContextItemSelected(item);
    }
}
