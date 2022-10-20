package com.biblioteca.corresponsal.Entidades;

import java.io.Serializable;

public class Transferencias implements Serializable{
    private int id;
    private String numero_atransferir;
    private String numero_quetransfiere;
    private String monto_transferir;

    public Transferencias() {
    }

    public Transferencias(String numero_atransferir, String numero_quetransfiere, String monto_transferir) {
        this.numero_atransferir = numero_atransferir;
        this.numero_quetransfiere = numero_quetransfiere;
        this.monto_transferir = monto_transferir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_atransferir() {
        return numero_atransferir;
    }

    public void setNumero_atransferir(String numero_atransferir) {
        this.numero_atransferir = numero_atransferir;
    }

    public String getNumero_quetransfiere() {
        return numero_quetransfiere;
    }

    public void setNumero_quetransfiere(String numero_quetransfiere) {
        this.numero_quetransfiere = numero_quetransfiere;
    }

    public String getMonto_transferir() {
        return monto_transferir;
    }

    public void setMonto_transferir(String monto_transferir) {
        this.monto_transferir = monto_transferir;
    }
}
