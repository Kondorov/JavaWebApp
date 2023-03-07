package servlets;

import DAO.FlightDAO;
import Entity.FlightEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "updateFlight", urlPatterns = "/updateFlight")
public class updateFlight extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("updateFlight.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        FlightEntity p = new FlightEntity();

        p.setDate(request.getParameter("flight_date"));
        p.setCName(request.getParameter("cosmodrome_name"));
        p.setRName(request.getParameter("rocket_name"));
        p.setDuration(Integer.parseInt( (request.getParameter("duration"))));
        p.setSuccess(Boolean.parseBoolean(request.getParameter("success")));

        request.getRequestDispatcher("Flight.jsp").forward(request,response);

        try {
            FlightDAO.update(p);
            request.getRequestDispatcher("Flight.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}