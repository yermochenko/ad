package ad.servlets.jsp.discipline;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.DaoContainer;
import ad.dao.DisciplineDao;
import ad.dao.exception.DaoException;
import ad.domain.Discipline;
import ad.domain.factory.exception.EntityCreateException;

public class DisciplineEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoContainer container = (DaoContainer)req.getAttribute("dao-container");
        Discipline discipline = null;
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            DisciplineDao dao = container.getDisciplineDao();
            discipline = dao.read(id);
        } catch(NumberFormatException e) {
        } catch(DaoException e) {
            throw new ServletException(e);
        }
        if(discipline == null) {
            try {
                discipline = container.getDisciplineFactory().create();
            } catch(EntityCreateException e) {
                throw new ServletException(e);
            }
        }
        req.setAttribute("discipline", discipline);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/discipline/edit.jsp").forward(req, resp);
    }
}
