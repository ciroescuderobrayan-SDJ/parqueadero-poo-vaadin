package com.example.application.parqueo;

import java.util.ArrayList;
import java.util.List;

public class CatalogoVehiculos {

    public List<String> obtenerTiposVehiculo() {
        List<String> tipos = new ArrayList<>();
        tipos.add("Carro");
        tipos.add("Moto");
        tipos.add("Camioneta");
        return tipos;
    }

    public Vehiculo crearVehiculo(String tipo, String placa, String propietario) {
        switch (tipo) {
            case "Carro":
                return new Carro(placa, propietario);
            case "Moto":
                return new Moto(placa, propietario);
            case "Camioneta":
                return new Camioneta(placa, propietario);
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido");
        }
    }
}