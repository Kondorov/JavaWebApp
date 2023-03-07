package DAO;

import java.sql.DriverManager;
import Entity.CosmodromeEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CosmodromeDAO {
    private static Connection connection = null;

    private String username = "postgres";
    private String password="1111";
    private String host="localhost";
    private int port=5432;
    private String sid="KURSA4";

    public CosmodromeDAO()  {
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

    public static List getAll() throws SQLException {
        try {
            openConnection();
            ResultSet set = connection.createStatement().executeQuery("SELECT * FROM \"Cosmodrome\"");
            List list = new ArrayList<>();
            while (set.next())
                list.add(new CosmodromeEntity(
                        set.getString("cosmodrome_name"),
                        set.getString("country"),
                        set.getString("timezone")));
            return list;
        }
        catch (Exception e) {
            return null;
        } finally {
            closeConnection();
        }
    }

    //INSERT
    public static void add(CosmodromeEntity cE) throws SQLException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Cosmodrome\" (\"cosmodrome_name\", \"country\", \"timezone\") VALUES (?,?,?)");
            statement.setString(1, cE.getCName());
            statement.setString(2, cE.getCountry());
            statement.setString(3, cE.getTimezone());
            statement.executeUpdate();}
        finally {
            closeConnection();
        }
    }

    //DELETE
    public static void remove(String cName) throws SQLException {
        try {
            openConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"Cosmodrome\" WHERE \"cosmodrome_name\" = ?");
            statement.setString(1, cName);
            statement.executeUpdate();
        }
        finally {
            closeConnection();
        }
    }

    //UPDATE
    public static void update(CosmodromeEntity cE) throws SQLException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("UPDATE \"Cosmodrome\" SET \"country\" = ?,\"timezone\" = ? WHERE \"cosmodrome_name\" = ?");
            statement.setString(1, cE.getCountry());
            statement.setString(2, cE.getTimezone());
            statement.setString(3, cE.getCName());
            statement.executeUpdate();
        }
        finally {
            closeConnection();
        }
    }
}
