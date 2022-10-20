package com.biblioteca.corresponsal.Entidades;

import java.io.Serializable;

public class Depositos implements Serializable {
    private int id;
    private String numero_adepositar;
    private String numero_quedeposita;
    private String monto_deposito;
    private String valor_deposito;

    public Depositos() {
    }

    public Depositos(String numero_adepositar, String numero_quedeposita, String monto_deposito, String valor_deposito) {
        this.numero_adepositar = numero_adepositar;
        this.numero_quedeposita = numero_quedeposita;
        this.monto_deposito = monto_deposito;
        this.valor_deposito = valor_deposito;
    }

    public String getNumero_adepositar() {
        return numero_adepositar;
    }

    public void setNumero_adepositar(String numero_adepositar) {
        this.numero_adepositar = numero_adepositar;
    }

    public String getNumero_quedeposita() {
        return numero_quedeposita;
    }

    public void setNumero_quedeposita(String numero_quedeposita) {
        this.numero_quedeposita = numero_quedeposita;
    }

    public String getMonto_deposito() {
        return monto_deposito;
    }

    public void setMonto_deposito(String monto_deposito) {
        this.monto_deposito = monto_deposito;
    }

    public String getValor_deposito() {
        return valor_deposito;
    }

    public void setValor_deposito(String valor_deposito) {
        this.valor_deposito = valor_deposito;
    }
}
