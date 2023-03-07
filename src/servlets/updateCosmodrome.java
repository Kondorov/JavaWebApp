package servlets;

import DAO.CosmodromeDAO;
import Entity.CosmodromeEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "updateCosmodrome", urlPatterns = "/updateCosmodrome")
public class updateCosmodrome extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("updateCosmodrome.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        CosmodromeEntity p = new CosmodromeEntity();
        p.setCName(request.getParameter("cosmodrome_name"));
        p.setCountry(request.getParameter("country"));
        p.setTimezone(request.getParameter("timezone"));

        request.getRequestDispatcher("Cosmodrome.jsp").forward(request,response);

        try {
            CosmodromeDAO.update(p);
            request.getRequestDispatcher("Cosmodrome.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}