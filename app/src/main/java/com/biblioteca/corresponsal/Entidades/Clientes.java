package com.biblioteca.corresponsal.Entidades;

import java.io.Serializable;

public class Clientes implements Serializable {
    private int id;
    private String nombre;
    private String cedula;
    private String saldo;
    private String pin;
    private String cuenta;

    public Clientes() {
    }

    public Clientes(String nombre, String cedula, String saldo, String pin, String cuenta) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.saldo = saldo;
        this.pin = pin;
        this.cuenta = cuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
}
