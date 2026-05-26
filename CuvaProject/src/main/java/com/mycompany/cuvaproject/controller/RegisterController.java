
package com.mycompany.cuvaproject.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.mycompany.cuvaproject.services.serviceUser;


public class RegisterController implements Initializable {
    
    private Button btnRegister;
    
    
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField lastname;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private TextField password_two;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField post;
    
    
    @FXML
    private void handleUser() {

        String nameValue = name.getText();
        String lastNameValue = lastname.getText();
        String usernameValue = username.getText();
        String passwordValue = password.getText();
        String passwordTwoValue = password_two.getText();
        String emailValue = email.getText();
        String postValue = post.getText();
        
        if (!passwordValue.equals(passwordTwoValue)) {
        throw new IllegalArgumentException("Las contraseñas no coinciden");
        }

        serviceUser service = new serviceUser();
        service.create(nameValue, lastNameValue, usernameValue, passwordValue, emailValue, postValue);
    }
    
    
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
