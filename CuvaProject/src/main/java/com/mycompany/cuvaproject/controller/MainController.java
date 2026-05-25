
package com.mycompany.cuvaproject.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainController implements Initializable {

    private Button btnIngresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    private void accionBoton(ActionEvent event) {
        try {
            
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../com/mycompany/cuvaproject/login.fxml"));
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
