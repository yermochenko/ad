package ad.servlets.disciplinesservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.Storage;

public class DisciplinesEditServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		try{
			Integer id=Integer.parseInt(req.getParameter("id"));
			ad.objects.Discipline discipline=Storage.getDisciplineById(id);
			req.setAttribute("discipline", discipline);
		} catch(NumberFormatException e) {}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/editdiscipline.jsp").forward(req, resp);
	}
}