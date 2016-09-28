package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisciplinesServlet extends HttpServlet {
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	                                    throws ServletException, IOException {
	        Collection <ad.objects.Discipline> disciplines=ad.Storage.getAllDisciplines();
	        req.setAttribute("disciplines", disciplines);
	        getServletContext().getRequestDispatcher("/WEB-INF/disciplines.html").forward(req,  resp);
	    }
}