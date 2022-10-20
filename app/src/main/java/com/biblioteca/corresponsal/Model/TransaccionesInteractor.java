package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Transacciones;

public interface TransaccionesInteractor {
    interface OnTransaccionError{
        void onsucces();
    }
    boolean insert(Transacciones transacciones, OnTransaccionError listener);
}
