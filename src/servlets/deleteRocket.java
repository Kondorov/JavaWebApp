package servlets;

import DAO.RocketDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteRocket", urlPatterns = "/deleteRocket")
public class deleteRocket extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rocket_name = (request.getParameter("rocket_name"));
        try {
            RocketDAO.remove(rocket_name);
            request.getRequestDispatcher("Rocket.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}