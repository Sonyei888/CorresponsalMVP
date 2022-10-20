package com.biblioteca.corresponsal.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.biblioteca.corresponsal.AdminConsultarCedulaClientes;
import com.biblioteca.corresponsal.AdminConsultarCorresponsal;
import com.biblioteca.corresponsal.AdminCrearCliente;
import com.biblioteca.corresponsal.AdminCrearCorresponsal;
import com.biblioteca.corresponsal.AdminFuncionalidades;
import com.biblioteca.corresponsal.AdminListadoClientes;
import com.biblioteca.corresponsal.AdminListadoCorresponsal;
import com.biblioteca.corresponsal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioAdminFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioAdminFragment extends Fragment {

    Context context;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CardView crear_clientes;
    CardView registrar_corresponsal;
    CardView consultar_clientes;
    CardView consultar_corresponsal;
    CardView listado_clientes;
    CardView listado_corresponsal;
    View vista;

    public InicioAdminFragment(Context context) {
        this.context = context;
    }

    public InicioAdminFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioAdminFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioAdminFragment newInstance(String param1, String param2) {
        InicioAdminFragment fragment = new InicioAdminFragment();
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
        vista = inflater.inflate(R.layout.fragment_inicio_admin, container, false);
        crear_clientes = vista.findViewById(R.id.crear_cliente);
        registrar_corresponsal = vista.findViewById(R.id.registrar_corresponsal);
        consultar_clientes = vista.findViewById(R.id.consultar_cliente);
        consultar_corresponsal = vista.findViewById(R.id.consultar_corresponsal);
        listado_clientes = vista.findViewById(R.id.listado_clientes);
        listado_corresponsal = vista.findViewById(R.id.listado_corresponsal);

        crear_clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Creando...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, AdminCrearCliente.class);
                startActivity(intent);
            }
        });
        registrar_corresponsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Registrando...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, AdminCrearCorresponsal.class);
                startActivity(intent);
            }
        });
        consultar_clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Consultando clientes...", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(context, AdminConsultarCedulaClientes.class);
                startActivity(intent1);
            }
        });
        consultar_corresponsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Consultando corresponsal...", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(context, AdminConsultarCorresponsal.class);
                startActivity(intent1);
            }
        });
        listado_clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Listado Clientes...", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(context, AdminListadoClientes.class);
                startActivity(intent2);
            }
        });
        listado_corresponsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Listado Corresponsal...", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(context, AdminListadoCorresponsal.class);
                startActivity(intent3);
            }
        });
        return vista;


    }
}