package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.exception.DaoException;
import ad.dao.mysql.Connector;
import ad.dao.mysql.DisciplineDaoImpl;
import ad.objects.Discipline;
import ad.objects.bean.DisciplineImpl;
import ad.objects.factory.SimpleEntityFactory;

public class DisciplinesEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {			
			Integer id = Integer.parseInt(req.getParameter("id"));
			Connection c=Connector.getConnection();
			DisciplineDaoImpl dao=new DisciplineDaoImpl();
			dao.setConnection(c);
			SimpleEntityFactory<Discipline> disciplineFactory = new SimpleEntityFactory<>();
			disciplineFactory.setEntityClass(DisciplineImpl.class);
			dao.setDisciplineFactory(disciplineFactory);
			DisciplineImpl disciplineImpl =(DisciplineImpl)dao.read(id);
			c.close();
			req.setAttribute("disciplineImpl", disciplineImpl);
		} catch (NumberFormatException e) {
		} catch (SQLException |DaoException e) {
			throw new ServletException(e);
		}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/editdiscipline.jsp").forward(req, resp);
	}
}