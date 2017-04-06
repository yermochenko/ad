package ad.servlets.specialtyservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.DaoContainer;
import ad.dao.DaoContainerFactory;
import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;

public class SpecialtiesDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DaoContainer container = DaoContainerFactory.create();
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            SpecialtyDao dao = container.getSpecialtyDao();
            dao.delete(id);
            resp.sendRedirect(req.getContextPath() + "/specialties.html");
        } catch(NumberFormatException e) {} catch(DaoException e) {
            throw new ServletException(e);
        } finally {
            // TODO: container.close();
        }
    }
}
