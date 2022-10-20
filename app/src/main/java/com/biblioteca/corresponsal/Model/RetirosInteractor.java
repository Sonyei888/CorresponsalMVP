package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public interface RetirosInteractor {
    interface RetiroError{
        void onSucess();
    }
    Clientes verdatos(String cedula, RetiroError listener);
    boolean editarsaldo(Corresponsal corresponsal, RetiroError listener);
    boolean editar(String monto, Clientes clientes, RetiroError listener);
}
