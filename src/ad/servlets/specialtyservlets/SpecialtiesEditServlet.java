package ad.servlets.specialtyservlets;

import ad.dao.DaoContainer;
import ad.dao.DaoContainerFactory;
import ad.dao.DisciplineDao;
import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.dao.mysql.Connector;
import ad.dao.mysql.SpecialtyDaoImpl;
import ad.objects.Discipline;
import ad.objects.Specialty;
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

        DaoContainer container = DaoContainerFactory.create();
        try {
            SpecialtyDao dao = container.getSpecialtyDao();
            if (req.getParameter("check") == null || req.getParameter("check").equals("")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                Specialty specialty = dao.read(id);
                req.setAttribute("specialtyImpl", specialty);
            }
            Collection<Specialty> specialities = dao.readAll();
            req.setAttribute("specialties", specialities);
        } catch (NumberFormatException e) {
        } catch (DaoException e) {
            throw new ServletException(e);
        }finally {
            // TODO: container.close();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editspecialities.jsp").forward(req, resp);
    }
}
