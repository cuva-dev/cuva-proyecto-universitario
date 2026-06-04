package com.mycompany.cuvaproject.controller;

import java.io.IOException;  
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;

public class LoginController implements Initializable {
    
    @FXML
    private Button btnIngresar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Se ejecuta al cargar la vista
    }    
    
    @FXML
    private void accionBoton(ActionEvent event) {
        try {
            
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/register.fxml"));
            Parent root = loader.load();

            // 3. Obtener el Stage actual
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            //  Cambiamos la ventana
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            // El método load() obliga a manejar este error por si el archivo no existe
            System.err.println("Error al cargar la siguiente ventana: " + e.getMessage());
            e.printStackTrace();
        }
    }
}