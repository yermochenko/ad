package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.mysql.Connector;
import ad.dao.mysql.DisciplineDaoImpl;
import ad.objects.bean.DisciplineImpl;

public class DisciplinesSaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {			
			req.setCharacterEncoding("UTF-8");
			DisciplineImpl disciplineImpl = new DisciplineImpl(req.getParameter("name"), req.getParameter("shortname"));
			try {
				disciplineImpl.setId(Integer.parseInt(req.getParameter("id")));
			} catch (NumberFormatException e) {
			}
			Connection c=Connector.getConnection();
			DisciplineDaoImpl dao=new DisciplineDaoImpl();
			dao.setConnection(c);
			if (disciplineImpl.getId() == null) {
				dao.create(disciplineImpl);
			} else {
				dao.update(disciplineImpl);
			}
			c.close();
			resp.sendRedirect(req.getContextPath() + "/disciplines.html");			
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
