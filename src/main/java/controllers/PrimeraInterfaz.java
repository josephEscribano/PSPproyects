package controllers;

import DAO.DAOpersonas;
import Modelos.Personas;
import Servicios.personas.ServicioAddPersonas;
import Servicios.personas.ServiciosUpdatePersonas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PrimeraInterfaz implements Initializable {
    private Alert alert;
    @FXML
    private Button Moverder;
    @FXML
    private Button Moverizq;

    @FXML
    private ComboBox<String> CBsexo;
    @FXML
    private DatePicker DPfecharegistro;
    @FXML
    private TextField tfEdad;
    @FXML
    private TextField tfnombre;
    @FXML
    private RadioButton RBmujer;
    @FXML
    private ListView<Personas> lvlista;
    @FXML
    private ListView<Personas> lvlista1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        CBsexo.getItems().add("Hombre");
        CBsexo.getItems().add("Mujer");
    }


    public void AñadirDatos(ActionEvent actionEvent) {
        Personas persona = new Personas();
        ServicioAddPersonas add = new ServicioAddPersonas();
        try{
            persona.setNombre(tfnombre.getText());
            persona.setEdad(Integer.parseInt(tfEdad.getText()));
            persona.setSexo(RBmujer.isSelected());
            persona.setFechaRegistro(DPfecharegistro.getValue());
            if (add.addperson(persona)){
                lvlista.getItems().add(persona);
                alert.setContentText("La persona ha sido añadida");
            }else{
                alert.setContentText("La persona no ha sido añadida");
            }
        }catch (Exception e){
            alert.setContentText("Ha ocurrido un error");
        }
        alert.showAndWait();
    }


    public void BorrarPersona(ActionEvent actionEvent) {
        if (lvlista.getItems().remove(lvlista.getSelectionModel().getSelectedItem()) || lvlista1.getItems().remove(lvlista1.getSelectionModel().getSelectedItem())){
            alert.setContentText("Persona Borrada");
        }else{
            alert.setContentText("Persona no borrada");
        }

        alert.showAndWait();
    }


    public void mover(ActionEvent actionEvent) {
        if (Moverder.isArmed()){
            if (lvlista.getSelectionModel().getSelectedItem() != null){
                lvlista1.getItems().add(lvlista.getSelectionModel().getSelectedItem());
                lvlista.getItems().remove(lvlista.getSelectionModel().getSelectedItem());
            }else{
                alert.setContentText("Tienes que seleccionar un objeto");
                alert.showAndWait();
            }

        }else if (Moverizq.isArmed()){
            if (lvlista1.getSelectionModel().getSelectedItem() != null){
                lvlista.getItems().add(lvlista1.getSelectionModel().getSelectedItem());
                lvlista1.getItems().remove(lvlista1.getSelectionModel().getSelectedItem());
            }else{
                alert.setContentText("Tienes que seleccionar un objeto");
                alert.showAndWait();
            }
        }
    }

    public void updatedata(ActionEvent actionEvent) {
        Personas p = lvlista.getSelectionModel().getSelectedItem();
        ServiciosUpdatePersonas actualizar = new ServiciosUpdatePersonas();
        //Guardo la posicion del objeto para luego actualizar la lista.
        int posicion = lvlista.getItems().indexOf(p);
        if (p != null){
            try{
                p.setNombre(tfnombre.getText());
                p.setEdad(Integer.parseInt(tfEdad.getText()));
                p.setSexo(RBmujer.isSelected());
                p.setFechaRegistro(DPfecharegistro.getValue());

                if (actualizar.updateperson(p)){
                    lvlista.getItems().set(posicion,p);
                    alert.setContentText("La persona ha sido actualizada correctamente");
                }else{
                    alert.setContentText("La persona no ha podido actualizarse");
                }

            }catch (Exception e){
                alert.setContentText("Ha ocurrido un error");
            }
        }else{
            alert.setContentText("La persona seleccionada no es valida");
        }
        alert.showAndWait();
    }

    public void filtro(ActionEvent actionEvent) {
        DAOpersonas dao = new DAOpersonas();
        List<Personas> lista = dao.getListapersonas();
        lvlista.getItems().clear();
        lvlista.getItems().addAll(lista);
        if (CBsexo.getSelectionModel().getSelectedItem().equals("Hombre")){
            lvlista.getItems().removeIf(Personas::isSexo);

        }else{
            lvlista.getItems().removeIf(personas -> !personas.isSexo());
        }

    }
}
