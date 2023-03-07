package servlets;

import DAO.CosmodromeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteCosmodrome", urlPatterns = "/deleteCosmodrome")
public class deleteCosmodrome extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cName = (request.getParameter("cosmodrome_name"));
        try {
            CosmodromeDAO.remove(cName);
            request.getRequestDispatcher("Cosmodrome.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}