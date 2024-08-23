package com.PI.Back.PIBackend.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {
        // Parámetros de conexión
        String url = "jdbc:mysql://localhost:3306/SonidosPrestados"; // URL de conexión
        String user = "root"; // Usuario de la base de datos
        String password = "ZFvgWAH3b0nRyMYQxjXT"; // Contraseña del usuario

        // Intentar establecer la conexión
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
    }
}
