package com.javasharks.microservicios.entity;

public enum TIPO_TRANSACCION {
    TRANSFERENCIA("Transferencia", "Transferencia entre cuentas"),
    ECHEQ("Echeq", "Pago por cheque electrónico"),
    PAGO_TARJETA("Pago con tarjeta", "Pago mediante tarjeta"),
    ENVIO_DINERO("Envío de dinero", "Envío de dinero a otra cuenta");

    private final String nombreTipo;
    private final String descripcion;


    TIPO_TRANSACCION(String nombreTipo, String descripcion) {
        this.nombreTipo = nombreTipo;
        this.descripcion = descripcion;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
