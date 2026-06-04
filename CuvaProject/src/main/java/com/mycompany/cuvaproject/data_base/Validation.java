package com.mycompany.cuvaproject.data_base;

import java.sql.Connection; // maneja la conexión a la base de datos
import java.sql.Statement; // permite ejecutar consultas SQL
import java.sql.ResultSet; // maneja los resultados de las consultas SQL
import java.sql.SQLException; // maneja los errores relacionados con SQL


import com.mycompany.cuvaproject.models.User;

public class Validation {

    public String ValidationUsername(ConnectionMySQL CMySQL,User user){
        
        String username = "",password="";
        String sql = "SELECT UserName,Password FROM User WHERE UserName = '"+user.getUsername()+"'";
        try (Connection conn = CMySQL.conectarMySQL();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Iterar sobre el ResultSet para extraer los datos
            while (rs.next()) {
                // Extrae datos por el nombre de la columna
                username = rs.getString("Username");
                password = rs.getString("Password");
            }
        }catch (SQLException e) {
            System.err.println("Error al consultar los datos: " + e.getMessage());
        }  
             if (user.getUsername() != username || user.getPassword() != password){
                    sql = "true";
                }else{
                    sql ="false";
                }
                System.out.println(username + user.getUsername() + password +user.getPassword());
               
    return sql;          
    
}
}
