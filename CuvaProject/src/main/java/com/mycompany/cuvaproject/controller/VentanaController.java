
package com.mycompany.cuvaproject.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

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
    private void registerUser(ActionEvent event) {
        changeView("/com/mycompany/cuvaproject/registroNuevoUsuario.fxml");
    }
    
    @FXML
    private void closeSesion(ActionEvent event) {
        changeView("/com/mycompany/cuvaproject/main.fxml");
    }
    
    @FXML
    private void showBinnacle(ActionEvent event) {
        changeView("/com/mycompany/cuvaproject/Bitacora.fxml");
    }

    private void changeView(String fxmlPath) {
        try {
            
            System.out.println("[Navbar] Intentando cambiar vista a: " + fxmlPath);
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent subView = loader.load();
            
            
            mainContainer.setCenter(subView);
            
            System.out.println("[Navbar] ¡Vista cambiada con éxito!");
            
        } catch (IOException e) {
            System.err.println("[Error] No se pudo cargar el archivo FXML en la ruta: " + fxmlPath);
            System.err.println("[Error] Verifica que el nombre del archivo esté bien escrito (ej: .fxml) y en su carpeta correcta.");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("[Error] La ruta proporcionada es nula o el archivo no existe en resources.");
        }
    }
}
