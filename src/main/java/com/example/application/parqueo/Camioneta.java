package com.example.application.parqueo;

public class Camioneta extends Vehiculo {

    public Camioneta(String placa, String propietario) {
        super(placa, propietario, 7000);
    }

    @Override
    public String getTipo() {
        return "Camioneta";
    }
}