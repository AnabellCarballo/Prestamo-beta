package com.example.prestamo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LvClientes extends AppCompatActivity {
    private ClienteAdapter clienteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_clientes);
        final Intent intent[] = new Intent[1];
        RecyclerView lvclientes = findViewById(R.id.rvcliente);
        ClienteAdapter.OnItemClickListener onItemClickListener = new ClienteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position, long id) {
                if (id == R.id.btnborrar) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LvClientes.this);
                    builder.setTitle("Eliminando Cliente");
                    builder.setTitle("Desea eliminar el cliente" + Datos.clientes.get(position).getNombre());
                    builder.setNegativeButton("No", null);
                    builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Datos.clientes.remove(position);
                            clienteAdapter.notifyDataSetChanged();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                } else if (id == R.id.btnedit) {
                    intent[0] = new Intent(LvClientes.this, MainActivity.class);
                    intent[0].putExtra("posicion", String.valueOf(position));
                    startActivityForResult(intent[0], 4443);
                } else {
                    intent[0] = new Intent(LvClientes.this, ClienteActivity.class);
                    intent[0].putExtra("posicion", String.valueOf(position));
                    startActivity(intent[0]);

                }

            }
        };
        clienteAdapter = new ClienteAdapter(Datos.clientes, onItemClickListener);
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        lvclientes.setLayoutManager(manager);
        lvclientes.setAdapter(clienteAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4443)
            if (resultCode == RESULT_OK) {
                clienteAdapter.notifyDataSetChanged();
            }
    }
}