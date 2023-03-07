package DAO;

import java.sql.DriverManager;
import Entity.EngineEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EngineDAO {
    private static Connection connection;

    private String username = "postgres";
    private String password="1111";
    private String host="localhost";
    private int port=5432;
    private String sid="KURSA4";

    public EngineDAO()  {
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

            ResultSet set = connection.createStatement().executeQuery("SELECT * FROM \"Engine\"");
            List list = new ArrayList<>();
            while (set.next())
                list.add(new EngineEntity(
                        set.getString("engine_name"),
                        set.getInt("traction"),
                        set.getString("fuel_type")));

            return list;
        }
        catch (Exception e) {
            return null;
        } finally {
            closeConnection();
        }
    }

    //INSERT
    public static void add(EngineEntity cE) throws SQLException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Engine\" (\"engine_name\", \"traction\", \"fuel_type\") VALUES (?,?,?)");
            statement.setString(1, cE.getEName());
            statement.setInt(2, cE.getTraction());
            statement.setString(3, cE.getFueltype());
            statement.executeUpdate();}
        finally {
            closeConnection();
        }
    }

    //DELETE
    public static void remove(String engine_name) throws SQLException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"Engine\" WHERE \"engine_name\" = ?");
            statement.setString(1, engine_name);
            statement.executeUpdate();
        }
        finally {
            closeConnection();
        }
    }

    //UPDATE
    public static void update(EngineEntity cE) throws SQLException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("UPDATE \"Engine\" SET \"traction\" = ?,\"fuel_type\" = ? WHERE \"engine_name\" = ?");

            statement.setInt(1, cE.getTraction());
            statement.setString(2, cE.getFueltype());
            statement.setString(3, cE.getEName());
            statement.executeUpdate();
        }
        finally {
            closeConnection();
        }
    }
}
