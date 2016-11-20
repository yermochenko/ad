package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.Connector;
import ad.DisciplineDaoImpl;

public class DisciplinesDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Connection c=Connector.getConnection();
			DisciplineDaoImpl dao=new DisciplineDaoImpl();
			dao.setConnection(c);
			dao.delete(Integer.parseInt(req.getParameter("id")));
			c.close();
			resp.sendRedirect(req.getContextPath() + "/disciplines.html");
		} catch (NumberFormatException e) {
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}