package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.DaoContainer;
import ad.dao.DaoContainerFactory;
import ad.dao.DisciplineDao;
import ad.dao.exception.DaoException;
import ad.objects.Discipline;

public class DisciplinesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoContainer container = DaoContainerFactory.create();
		try {
			DisciplineDao dao = container.getDisciplineDao();
			Collection<Discipline> disciplines = dao.readAll();
			req.setAttribute("disciplines", disciplines);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/disciplines.jsp").forward(req, resp);
		} catch (DaoException e) {
			throw new ServletException(e);
		} finally {
			// TODO: container.close();
		}
	}
}