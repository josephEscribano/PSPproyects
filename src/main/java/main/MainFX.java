package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("/fxml/PrimeraInterfaz.fxml"));
        AnchorPane root = loaderMenu.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Primera App Joseph Escribano");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);


    }
}
