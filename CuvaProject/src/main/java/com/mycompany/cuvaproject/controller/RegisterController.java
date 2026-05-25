
package com.mycompany.cuvaproject.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class RegisterController implements Initializable {
    
    private Button btnRegister;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void accionRegister(ActionEvent event) {
        System.out.println("---------------------------------");
        System.out.println("¡El botón funciona correctamente!");
        System.out.println("---------------------------------");
    }
}
