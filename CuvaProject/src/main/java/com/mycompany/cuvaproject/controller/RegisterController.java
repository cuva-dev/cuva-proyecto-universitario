 package com.mycompany.cuvaproject.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException; 


import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader; 
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane; 
import com.mycompany.cuvaproject.services.serviceUser;

public class RegisterController implements Initializable {
    
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnRegresar;
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField lastname;
    
    @FXML
    private TextField id;
    
    @FXML
    private TextField password;
    
    @FXML
    private TextField password_two;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField post;
    
    @FXML
    private void handleUser(ActionEvent event) {

        String nameValue = name.getText();
        String lastNameValue = lastname.getText();
        String idValue = id.getText();
        String passwordValue = password.getText();
        String passwordTwoValue = password_two.getText();
        String emailValue = email.getText();
        String postValue = post.getText();
        
        if (!passwordValue.equals(passwordTwoValue)) {
            throw new IllegalArgumentException("Las contraseñas no coinciden");
        }

        // Creación del usuario
        serviceUser service = new serviceUser();
        service.create(nameValue, lastNameValue, idValue, passwordValue, emailValue, postValue);
        
        System.out.println("[Registro] Usuario creado con éxito. Redirigiendo...");

        
        try {
            System.out.println(" Redirigiendo a prueba.fxml...");
    
   
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/cuvaproject/Ventana.fxml"));
            Parent viewPrueba = loader.load();
    
            Scene currentScene = btnRegister.getScene();
    

            currentScene.setRoot(viewPrueba);
    
            System.out.println("[Registro] ¡Redirección completada con éxito!");

}       catch (IOException e) {
            System.err.println("[Error] No se pudo cargar la vista prueba.fxml. Verifica la ruta.");
            e.printStackTrace();
        }
    }
    
    @FXML
    private void accionRegresar(ActionEvent event){
        
        try{
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/cuvaproject/main.fxml"));
            Parent root = loader.load();
            
            Scene currentScene = btnRegresar.getScene();
            currentScene.setRoot(root);
            
        
        }catch(IOException e){
            
            System.err.println("Error al cargar la siguiente ventana: " + e.getMessage());
            e.printStackTrace();
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}