package com.mycompany.cuvaproject.data_base;
import java.sql.Statement; // permite ejecutar consultas SQL
import java.sql.Connection; // maneja la conexión a la base de datos
import java.sql.DriverManager; // establece la conexión con la base de datos
import java.sql.PreparedStatement;// permite ejecutar consultas SQL con parámetros
import java.sql.ResultSet; // maneja los resultados de las consultas SQL
import java.sql.SQLException; // maneja los errores relacionados con SQL

// estos import se pueden borrar despues en el proyecto final
import com.mycompany.cuvaproject.models.User;
import com.mycompany.cuvaproject.models.Student;
import com.mycompany.cuvaproject.models.Subject;
import com.mycompany.cuvaproject.models.Reprobated;

public class Data_Manipulator {

    // Métodos para insertar datos en la tablas
    
    public void InsertTableUser(ConexionMySQL CMySQL,User user){

        // Consulta SQL con marcadores de posición (?)
        String sql = "INSERT INTO user (Name,LastName,UserName,Email,Password,Post) VALUES (?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(CMySQL.geturl(), CMySQL.getusername(), CMySQL.getpassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Asignar valores a los marcadores

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getPost());

            // El "pstmt"Ejecutar la inserción
            int filasInsertadas = pstmt.executeUpdate();
            System.out.println("Filas insertadas: " + filasInsertadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertTableSubject(ConexionMySQL CMySQL,Subject sub){

        String sql = "INSERT INTO Subject (Code,Semester,Unit_Credit,Name) VALUES (?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(CMySQL.geturl(), CMySQL.getusername(), CMySQL.getpassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,sub.getCode());
            pstmt.setInt(2,sub.getSemester() );
            pstmt.setInt(3,sub.getUnit_credit());
            pstmt.setString(4,sub.getName());

            int filasInsertadas = pstmt.executeUpdate();
            System.out.println("Filas insertadas: " + filasInsertadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void InsertTableStudent(ConexionMySQL CMySQL,Student stu){

        String sql = "INSERT INTO Student (ID,Name,LastName,Career,Tuition) VALUES (?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(CMySQL.geturl(), CMySQL.getusername(), CMySQL.getpassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1,stu.getID());
            pstmt.setString(2,stu.getName());
            pstmt.setString(3,stu.getLastName());
            pstmt.setString(4, stu.getCareer());
            pstmt.setString(5, stu.getTuition());

            int filasInsertadas = pstmt.executeUpdate();
            System.out.println("Filas insertadas: " + filasInsertadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
