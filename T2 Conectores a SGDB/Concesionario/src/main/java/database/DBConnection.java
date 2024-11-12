package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public Connection getConnection(){

        if(connection == null){
            //Crear conexión
            createConnection();
        }
        //Si ya existe, se retorna la conexión
        return connection;
    }

    private void createConnection(){
        //protocolo de conexion jdbc:mysql
        //host: 127.0.0.1
        //database concesionario_ue
        String url="jdbc:mysql://127.0.0.1/concesionario";
        try {
            connection = DriverManager.getConnection(url, "root","");
            System.out.println("Conexión creada con exito.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión al servidor de BD");
            System.out.println(e.getMessage());
        }

    }
}
