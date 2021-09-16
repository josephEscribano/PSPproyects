package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Nuevo implements Initializable {

    @FXML
    private Button borrar;
    @FXML
    private TextField campo;
    @FXML
    private ListView<String> lista;
    @FXML
    private Button añadir;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void clickboton(ActionEvent actionEvent) {
        lista.getItems().add(campo.getText());
    }

    public void delclick(ActionEvent actionEvent) {
        lista.getItems().remove(lista.getSelectionModel().getSelectedItem());
    }


}
