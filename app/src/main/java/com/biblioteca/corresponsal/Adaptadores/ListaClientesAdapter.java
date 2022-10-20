package com.biblioteca.corresponsal.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.biblioteca.corresponsal.AdminConsultarClientes;
import com.biblioteca.corresponsal.AdminConsultarHabilitarCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaClientesAdapter extends RecyclerView.Adapter<ListaClientesAdapter.ClientesViewHolder> {
    ArrayList<Clientes> listaclientes;
    ArrayList<Clientes> listaoriginal;

    public ListaClientesAdapter(ArrayList<Clientes> listaclientes) {
        this.listaclientes = listaclientes;
        listaoriginal = new ArrayList<>();
        listaoriginal.addAll(listaclientes);
    }

    @NonNull
    @Override
    public ClientesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_clientes, null, false);
        return  new ClientesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientesViewHolder holder, int position) {
        holder.view_nombre_cliente.setText(listaclientes.get(position).getNombre());
        holder.view_cuenta_cliente.setText(listaclientes.get(position).getCuenta());
        holder.view_cedula_cliente.setText(listaclientes.get(position).getCedula());
        holder.view_saldo_cliente.setText(listaclientes.get(position).getSaldo());
    }
    public void filtrado(String txtbuscar){
        int longitud = txtbuscar.length();
        if( longitud ==0){
            listaclientes.clear();
            listaclientes.addAll(listaoriginal);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Clientes> collecion = listaclientes.stream().filter(i -> i.getCedula().toLowerCase().contains(txtbuscar.toLowerCase())).collect(Collectors.toList());

                listaclientes.clear();
                listaclientes.addAll(collecion);
            }else{
                for(Clientes c: listaoriginal){
                    if (c.getCedula().toLowerCase().contains(txtbuscar.toLowerCase())){
                        listaclientes.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaclientes.size();
    }

    public class ClientesViewHolder extends RecyclerView.ViewHolder {
        TextView view_nombre_cliente;
        TextView view_cuenta_cliente;
        TextView view_cedula_cliente;
        TextView view_saldo_cliente;
        public ClientesViewHolder(@NonNull View itemView) {
            super(itemView);
            view_nombre_cliente = itemView.findViewById(R.id.nombre_cliente_lista);
            view_cuenta_cliente = itemView.findViewById(R.id.cuenta_cliente_lista);
            view_cedula_cliente = itemView.findViewById(R.id.cedula_cliente_lista);
            view_saldo_cliente = itemView.findViewById(R.id.saldo_cliente_lista);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, AdminConsultarClientes.class);
                    intent.putExtra("llave4", listaclientes.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
