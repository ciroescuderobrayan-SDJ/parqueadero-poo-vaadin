package com.example.application.parqueo;

public interface CalculoTarifa {

    double calcularValor(int horas);

    String getTipo();

    String getCategoria();

    String getUnidad();
}