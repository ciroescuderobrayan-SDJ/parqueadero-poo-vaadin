package com.example.application.parqueo;

public abstract class Vehiculo implements CalculoTarifa {

    protected String placa;
    protected String propietario;
    protected double tarifaPorHora;

    public Vehiculo(String placa, String propietario, double tarifaPorHora) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("La placa no puede estar vacía");
        }

        if (propietario == null || propietario.isBlank()) {
            throw new IllegalArgumentException("El propietario no puede estar vacío");
        }

        if (tarifaPorHora <= 0) {
            throw new IllegalArgumentException("La tarifa por hora debe ser mayor que cero");
        }

        this.placa = placa;
        this.propietario = propietario;
        this.tarifaPorHora = tarifaPorHora;
    }

    public String getPlaca() {
        return placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public abstract String getTipo();

    @Override
    public String getCategoria() {
        return "Parqueadero";
    }

    @Override
    public String getUnidad() {
        return "hora(s)";
    }

    @Override
    public double calcularValor(int horas) {
        if (horas <= 0) {
            throw new IllegalArgumentException("Las horas deben ser mayores que cero");
        }

        return horas * tarifaPorHora;
    }

    @Override
    public String toString() {
        return getTipo();
    }
}