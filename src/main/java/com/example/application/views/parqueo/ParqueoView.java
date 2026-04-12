package com.example.application.views.parqueo;

import com.example.application.parqueo.CatalogoVehiculos;
import com.example.application.parqueo.Vehiculo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("Parqueadero")
public class ParqueoView extends VerticalLayout {

    public ParqueoView() {
        CatalogoVehiculos catalogo = new CatalogoVehiculos();

        H2 titulo = new H2("Sistema de Parqueadero");

        ComboBox<String> comboTipo = new ComboBox<>("Tipo de vehículo");
        comboTipo.setItems(catalogo.obtenerTiposVehiculo());
        comboTipo.setPlaceholder("Seleccione un tipo");

        TextField txtPlaca = new TextField("Placa");
        txtPlaca.setPlaceholder("Ej: ABC123");

        TextField txtPropietario = new TextField("Propietario");
        txtPropietario.setPlaceholder("Ej: Karen");

        IntegerField txtHoras = new IntegerField("Horas estacionado");
        txtHoras.setMin(1);
        txtHoras.setStepButtonsVisible(true);

        Button btnCalcular = new Button("Calcular");

        Paragraph resultado = new Paragraph("Aquí aparecerá el resultado");

        btnCalcular.addClickListener(event -> {
            try {
                String tipo = comboTipo.getValue();
                String placa = txtPlaca.getValue();
                String propietario = txtPropietario.getValue();
                Integer horas = txtHoras.getValue();

                if (tipo == null || tipo.isBlank()) {
                    Notification.show("Debes seleccionar un tipo de vehículo");
                    return;
                }

                if (placa == null || placa.isBlank()) {
                    Notification.show("Debes ingresar la placa");
                    return;
                }

                if (propietario == null || propietario.isBlank()) {
                    Notification.show("Debes ingresar el propietario");
                    return;
                }

                if (horas == null || horas <= 0) {
                    Notification.show("Debes ingresar una cantidad válida de horas");
                    return;
                }

                Vehiculo vehiculo = catalogo.crearVehiculo(tipo, placa, propietario);
                double total = vehiculo.calcularValor(horas);

                resultado.setText(
                        "Vehículo: " + vehiculo.getTipo()
                                + " | Placa: " + vehiculo.getPlaca()
                                + " | Propietario: " + vehiculo.getPropietario()
                                + " | Horas: " + horas
                                + " | Total a pagar: $" + total
                );

            } catch (IllegalArgumentException e) {
                Notification.show(e.getMessage());
            } catch (Exception e) {
                Notification.show("Ocurrió un error al calcular");
            }
        });

        setSpacing(true);
        setPadding(true);

        add(titulo, comboTipo, txtPlaca, txtPropietario, txtHoras, btnCalcular, resultado);
    }
}