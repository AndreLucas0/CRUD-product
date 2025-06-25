package connection;

import java.sql.*;

public class DataBaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/sistema_estoque_db";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar o banco de dados: " + e.getMessage());
            return null;
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement stmt) {
        close(connection);
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement stmt, ResultSet rs) {
        close(connection, stmt);
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
