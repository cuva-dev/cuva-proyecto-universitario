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

public class PruebaController implements Initializable {

    // Este es el contenedor principal (el portarretratos)
    @FXML
    private BorderPane mainContainer; 

    /**
     * Este método se ejecuta automáticamente cuando el MainLayout se carga en pantalla.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Al principio, mostramos la pantalla de Inicio/Bienvenida por defecto
        changeView("/com/mycompany/cuvaproject/register.fxml"); 
    }

    /**
     * Acción del botón "Inicio" en el Navbar
     */
    @FXML
    private void showStudentList(ActionEvent event) {
        changeView("/com/mycompany/cuvaproject/register.fxml");
    }

    /**
     * Acción del botón "Lista de Usuarios" en el Navbar
     */
    @FXML
    private void showCreateUser(ActionEvent event) {
        changeView("/com/mycompany/cuvaproject/login.fxml");
    }

    /**
     * Acción del botón "Bitácora" en el Navbar
     */
    @FXML
    private void handleLogout(ActionEvent event) {
        changeView("/com/mycompany/cuvaproject/min.fxml");
    }

    /**
     * EL MÉTODO MÁGICO: 
     * Se encarga de limpiar el centro del BorderPane e inyectar el nuevo FXML
     */
    private void changeView(String fxmlPath) {
        try {
            // 1. Mensaje en consola para saber qué ventana se solicitó
            System.out.println("[Navbar] Intentando cambiar vista a: " + fxmlPath);
            
            // 2. Cargamos el archivo FXML de la subpantalla de manera independiente
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent subView = loader.load();
            
            // 3. Reemplazamos el contenido viejo del centro por el nuevo
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