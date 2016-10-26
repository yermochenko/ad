package ad.servlets.specialtyservlets;

import ad.objects.Discipline;
import ad.objects.Specialty;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialtiesServlet extends HttpServlet {
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	                                    throws ServletException, IOException {
		 Collection<Specialty> specialities=ad.Storage.getAllSpecialties();
		 req.setAttribute("specialities", specialities);
		 getServletContext().getRequestDispatcher("/WEB-INF/jsp/specialities.jsp").forward(req,  resp);
	    }
}
