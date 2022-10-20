package com.biblioteca.corresponsal.Entidades;

public class Cuotas {
    private int id;
    private String numero;

    public Cuotas() {
    }

    public Cuotas(String numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
