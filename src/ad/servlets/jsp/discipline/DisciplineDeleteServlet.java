package ad.servlets.jsp.discipline;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.DaoContainer;
import ad.dao.DisciplineDao;
import ad.dao.exception.DaoException;

public class DisciplineDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoContainer container = (DaoContainer)req.getAttribute("dao-container");
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            DisciplineDao disciplineDao = container.getDisciplineDao();
            disciplineDao.delete(id);
        } catch(NumberFormatException e) {
        } catch(DaoException e) {
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/discipline/list.html");
    }
}
