package com.mycompany.cuvaproject.data_base;

import java.sql.Connection; // maneja la conexión a la base de datos
import java.sql.Statement; // permite ejecutar consultas SQL
import java.sql.ResultSet; // maneja los resultados de las consultas SQL
import java.sql.SQLException; // maneja los errores relacionados con SQL


import com.mycompany.cuvaproject.models.User;

public class Validation {

    public String ValidationLogin(ConnectionMySQL CMySQL,String idValue,String passwordValue){
        
        String ID = "",password="";
        String sql = "SELECT ID,Password FROM User WHERE ID = '"+idValue+"'";
        try (Connection conn = CMySQL.conectarMySQL();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Iterar sobre el ResultSet para extraer los datos
            while (rs.next()) {
                // Extrae datos por el nombre de la columna
                ID = rs.getString("ID");
                password = rs.getString("Password");
            }
        }catch (SQLException e) {
            System.err.println("Error al consultar los datos: " + e.getMessage());
        }  
             if (idValue != ID || passwordValue != password){
                    sql = "true, iniciando seccion";
                }else{
                    sql ="false, no se encuentra registrado";
                }
                System.out.println(ID + idValue + password +passwordValue);
               
    return sql;          
    
}
}
