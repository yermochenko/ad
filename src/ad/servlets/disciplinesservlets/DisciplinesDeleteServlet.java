package ad.servlets.disciplinesservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisciplinesDeleteServlet extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		try{
			ad.Storage.deleteDisciplineById(Integer.parseInt(req.getParameter("id")));
		} catch(NumberFormatException e) {}
		resp.sendRedirect(req.getContextPath() + "/disciplines.html");
	}
}