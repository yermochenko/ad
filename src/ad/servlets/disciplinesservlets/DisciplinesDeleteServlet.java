package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.Storage;

public class DisciplinesDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			Storage.deleteDisciplineById(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect(req.getContextPath() + "/disciplines.html");
			
		} catch (NumberFormatException e) {
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}