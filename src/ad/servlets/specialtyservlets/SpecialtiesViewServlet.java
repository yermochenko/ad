package ad.servlets.specialtyservlets;

import ad.Connector;
import ad.Storage;
import ad.dao.mysql.SpecialtyDaoImpl;
import ad.objects.Specialty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by HomeInc on 28.10.2016.
 */
public class SpecialtiesViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SpecialtyDaoImpl sdao = new SpecialtyDaoImpl();
            Connection c= Connector.getConnection();
            sdao.setConnection(c);
            if (req.getParameter("check") == null || req.getParameter("check").equals("")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                ad.objects.Specialty specialty = sdao.read(id);
                req.setAttribute("specialty", specialty);
            }
            c.close();
        } catch (NumberFormatException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/viewSpecialities.jsp").forward(req, resp);
    }
}