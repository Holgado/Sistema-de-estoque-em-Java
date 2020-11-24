package Connection.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/adm_eletronicos";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        } 
        catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException("Erro na conexão com o banco de dados: " + e);
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        try {
            if (con != null) {
                con.close();
                stmt.close();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados: " + e);
        }
    }
}
