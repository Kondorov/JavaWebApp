package DAO;

import java.sql.DriverManager;
import Entity.RocketEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RocketDAO {
    private static Connection connection;

    private String username = "postgres";
    private String password="1111";
    private String host="localhost";
    private int port=5432;
    private String sid="KURSA4";

    public RocketDAO()  {
    }

    private static void openConnection() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/KURSA4", "postgres", "1111");
        }catch(ClassNotFoundException err){};
    }

    private static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed())
            connection.close();
    }

    //SELECT *
    public static List getAll() throws SQLException {
        try {
            openConnection();

            ResultSet set = connection.createStatement().executeQuery("SELECT * FROM \"Rocket\"");
            List list = new ArrayList<>();
            while (set.next())
                list.add(new RocketEntity(
                        set.getString("rocket_name"),
                        set.getInt("engines_number"),
                        set.getInt("height")));

            return list;
        }
        catch (Exception e) {
            return null;
        } finally {
            closeConnection();
        }
    }

    //INSERT
    public static void add(RocketEntity cE) throws SQLException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Rocket\" (\"rocket_name\", \"engines_number\", \"height\") VALUES (?,?,?)");
            statement.setString(1, cE.getRName());
            statement.setInt(2, cE.getEnumb());
            statement.setInt(3, cE.getHeight());
            statement.executeUpdate();}
        finally {
            closeConnection();
        }
    }

    //DELETE
    public static void remove(String rocket_name) throws SQLException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"Rocket\" WHERE \"rocket_name\" = ?");
            statement.setString(1, rocket_name);
            statement.executeUpdate();
        }
        finally {
            closeConnection();
        }
    }

    //UPDATE
    public static void update(RocketEntity cE) throws SQLException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("UPDATE \"Rocket\" SET \"engines_number\" = ?,\"height\" = ? WHERE \"rocket_name\" = ?");

            statement.setInt(1, cE.getEnumb());
            statement.setInt(2, cE.getHeight());
            statement.setString(3, cE.getRName());
        }
        finally {
            closeConnection();
        }
    }
}
