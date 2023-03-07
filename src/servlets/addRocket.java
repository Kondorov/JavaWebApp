package servlets;

import DAO.RocketDAO;
import Entity.RocketEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addRocket", urlPatterns = "/addRocket")
public class addRocket extends HttpServlet {
    RocketDAO sd = new RocketDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("addRocket.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RocketEntity p = new RocketEntity();
        p.setRName(request.getParameter("rocket_name"));
        p.setEnumb(Integer.parseInt(request.getParameter("engines_number")));
        p.setHeight(Integer.parseInt(request.getParameter("height")));

        try {
            sd.add(p);
            request.getRequestDispatcher("Rocket.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}