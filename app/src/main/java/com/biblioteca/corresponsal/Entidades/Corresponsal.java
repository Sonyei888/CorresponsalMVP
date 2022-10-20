package com.biblioteca.corresponsal.Entidades;

import java.io.Serializable;

public class Corresponsal implements Serializable {
    private int id_corresponsal;
    private String nombre_corresponsal;
    private String nit_corresponsal;
    private String correo_corresponsal;
    private String contraseña_corresponsal;
    private String saldo_corresponsal;
    private String cuenta_corresponsal;
    private String estado_corresponsal;

    public Corresponsal() {
    }

    public Corresponsal(String nombre_corresponsal, String nit_corresponsal, String correo_corresponsal, String contraseña_corresponsal, String saldo_corresponsal, String cuenta_corresponsal, String estado_corresponsal) {
        this.nombre_corresponsal = nombre_corresponsal;
        this.nit_corresponsal = nit_corresponsal;
        this.correo_corresponsal = correo_corresponsal;
        this.contraseña_corresponsal = contraseña_corresponsal;
        this.saldo_corresponsal = saldo_corresponsal;
        this.cuenta_corresponsal = cuenta_corresponsal;
        this.estado_corresponsal = estado_corresponsal;
    }

    public int getId_corresponsal() {
        return id_corresponsal;
    }

    public void setId_corresponsal(int id_corresponsal) {
        this.id_corresponsal = id_corresponsal;
    }

    public String getNombre_corresponsal() {
        return nombre_corresponsal;
    }

    public void setNombre_corresponsal(String nombre_corresponsal) {
        this.nombre_corresponsal = nombre_corresponsal;
    }

    public String getNit_corresponsal() {
        return nit_corresponsal;
    }

    public void setNit_corresponsal(String nit_corresponsal) {
        this.nit_corresponsal = nit_corresponsal;
    }

    public String getCorreo_corresponsal() {
        return correo_corresponsal;
    }

    public void setCorreo_corresponsal(String correo_corresponsal) {
        this.correo_corresponsal = correo_corresponsal;
    }

    public String getContraseña_corresponsal() {
        return contraseña_corresponsal;
    }

    public void setContraseña_corresponsal(String contraseña_corresponsal) {
        this.contraseña_corresponsal = contraseña_corresponsal;
    }

    public String getSaldo_corresponsal() {
        return saldo_corresponsal;
    }

    public void setSaldo_corresponsal(String saldo_corresponsal) {
        this.saldo_corresponsal = saldo_corresponsal;
    }

    public String getCuenta_corresponsal() {
        return cuenta_corresponsal;
    }

    public void setCuenta_corresponsal(String cuenta_corresponsal) {
        this.cuenta_corresponsal = cuenta_corresponsal;
    }

    public String getEstado_corresponsal() {
        return estado_corresponsal;
    }

    public void setEstado_corresponsal(String estado_corresponsal) {
        this.estado_corresponsal = estado_corresponsal;
    }
}
