package ad.servlets.specialtyservlets;

import ad.dao.mysql.Connector;
import ad.dao.mysql.SpecialtyDaoImpl;
import ad.objects.bean.SpecialtyImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialtiesEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            SpecialtyDaoImpl sdao = new SpecialtyDaoImpl();
            Connection c= Connector.getConnection();
            sdao.setConnection(c);
            if (req.getParameter("check") == null || req.getParameter("check").equals("")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                SpecialtyImpl specialtyImpl = sdao.read(id);
                req.setAttribute("specialtyImpl", specialtyImpl);

            }
            c.close();
        } catch (NumberFormatException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collection<SpecialtyImpl> specialities= null;
        try {
            SpecialtyDaoImpl sdao = new SpecialtyDaoImpl();
            Connection c= Connector.getConnection();
            sdao.setConnection(c);
            specialities = sdao.readAll();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("specialties", specialities);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editspecialities.jsp").forward(req, resp);
    }
}
