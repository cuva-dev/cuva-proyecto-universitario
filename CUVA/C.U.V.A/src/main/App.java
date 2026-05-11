package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // 1. Localizar el archivo FXML
            // Como tu carpeta fxml está dentro de resources, la ruta es /fxml/prueba.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/login.fxml"));
            
            // 2. Cargar el diseño
            Parent root = loader.load();
            
            // 3. Crear la escena con el diseño cargado
            Scene scene = new Scene(root);
            
            // 4. Configurar y mostrar la ventana
            primaryStage.setTitle("Mi App con FXML");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}