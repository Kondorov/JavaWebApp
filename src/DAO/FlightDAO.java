package DAO;

import java.sql.DriverManager;
import Entity.FlightEntity;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FlightDAO {
    private static Connection connection;

    private String username = "postgres";
    private String password="1111";
    private String host="localhost";
    private int port=5432;
    private String sid="KURSA4";

    public FlightDAO()  {
    }

    private static void openConnection() throws SQLException {
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
            ResultSet set = connection.createStatement().executeQuery("SELECT * FROM \"Flight\"");
            List list = new ArrayList<>();
            while (set.next())
                list.add(new FlightEntity(
                        set.getString("flight_date"),
                        set.getString("cosmodrome_name"),
                        set.getString("rocket_name"),
                        set.getInt("duration"),
                        set.getBoolean("success")));

            return list;
        }
        catch (Exception e) {
            return null;
        } finally {
            closeConnection();
        }
    }

    //INSERT
    public static void add(FlightEntity cE) throws SQLException, ParseException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Flight\" (\"flight_date\", \"cosmodrome_name\", \"rocket_name\", \"duration\", \"success\") VALUES (?,?,?,?,?)");

            Date date = new Date();

            statement.setDate(1, new java.sql.Date(dateToString(date, cE.getDate()).getTime()));
            statement.setString(2, cE.getCName());
            statement.setString(3, cE.getRName());
            statement.setInt(4, cE.getDuration());
            statement.setBoolean(5, cE.getSuccess());
            statement.executeUpdate();}
        finally {
            closeConnection();
        }
    }
    public static Date dateToString(Date date, String f) throws ParseException {
        final String TIME_FORMAT = "yyyy-MM-dd";
        final SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        final java.util.Date utilDate = sdf.parse(f);
        return(utilDate);
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
    public static void update(FlightEntity cE) throws SQLException, ParseException {
        try {
            openConnection();

            PreparedStatement statement = connection.prepareStatement("UPDATE \"Flight\" SET \"flight_date\" = ?,\"rocket_name\" = ?,\"duration\" = ?,\"success\" = ? WHERE \"cosmodrome_name\" = ?");
            Date date = new Date();
            statement.setDate(1, new java.sql.Date(dateToString(date, cE.getDate()).getTime()));
            statement.setString(2, cE.getRName());
            statement.setInt(3, cE.getDuration());
            statement.setBoolean(4, cE.getSuccess());
            statement.setString(5, cE.getCName());
            statement.executeUpdate();
        }
        finally {
            closeConnection();
        }
    }
}
