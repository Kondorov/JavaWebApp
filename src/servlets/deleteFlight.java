package servlets;

import DAO.FlightDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteFlight", urlPatterns = "/deleteFlight")
public class deleteFlight extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (request.getParameter("cosmodrome_name"));
        try {
            FlightDAO.remove(name);
            request.getRequestDispatcher("Flight.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}