package com.example.application.parqueo;

public class Carro extends Vehiculo {

    public Carro(String placa, String propietario) {
        super(placa, propietario, 5000);
    }

    @Override
    public String getTipo() {
        return "Carro";
    }
}