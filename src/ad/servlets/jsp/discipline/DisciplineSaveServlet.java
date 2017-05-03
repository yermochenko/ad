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

public class DisciplineSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoContainer container = (DaoContainer)req.getAttribute("dao-container");
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        String name = req.getParameter("name");
        String shortName = req.getParameter("shortname");
        if(name != null && shortName != null) {
            try {
                Discipline discipline = container.getDisciplineFactory().create();
                discipline.setId(id);
                discipline.setName(name);
                discipline.setShortName(shortName);
                DisciplineDao disciplineDao = container.getDisciplineDao();
                if(id != null) {
                    disciplineDao.update(discipline);
                } else {
                    disciplineDao.create(discipline);
                }
            } catch(EntityCreateException | DaoException e) {
                throw new ServletException(e);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/discipline/list.html");
    }
}
