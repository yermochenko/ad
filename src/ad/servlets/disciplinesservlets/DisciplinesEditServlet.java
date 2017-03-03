package ad.servlets.disciplinesservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.DaoContainer;
import ad.dao.DaoContainerFactory;
import ad.dao.DisciplineDao;
import ad.dao.exception.DaoException;
import ad.domain.Discipline;

public class DisciplinesEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoContainer container = DaoContainerFactory.create();
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            DisciplineDao dao = container.getDisciplineDao();
            Discipline discipline = dao.read(id);
            req.setAttribute("discipline", discipline);
        } catch(NumberFormatException e) {} catch(DaoException e) {
            throw new ServletException(e);
        } finally {
            // TODO: container.close();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editdiscipline.jsp").forward(req, resp);
    }
}
