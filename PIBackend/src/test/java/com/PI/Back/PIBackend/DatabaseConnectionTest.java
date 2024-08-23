package com.PI.Back.PIBackend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        // Parámetros de conexión
        String url = "jdbc:mysql://localhost:3306/SonidosPrestados"; // URL de conexión
        String user = "root"; // Usuario de la base de datos
        String password = "ZFvgWAH3b0nRyMYQxjXT"; // Contraseña del usuario

        // Intentar establecer la conexión
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                System.out.println("Conexión fallida.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM Usuarios")) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println("Número de usuarios en la base de datos: " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
