package ad.servlets.jsp.specialty;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.DaoContainer;
import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.domain.Specialty;

public class SpecialtyListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoContainer container = (DaoContainer)req.getAttribute("dao-container");
        try {
            SpecialtyDao dao = container.getSpecialtyDao();
            Collection<Specialty> specialties = dao.readAll();
            req.setAttribute("specialties", specialties);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/specialty/list.jsp").forward(req, resp);
        } catch(DaoException e) {
            throw new ServletException(e);
        }
    }
}
