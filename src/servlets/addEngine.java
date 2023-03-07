package servlets;

import DAO.EngineDAO;
import Entity.EngineEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addEngine", urlPatterns = "/addEngine")
public class addEngine extends HttpServlet {
    EngineDAO sd = new EngineDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("addEngine.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        EngineEntity p = new EngineEntity();
        p.setEName(request.getParameter("engine_name"));
        p.setTraction(Integer.parseInt(request.getParameter("traction")));
        p.setFueltype(request.getParameter("fueltype"));

        try {
            sd.add(p);
            request.getRequestDispatcher("Engine.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}