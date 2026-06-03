package com.mycompany.cuvaproject.data_base;
import java.sql.Connection; // maneja la conexión a la base de datos
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
    
        public void InsertTableUser(ConnectionMySQL CMySQL,User user){

        // Consulta SQL en este caso Insertar
        String sql = "INSERT INTO user (Name,LastName,UserName,Email,Password,Post) VALUES ('"+user.getName()+"','"+user.getLastName()+"','"+user.getUsername()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getPost()+"')";

        //conecta a la base de datos
        try (Connection conn = CMySQL.conectarMySQL()) {
            
            // prepara la consulta SQL
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // el "pstmt" ejecutar la inserción
            pstmt.executeUpdate();
                
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void InsertTableSubject(ConnectionMySQL CMySQL,Subject sub){

        String sql = "INSERT INTO Subject (Code,Semester,Unit_Credit,Name) VALUES ('"+sub.getCode()+"','"+sub.getSemester()+"','"+sub.getUnit_credit()+"','"+sub.getName()+"')";
        
        try (Connection conn = CMySQL.conectarMySQL()) {
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void InsertTableStudent(ConnectionMySQL CMySQL,Student stu){

        String sql = "INSERT INTO Student (ID,Name,LastName,Career,Tuition) VALUES ('"+stu.getID()+"','"+stu.getName()+"','"+stu.getLastName()+"','"+stu.getCareer()+"','"+stu.getTuition()+"')";

        try (Connection conn = CMySQL.conectarMySQL()){

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertTableReprobated(ConnectionMySQL CMySQL,Reprobated rep){

        String sql = "INSERT INTO Reprobated (ID,CodeSubject) VALUES ('"+rep.getIDStudent()+"','"+rep.getCodeSubject()+"')";

        try (Connection conn = CMySQL.conectarMySQL()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos para eliminar datos en la tablas

    public void DeleteInTableUser(ConnectionMySQL CMySQL,User user){


        // Consulta SQL en este caso Borrar
        String sql = "DELETE FROM user WHERE UserName = '"+user.getUsername()+"'";
        // conecta a la base de datos
        try (Connection conn = CMySQL.conectarMySQL()) {
            
            PreparedStatement pstmt = conn.prepareStatement(sql);

            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Registro eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún registro con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar datos: " + e.getMessage());
        }
    }

    public void DeleteInTableSubject(ConnectionMySQL CMySQL,Subject sub){

        String sql = "DELETE FROM Subject WHERE code = '"+sub.getCode()+"'";

        try (Connection conn = CMySQL.conectarMySQL()){
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Registro eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún registro con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar datos: " + e.getMessage());
        }
    }

    public void DeleteInTableStudent(ConnectionMySQL CMySQL,Student stu){

        String sql = "DELETE FROM Student WHERE ID = '"+stu.getID()+"'";

        try (Connection conn = CMySQL.conectarMySQL())
         {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Registro eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún registro con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar datos: " + e.getMessage());
        }
    }
    
    public void DeleteInTableReprobated(ConnectionMySQL CMySQL,Reprobated Rep){

        String sql = "DELETE FROM reprobated WHERE ID = '"+Rep.getIDStudent()+"'";

        try (Connection conn = CMySQL.conectarMySQL()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);

            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Registro eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún registro con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar datos: " + e.getMessage());
        }
    }
    
    // Métodos para modificar datos en la tablas

    public void modifyTableUser(ConnectionMySQL CMySQL,User user){

        String sql = "UPDATE User SET Name = '"+user.getName()+"',LastName = '"+user.getLastName()+"',Email = '"+user.getEmail()+"', Password = '"+user.getPassword()+"', Post = '"+user.getPost()+"' WHERE UserName = '"+user.getUsername()+"'";

        try (Connection conn = CMySQL.conectarMySQL()){

            PreparedStatement pstmt = conn.prepareStatement(sql);

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("¡Registro modificado exitosamente!");
            } else {
                System.out.println("No se encontró un registro con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar los datos: " + e.getMessage());
        }
    }

    public void modifyTableSubject(ConnectionMySQL CMySQL,Subject sub){

        String sql = "UPDATE Subject SET Code='"+sub.getCode()+"',Semester='"+sub.getSemester()+"',Unit_Credit='"+sub.getUnit_credit()+"',Name='"+sub.getName()+"'";
        try (Connection conn = CMySQL.conectarMySQL()){

            PreparedStatement pstmt = conn.prepareStatement(sql);

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("¡Registro modificado exitosamente!");
            } else {
                System.out.println("No se encontró un registro con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar los datos: " + e.getMessage());
        }
    }

    public void modifyTableStudent(ConnectionMySQL CMySQL,Student stu){

        String sql = "UPDATE Student SET Name='"+stu.getName()+"',LastName='"+stu.getLastName()+"',Career='"+stu.getCareer()+"',Tuition='"+stu.getTuition()+"' WHERE ID = '"+stu.getID()+"'";
        try (Connection conn = CMySQL.conectarMySQL()){

            PreparedStatement pstmt = conn.prepareStatement(sql);

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("¡Registro modificado exitosamente!");
            } else {
                System.out.println("No se encontró un registro con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar los datos: " + e.getMessage());
        }
    }

    public void modifyTableReprobated(ConnectionMySQL CMySQL,Reprobated rep){

        String sql = "UPDATE Reprobated SET ID='"+rep.getIDStudent()+"',CodeSubject='"+rep.getCodeSubject()+"' WHERE IDStudent = '"+rep.getIDStudent()+"'";
        try (Connection conn = CMySQL.conectarMySQL()){

            PreparedStatement pstmt = conn.prepareStatement(sql);

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("¡Registro modificado exitosamente!");
            } else {
                System.out.println("No se encontró un registro con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al modificar los datos: " + e.getMessage());
        }
    }
    
    
    //metodo para extraer datos de las tablas

        public void ExtractTableUser(ConnectionMySQL CMySQL,User user){

        String sql = "SELECT * FROM User WHERE UserName = '"+user.getUsername()+"'";
        try (Connection conn = CMySQL.conectarMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Iterar sobre el ResultSet para extraer los datos
            while (rs.next()) {
                // Extrae datos por el nombre de la columna
                String username = rs.getString("Username");
                String name = rs.getString("Name");
                String lastname = rs.getString("Lastname");
                String email = rs.getString("email"); 

                System.out.println(username + name);
        }

        } catch (SQLException e) {
            System.err.println("Error al consultar los datos: " + e.getMessage());
        }

    }
    
    public void ExtractTableSubject(ConnectionMySQL CMySQL,Subject sub){

    String sql = "SELECT * FROM Subject WHERE Code = '"+sub.getCode()+"'";  

    try(Connection conn = CMySQL.conectarMySQL()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                int semester = rs.getInt("Semester");
                int unit_credit = rs.getInt("Unit_Credit");
            }
            }catch(SQLException e){
    System.err.println("Error al consultar los datos: " + e.getMessage());
   }
}

    public void ExtractTableStudent(ConnectionMySQL CMySQL,Student stu){

    String sql = "SELECT * FROM Student WHERE ID= '"+stu.getID()+"'";

    try (Connection conn = CMySQL.conectarMySQL()){
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            
            String name = rs.getString("name");
            String lastname = rs.getString("lastname");
            String career = rs.getString("career");
            String tuition = rs.getString("tuition");
        }  
    } catch (SQLException e) {
        e.printStackTrace();
        
    }



    }
    
    public void ExtractTableReprobated(ConnectionMySQL CMySQL,Reprobated rep){
        String sql = "SELECT stu.ID, stu.Name, sub.Code, sub.name FROM reprobated rep "
        +" INNER JOIN Student stu ON rep.IDStudent = stu.ID "
        +" INNER JOIN Subject sub ON rep.CodeSubject = sub.Code "
        +" WHERE rep.IDStudent = '32066670';";

        try (Connection conn = CMySQL.conectarMySQL();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
        
        while(rs.next()){
        int ID = rs.getInt("ID");
        int Code = rs.getInt("Code");
        String nameSubject = rs.getString("Name");
        String nameStudent = rs.getString("Name");

        System.out.println(ID + Code + nameStudent + nameSubject +"1");
        }    
        } catch (Exception e) {
            System.out.println(e);
        }

        
    }



}
    
