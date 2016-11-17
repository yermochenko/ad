package ad.servlets.specialtyservlets;

import ad.objects.Discipline;
import ad.objects.Specialty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialtiesServlet extends HttpServlet {
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	                                    throws ServletException, IOException {
		 Collection<Specialty> specialities= null;
		 try {
			 specialities = ad.Storage.getAllSpecialties();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 req.setAttribute("specialities", specialities);
		 getServletContext().getRequestDispatcher("/WEB-INF/jsp/specialities.jsp").forward(req,  resp);
	    }
}
