package com.biblioteca.corresponsal.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.biblioteca.corresponsal.AdminConsultarHabilitarCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaCorresponsalAdapter extends RecyclerView.Adapter<ListaCorresponsalAdapter.CorresponsalVieeHolder> {
    ArrayList<Corresponsal> listacorresponsal;
    ArrayList<Corresponsal> listaoriginal;
    public ListaCorresponsalAdapter(ArrayList<Corresponsal> listacorresponsal) {
        this.listacorresponsal = listacorresponsal;
        listaoriginal = new ArrayList<>();
        listaoriginal.addAll(listacorresponsal);
    }

    @NonNull
    @Override
    public CorresponsalVieeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_corresponsal, null, false);
        return new CorresponsalVieeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CorresponsalVieeHolder holder, int position) {
        holder.view_nombre_corresponsal.setText(listacorresponsal.get(position).getNombre_corresponsal());
        holder.view_cuenta_corresponsal.setText(listacorresponsal.get(position).getCuenta_corresponsal());
        holder.view_nit_corresponsal.setText(listacorresponsal.get(position).getNit_corresponsal());
        holder.view_estado_corresponsal.setText(listacorresponsal.get(position).getEstado_corresponsal());
        holder.view_saldo_corresponsal.setText(listacorresponsal.get(position).getSaldo_corresponsal());
    }
    public void filtrado(String txtbuscar){
        int longitud = txtbuscar.length();
        if( longitud ==0){
            listacorresponsal.clear();
            listacorresponsal.addAll(listaoriginal);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Corresponsal> collecion = listacorresponsal.stream().filter(i -> i.getNit_corresponsal().toLowerCase().contains(txtbuscar.toLowerCase())).collect(Collectors.toList());

                listacorresponsal.clear();
                listacorresponsal.addAll(collecion);
            }else{
                for(Corresponsal c: listaoriginal){
                    if (c.getNit_corresponsal().toLowerCase().contains(txtbuscar.toLowerCase())){
                        listacorresponsal.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listacorresponsal.size();
    }

    public class CorresponsalVieeHolder extends RecyclerView.ViewHolder {
        TextView view_nombre_corresponsal;
        TextView view_cuenta_corresponsal;
        TextView view_nit_corresponsal;
        TextView view_estado_corresponsal;
        TextView view_saldo_corresponsal;
        public CorresponsalVieeHolder(@NonNull View itemView) {
            super(itemView);
            view_nombre_corresponsal = itemView.findViewById(R.id.nombre_corresponsal_lista);
            view_cuenta_corresponsal = itemView.findViewById(R.id.cuenta_corresponsal_lista);
            view_nit_corresponsal = itemView.findViewById(R.id.nit_corresponsal_lista);
            view_estado_corresponsal = itemView.findViewById(R.id.estado_corresponsal_lista);
            view_saldo_corresponsal = itemView.findViewById(R.id.saldo_cliente_lista);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, AdminConsultarHabilitarCorresponsal.class);
                    intent.putExtra("llave7", listacorresponsal.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
