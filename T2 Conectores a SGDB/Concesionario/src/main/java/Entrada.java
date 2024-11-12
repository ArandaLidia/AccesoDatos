import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Entrada {
    public static void main(String[] args) {
        agregarCoches("Mercedes", "C200", 90000);
        borrarCoches("C200");

    }

    public static void agregarCoches(String marca, String modelo, int precio) {
        Connection connection = new DBConnection().getConnection();

        String query = String.format("INSERT INTO %s (%s, %s, %s) VALUE (?,?,?)", "coches", "marca", "modelo", "precio");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, marca);
            preparedStatement.setString(2, modelo);
            preparedStatement.setInt(3, precio);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("La query está mal ejecutada.");
            System.out.println(e.getMessage());
        }
    }

    public static void borrarCoches(String modelo) {
        Connection connection = new DBConnection().getConnection();
        String query = String.format("DELETE FROM %s WHERE %s=?", "coches", "modelo");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, modelo);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Query mal ejecutada");
        }


    }
}
