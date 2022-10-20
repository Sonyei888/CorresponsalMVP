package com.biblioteca.corresponsal.Entidades;

import java.io.Serializable;

public class Retiros implements Serializable {
    private int id;
    private String numero_cedula;
    private String monto_retiro;

    public Retiros() {
    }

    public Retiros(String numero_cedula, String monto_retiro) {
        this.numero_cedula = numero_cedula;
        this.monto_retiro = monto_retiro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_cedula() {
        return numero_cedula;
    }

    public void setNumero_cedula(String numero_cedula) {
        this.numero_cedula = numero_cedula;
    }

    public String getMonto_retiro() {
        return monto_retiro;
    }

    public void setMonto_retiro(String monto_retiro) {
        this.monto_retiro = monto_retiro;
    }
}
