package com.example.application.parqueo;

public class Moto extends Vehiculo {

    public Moto(String placa, String propietario) {
        super(placa, propietario, 3000);
    }

    @Override
    public String getTipo() {
        return "Moto";
    }
}