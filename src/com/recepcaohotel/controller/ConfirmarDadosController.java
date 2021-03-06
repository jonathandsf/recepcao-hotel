package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.app.App;
import com.recepcaohotel.controller.context.ReservationContext;
import com.recepcaohotel.model.Cliente;
import com.recepcaohotel.model.Quarto;
import com.recepcaohotel.model.Reserva;
import com.recepcaohotel.model.Sistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConfirmarDadosController {
    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoTelefone;

    @FXML
    private Label numeroQuarto;

    @FXML
    private Label precoEstadia;

    @FXML
    private Label dataEntrada;

    @FXML
    private Label dataSaida;

    @FXML
    private Label numeroCamasDeCasal;

    @FXML
    private Label numeroCamasDeSolteiro;

    @FXML
    Button botaoConfirmarReserva;

    @FXML
    Button botaoVoltar;

    @FXML
    private void initialize() {
        // Atualizar os campos pelo contexto de Reserva
        ReservationContext ctx = ReservationContext.getInstance();
        Quarto quarto = ctx.getQuartoSelecionado();
        if (quarto == null) {
            return;
        }
        numeroQuarto.setText("Quarto " + String.format("%03d", quarto.getNumero()));
        precoEstadia.setText("R$" + String.format("%.2f", quarto.getDiaria()).replace(".", ","));
        dataEntrada.setText("Data de Entrada: " + String.format("%02d", ctx.getDataEntrada().getDayOfMonth()) + "/"
                + String.format("%02d", ctx.getDataEntrada().getMonthValue()) + "/" + ctx.getDataEntrada().getYear());
        dataSaida.setText("Data de Saída: " + String.format("%02d", ctx.getDataSaida().getDayOfMonth()) + "/"
                + String.format("%02d", ctx.getDataSaida().getMonthValue()) + "/" + ctx.getDataSaida().getYear());
        numeroCamasDeCasal.setText("Camas de Casal: " + String.format("%02d", quarto.getQntdCamasCasal()));
        numeroCamasDeSolteiro.setText("Camas de Solteiro: " + String.format("%02d", quarto.getQntdCamasSolteiro()));
    }

    @FXML
    private void confirmarReserva(ActionEvent event) {
        // Recuperar os valores dos campos.
        String nome = campoNome.getText().trim();
        String email = campoEmail.getText().trim();
        String telefone = campoTelefone.getText().trim();
        // Verificar se os campos são válidos (não estão em branco).
        if (nome.isBlank()) {
            mostrarErroCampos();
            return;
        }
        if (email.isBlank()) {
            mostrarErroCampos();
            return;
        }
        if (telefone.isBlank()) {
            mostrarErroCampos();
            return;
        }
        ReservationContext ctx = ReservationContext.getInstance();
        // Quardar dados dos campos no contexo.
        ctx.setNome(nome);
        ctx.setEmail(email);
        ctx.setTelefone(telefone);
        // Criar objeto do cliente.
        Cliente cliente = new Cliente(nome, email, telefone);
        // Criar a reserva, guardar informações no contexto.
        Reserva reserva = new Reserva(ctx.getQuartoSelecionado(), cliente, ctx.getDataEntrada(), ctx.getDataSaida());
        // Guardar a reserva no contexto.
        ctx.setReservaCriada(reserva);
        // Cadastrar a reserva.
        Sistema s = App.getSystemInstance();
        s.cadastrarReserva(reserva);
        // Mudar para a página final.
        if (event.getSource() == botaoConfirmarReserva) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ReservaConcluida.fxml"));
                botaoConfirmarReserva.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void voltar(ActionEvent event) {
        if (event.getSource() == botaoVoltar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/BuscaQuartos.fxml"));
                botaoVoltar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void mostrarErroCampos() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro de campos");
        alert.setContentText("Os campos não podem ser vazios.");
        alert.showAndWait();
    }
}
