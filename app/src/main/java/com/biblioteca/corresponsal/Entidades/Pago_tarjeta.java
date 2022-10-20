package com.biblioteca.corresponsal.Entidades;

import java.io.Serializable;

public class Pago_tarjeta implements Serializable {
    private int id_pago;
    private String numero_tarjeta;
    private String fecha_mes;
    private String fecha_dia;
    private String nombre_cliente;
    private String cuotas;
    private String valor_pago;

    public Pago_tarjeta() {
    }

    public Pago_tarjeta(String numero_tarjeta, String fecha_mes, String fecha_dia, String nombre_cliente, String cuotas, String valor_pago) {
        this.numero_tarjeta = numero_tarjeta;
        this.fecha_mes = fecha_mes;
        this.fecha_dia = fecha_dia;
        this.nombre_cliente = nombre_cliente;
        this.cuotas = cuotas;
        this.valor_pago = valor_pago;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getFecha_mes() {
        return fecha_mes;
    }

    public void setFecha_mes(String fecha_mes) {
        this.fecha_mes = fecha_mes;
    }

    public String getFecha_dia() {
        return fecha_dia;
    }

    public void setFecha_dia(String fecha_dia) {
        this.fecha_dia = fecha_dia;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getCuotas() {
        return cuotas;
    }

    public void setCuotas(String cuotas) {
        this.cuotas = cuotas;
    }

    public String getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(String valor_pago) {
        this.valor_pago = valor_pago;
    }
}
