package Java_and_mySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    // Librería de MySQL
    private String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    private String database = "database_unefa";

    public String getdatabase(){return database;}


    // Host
    private String hostname = "127.0.0.1";

    public String gethostname(){return hostname;}


    // Puerto
    public String port = "3306";

    public String getport(){return port;}


    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
     private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    public String geturl(){return url;}

    // Nombre de usuario
    private String username = "root";

    public String getusername(){return username;}


    // Clave de usuario
    private String password = "";

    public String getpassword(){return password;}


    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(geturl(), getusername(), getpassword());
            System.out.println("se conecto a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("no se conecto a la base de datos");

      }

        return conn;
    }
}


