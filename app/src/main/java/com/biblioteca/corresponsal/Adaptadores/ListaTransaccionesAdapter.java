package com.biblioteca.corresponsal.Adaptadores;

import static android.os.Build.VERSION_CODES.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.biblioteca.corresponsal.Entidades.Transacciones;
import com.biblioteca.corresponsal.R;

import java.util.ArrayList;

public class ListaTransaccionesAdapter extends RecyclerView.Adapter<ListaTransaccionesAdapter.TransaccionesViewHolder> {
    ArrayList<Transacciones> listatransacciones;

    public ListaTransaccionesAdapter(ArrayList<Transacciones> listatransacciones) {
        this.listatransacciones = listatransacciones;
    }

    @NonNull
    @Override
    public TransaccionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.biblioteca.corresponsal.R.layout.lista_item_transacciones, null, false);
        return new TransaccionesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransaccionesViewHolder holder, int position) {
        holder.view_id_consecutivo.setText(Integer.toString(listatransacciones.get(position).getId()));
        holder.view_fecha.setText(listatransacciones.get(position).getFecha());
        holder.view_tipo_transaccion.setText(listatransacciones.get(position).getTipo_transaccion());
        holder.view_monto_transaccion.setText(listatransacciones.get(position).getMonto_trasaccion());
        holder.view_numero_transaccion.setText(listatransacciones.get(position).getNumero_cedula());
    }

    @Override
    public int getItemCount() {
        return listatransacciones.size();
    }

    public class TransaccionesViewHolder extends RecyclerView.ViewHolder {
        TextView view_id_consecutivo;
        TextView view_fecha;
        TextView view_tipo_transaccion;
        TextView view_monto_transaccion;
        TextView view_numero_transaccion;
        public TransaccionesViewHolder(@NonNull View itemView) {
            super(itemView);
            view_id_consecutivo = itemView.findViewById(com.biblioteca.corresponsal.R.id.id_consecutivo);
            view_fecha = itemView.findViewById(com.biblioteca.corresponsal.R.id.fecha_hora);
            view_tipo_transaccion = itemView.findViewById(com.biblioteca.corresponsal.R.id.tipo_transaccion);
            view_monto_transaccion = itemView.findViewById(com.biblioteca.corresponsal.R.id.monto_transaccion);
            view_numero_transaccion = itemView.findViewById(com.biblioteca.corresponsal.R.id.numero_cedula_cuenta);
        }
    }
}
