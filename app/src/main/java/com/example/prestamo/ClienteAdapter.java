
package com.example.prestamo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;

public class ClienteAdapter extends  RecyclerView.Adapter<ClienteAdapter.ClienteHolder>{
    private List<Cliente> clienteList;
    private final OnItemClickListener onItemClickListener;


    public  interface OnItemClickListener
    {
        void onItemClick(int position,long id);
    }
    public ClienteAdapter(List<Cliente> clienteListt, OnItemClickListener onItemClickListener) {

        this.clienteList = clienteListt;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ClienteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view= inflater.inflate(R.layout.itemcliente,viewGroup,false);

        ClienteHolder clienteHolder = new ClienteHolder(view);
        return clienteHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteHolder clienteHolder, int i) {
        clienteHolder.tvNombre.setText(clienteList.get(i).getNombre());
        clienteHolder.tvApellido.setText(clienteList.get(i).getApellido());
    }

    @Override
    public int getItemCount() {
        return clienteList.size();
    }

    public class ClienteHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvNombre;
        public TextView tvApellido;
        public ImageButton  btnborrar;
        public ImageButton btneditar;


        public ClienteHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.tvNombre = itemView.findViewById(R.id.tvNombre);
            this.tvApellido = itemView.findViewById(R.id.tvApellido);
            this.btneditar = itemView.findViewById(R.id.btnedit);
            this.btnborrar = itemView.findViewById(R.id.btnborrar);

            btnborrar.setOnClickListener(this);
            btneditar.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition(),v.getId());
        }
    }
}