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
import ad.domain.bean.DisciplineImpl;

public class DisciplinesSaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoContainer container = DaoContainerFactory.create();
		try {			
			req.setCharacterEncoding("UTF-8");
			DisciplineImpl disciplineImpl = new DisciplineImpl();
			disciplineImpl.setName(req.getParameter("name"));
			disciplineImpl.setShortName(req.getParameter("shortname"));
			try {
				disciplineImpl.setId(Integer.parseInt(req.getParameter("id")));
			} catch (NumberFormatException e) {
			}
			
			DisciplineDao dao = container.getDisciplineDao();
			if (disciplineImpl.getId() == null) {
				dao.create(disciplineImpl);
			} else {
				dao.update(disciplineImpl);
			}
			resp.sendRedirect(req.getContextPath() + "/disciplines.html");			
		} catch (DaoException e) {
			throw new ServletException(e);
		}
		finally {
			// TODO: container.close();
		}
	}
}
