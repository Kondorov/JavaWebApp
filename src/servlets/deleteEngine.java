package servlets;

import DAO.EngineDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteEngine", urlPatterns = "/deleteEngine")
public class deleteEngine extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String engine_name = (request.getParameter("engine_name"));
        try {
            EngineDAO.remove(engine_name);
            request.getRequestDispatcher("Engine.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}