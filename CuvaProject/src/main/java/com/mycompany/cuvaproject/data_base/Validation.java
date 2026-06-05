package com.mycompany.cuvaproject.data_base;

import java.sql.PreparedStatement;// permite ejecutar consultas SQL con parámetros
import java.sql.Connection; // maneja la conexión a la base de datos
import java.sql.ResultSet; // maneja los resultados de las consultas SQL
import java.sql.SQLException; // maneja los errores relacionados con SQL


import com.mycompany.cuvaproject.models.User;

public class Validation {

    public String ValidationLogin(ConnectionMySQL CMySQL,String idValue,String passwordValue){
        
        String ID = "",password="";
        String sql = "SELECT ID,Password FROM User WHERE ID = '"+idValue+"'";
        try (Connection conn = CMySQL.conectarMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Iterar sobre el ResultSet para extraer los datos
            while (rs.next()) {
                // Extrae datos por el nombre de la columna
                ID = rs.getString("ID");
                password = rs.getString("Password");
            }
        }catch (SQLException e) {
            System.err.println("Error al consultar los datos: " + e.getMessage());
        }  
             if (idValue.equals(ID) && passwordValue.equals(password)){
                    sql = "true";
                }else{
                    sql ="false";
                }
                System.out.println( "---User Database: "+ ID + "---User Usuario: " +idValue +"---password Database: " +password +"---password Usuario:"+passwordValue+"---");
               
    return sql;          
    
}
}
