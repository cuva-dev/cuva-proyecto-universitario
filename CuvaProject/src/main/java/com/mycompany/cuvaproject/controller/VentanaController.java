package com.mycompany.cuvaproject.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage; 

public class VentanaController implements Initializable {
    
    @FXML
    private BorderPane mainContainer; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        changeView("/com/mycompany/cuvaproject/estudiantes.fxml"); 
    }
    
    @FXML
    private void showStudients(ActionEvent event) {
        changeView("/com/mycompany/cuvaproject/estudiantes.fxml");
    }
    
    @FXML
    private void showBinnacle(ActionEvent event) {
        changeView("/com/mycompany/cuvaproject/Bitacora.fxml");
    }
    
    @FXML
    private void closeSesion(ActionEvent event) {
        try {
            System.out.println("[Navbar] Cerrando sesión por completo...");
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/cuvaproject/main.fxml"));
            Parent mainView = loader.load();
            
            
            Stage currentStage = (Stage) mainContainer.getScene().getWindow();
            
            
            Scene newScene = new Scene(mainView);
            
            
            currentStage.setScene(newScene);
            currentStage.centerOnScreen(); 
            
            System.out.println("[Navbar] Sesión cerrada con éxito y menú destruido.");
            
        } catch (IOException e) {
            System.err.println("[Error] No se pudo cargar el archivo main.fxml al cerrar sesión.");
            e.printStackTrace();
        }
    }


  
    private void changeView(String fxmlPath) {
        try {
            System.out.println("[Navbar] Intentando cambiar vista interna a: " + fxmlPath);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent subView = loader.load();
            

            mainContainer.setCenter(subView);
            
            System.out.println("[Navbar] ¡Vista interna cambiada con éxito!");
            
        } catch (IOException e) {
            System.err.println("[Error] No se pudo cargar el archivo FXML en la ruta: " + fxmlPath);
            System.err.println("[Error] Verifica que el nombre del archivo esté bien escrito y en su carpeta correcta.");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("[Error] La ruta proporcionada es nula o el archivo no existe en resources.");
        }
    }
}