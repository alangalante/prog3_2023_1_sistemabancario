package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.diversos.DiversosJavaFx;
import br.edu.femass.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ClienteController implements Initializable {

    @FXML
    private TextField TxtId;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtCpf;

    @FXML
    private TextField TxtEndereco;

    @FXML
    private TextField TxtEmail;

    @FXML
    private TextField TxtTelefone;

    @FXML
    private ListView<Cliente> listaCliente;

    @FXML
    private void BtnNovo_Click(ActionEvent event) {
        System.out.println("Novo!");

    }

    @FXML
    private void BtnExcluir_Click(ActionEvent event) {
        System.out.println("Excluir!");

    }

    @FXML
    private void BtnGravar_Click(ActionEvent event) {
        try {
            Cliente cliente = new Cliente(
                    TxtCpf.getText(),
                    TxtNome.getText(),
                    TxtTelefone.getText());
            cliente.setEmail(TxtEmail.getText());
            cliente.setEndereco(TxtEndereco.getText());

            TxtId.setText(cliente.getId().toString());
        } catch (IllegalArgumentException e) {
            DiversosJavaFx.exibirMensagem(e.getMessage());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
