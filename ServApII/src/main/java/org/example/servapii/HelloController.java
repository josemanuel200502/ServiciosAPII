package org.example.servapii;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtDestinatario;

    @FXML
    private TextField txtAsunto;

    @FXML
    private TextArea txtCuerpo;

    @FXML
    private void enviarCorreo() {
        String destinatario = txtDestinatario.getText();
        String asunto = txtAsunto.getText();
        String cuerpo = txtCuerpo.getText();

        if (destinatario.isEmpty() || asunto.isEmpty() || cuerpo.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.", Alert.AlertType.ERROR);
            return;
        }

        try {
            ClienteSMTP.enviarCorreo(destinatario, asunto, cuerpo);
            mostrarAlerta("Éxito", "Correo enviado correctamente.", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo enviar el correo: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
