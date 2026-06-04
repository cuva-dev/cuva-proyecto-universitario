package com.mycompany.cuvaproject.controller;

import com.mycompany.cuvaproject.data_base.Validation;
import com.mycompany.cuvaproject.data_base.ConnectionMySQL;

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
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
    
    Validation v = new Validation();
    ConnectionMySQL CMySQL = new ConnectionMySQL();
        
    @FXML
    private Button btnIngresar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Se ejecuta al cargar la vista
    }    
    
    
    @FXML
    private TextField id;
    
    @FXML
    private TextField password;
    
    
    private void hundleUser(){
    
        String idValue = id.getText();
        String passwordValue = password.getText();
    
    
        if (idValue.isEmpty() || passwordValue.isEmpty()) {
            throw new IllegalArgumentException("los campos no pueden estar vacios");
        }

        System.out.printf(v.ValidationLogin(CMySQL, idValue, passwordValue)); // esto te debe decir si esta o en la base de datos 
        
    }
    
    @FXML
    private void accionBoton(ActionEvent event) {
        try {
            
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/cuvaproject/Ventana.fxml"));
            Parent root = loader.load();

            Scene currentScene = btnIngresar.getScene();
            currentScene.setRoot(root);
            
        } catch (IOException e) {
            // El método load() obliga a manejar este error por si el archivo no existe
            System.err.println("Error al cargar la siguiente ventana: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
