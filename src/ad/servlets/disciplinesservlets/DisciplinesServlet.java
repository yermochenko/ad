package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.mysql.Connector;
import ad.dao.mysql.DisciplineDaoImpl;
import ad.objects.Discipline;

public class DisciplinesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {	
			Connection c=Connector.getConnection();
			DisciplineDaoImpl dao=new DisciplineDaoImpl();
			dao.setConnection(c);
			Collection<Discipline> disciplines=dao.readAll();
			c.close();
			req.setAttribute("disciplines", disciplines);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/disciplines.jsp").forward(req, resp);			
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}