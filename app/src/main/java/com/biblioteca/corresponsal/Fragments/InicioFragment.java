package com.biblioteca.corresponsal.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.biblioteca.corresponsal.AdminListadoClientes;
import com.biblioteca.corresponsal.CorresConusltaSaldo;
import com.biblioteca.corresponsal.CorresDepositos;
import com.biblioteca.corresponsal.CorresHistorialTransacciones;
import com.biblioteca.corresponsal.CorresPagoTarjeta;
import com.biblioteca.corresponsal.CorresRetiros;
import com.biblioteca.corresponsal.CorresTransferencia;
import com.biblioteca.corresponsal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class InicioFragment extends Fragment {

    Context context;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    CardView pago_tarjeta;
    CardView retiros;
    CardView depositos;
    CardView transferencias;
    CardView historial;
    CardView consulta;
    View vista;
    Activity actividad;


    public InicioFragment(Context context) {
        this.context = context;
    }
    public InicioFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_inicio, container, false);

        pago_tarjeta = vista.findViewById(R.id.pago_tarjeta);
        retiros = vista.findViewById(R.id.Retiros);
        depositos = vista.findViewById(R.id.depositos);
        transferencias = vista.findViewById(R.id.transferencias);
        historial = vista.findViewById(R.id.historial);
        consulta = vista.findViewById(R.id.consulta);

        pago_tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Tarjeta...", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(context, CorresPagoTarjeta.class);
                startActivity(intent2);
            }
        });
        retiros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Retiros...", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(context, CorresRetiros.class);
                startActivity(intent2);
            }
        });
        depositos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Deposito...", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(context, CorresDepositos.class);
                startActivity(intent2);
            }
        });
        transferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Transferencia...", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(context, CorresTransferencia.class);
                startActivity(intent2);
            }
        });
        historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Historial...", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(context, CorresHistorialTransacciones.class);
                startActivity(intent2);
            }
        });
        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Consultando...", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(context, CorresConusltaSaldo.class);
                startActivity(intent2);
            }
        });

        return vista;
    }
}