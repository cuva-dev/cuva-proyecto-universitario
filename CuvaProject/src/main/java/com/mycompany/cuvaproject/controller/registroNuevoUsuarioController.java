/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuvaproject.controller;

import com.mycompany.cuvaproject.services.serviceUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


public class registroNuevoUsuarioController implements Initializable {
    
    
    @FXML
    private ComboBox<String> post;
    
    @FXML
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
    private TextField email;
    

    
    public void  handleUser(){
        
        String nameValue = name.getText();
        String lastNameValue = lastname.getText();
        String usernameValue = username.getText();
        String passwordValue = password.getText();
        String emailValue = email.getText();
        
        String postValue = post.getValue(); 
        
        
        if (postValue == null) {
            System.out.println("Por favor, selecciona un cargo.");
            return;
        }
        
        serviceUser service = new serviceUser();
        service.create(nameValue, lastNameValue, usernameValue, passwordValue, emailValue, postValue);
        
        System.out.println("se creo correctamente el usuario");
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> cargos = FXCollections.observableArrayList(
            "Coordinador", 
            "Gerente" 

        );
        

        post.setItems(cargos);
    }
    
    
}
