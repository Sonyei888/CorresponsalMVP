package com.biblioteca.corresponsal.Entidades;

public class Transacciones {
    private int id;
    private String fecha;
    private String tipo_transaccion;
    private String monto_trasaccion;
    private String numero_tarjeta;
    private String numero_cedula;
    private String valor;

    public Transacciones() {
    }

    public Transacciones(String fecha, String tipo_transaccion, String monto_trasaccion, String numero_tarjeta, String numero_cedula, String valor) {
        this.fecha = fecha;
        this.tipo_transaccion = tipo_transaccion;
        this.monto_trasaccion = monto_trasaccion;
        this.numero_tarjeta = numero_tarjeta;
        this.numero_cedula = numero_cedula;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public String getMonto_trasaccion() {
        return monto_trasaccion;
    }

    public void setMonto_trasaccion(String monto_trasaccion) {
        this.monto_trasaccion = monto_trasaccion;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getNumero_cedula() {
        return numero_cedula;
    }

    public void setNumero_cedula(String numero_cedula) {
        this.numero_cedula = numero_cedula;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
