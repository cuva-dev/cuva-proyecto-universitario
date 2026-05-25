module com.mycompany.cuvaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.pdfbox;
    
    opens com.mycompany.cuvaproject.controller to javafx.fxml;
    opens com.mycompany.cuvaproject.models to javafx.fxml;
    opens com.mycompany.cuvaproject.data_base to javafx.fxml;
    

    
    opens com.mycompany.cuvaproject to javafx.fxml;
    exports com.mycompany.cuvaproject;
}
