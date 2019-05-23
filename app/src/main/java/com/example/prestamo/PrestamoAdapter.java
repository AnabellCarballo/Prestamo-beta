package com.example.prestamo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PrestamoAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Prestamo> prestamoList;


    public PrestamoAdapter( Context context, int resource,List objects) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.prestamoList = objects;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View n = inflater.inflate(this.resource,parent,false);

        TextView nombre = n.findViewById(R.id.tvNombre);
        TextView Paga = n.findViewById(R.id.tvMonto);
        TextView plazo = n.findViewById(R.id.tvPlazos);

        nombre.setText(prestamoList.get(position).getNombre());
        Paga.setText(prestamoList.get(position).getPaga());
        plazo.setText(prestamoList.get(position).getPlazo());
        return n;

    }
}
