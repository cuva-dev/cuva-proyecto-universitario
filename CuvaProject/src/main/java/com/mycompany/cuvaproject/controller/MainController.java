package com.mycompany.cuvaproject.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML; // Importación obligatoria
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController implements Initializable {


    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnRegistrarse; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    

    @FXML
    private void accionBoton(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/cuvaproject/login.fxml"));
            Parent root = loader.load();

 
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            System.err.println("Error al cargar la siguiente ventana: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @FXML
    private void actionRegister(ActionEvent event) {
        try {
          
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/cuvaproject/register.fxml"));
            Parent root = loader.load();


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            System.err.println("Error al cargar la siguiente ventana: " + e.getMessage());
            e.printStackTrace();
        }
    }
}