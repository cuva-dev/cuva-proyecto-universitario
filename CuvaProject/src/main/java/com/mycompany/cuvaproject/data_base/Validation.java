package com.mycompany.cuvaproject.data_base;

import java.sql.PreparedStatement;// permite ejecutar consultas SQL con parámetros
import java.sql.Connection; // maneja la conexión a la base de datos
import java.sql.ResultSet; // maneja los resultados de las consultas SQL
import java.sql.SQLException; // maneja los errores relacionados con SQL

public class Validation {

    public String ValidationLogin(ConnectionMySQL CMySQL,String idValue,String passwordValue,Data_Manipulator DataM){
        
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
                 DataM.InsertTableBitacora(CMySQL, ID, "inicio de sesión");
                }else{
                    sql ="false";
                }
               // System.out.println( sql+"   ---User Database: "+ ID + "---User Usuario: " +idValue +"---password Database: " +password +"---password Usuario:"+passwordValue+"---");
    return sql;
    }

    public boolean ValidationRegister(ConnectionMySQL CMySQL,String idValue,String emailValue){

    String sql= "SELECT ID,email FROM User WHERE ID = '"+idValue+"' or Email = '"+emailValue+"'";
    try(Connection conn = CMySQL.conectarMySQL();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()){
            if(rs.next()) {
        System.out.println("usuario ya existe");
        return true;
             }
        }catch (SQLException e) {
            System.err.println("Error al consultar los datos: " + e.getMessage());
        }
        System.out.println("usuario no existente");
            return false;
    }
    
}
