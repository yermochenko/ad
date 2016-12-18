package ad.servlets.specialtyservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.DaoContainer;
import ad.dao.DaoContainerFactory;
import ad.dao.DisciplineDao;
import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.dao.mysql.Connector;
import ad.dao.mysql.SpecialtyDaoImpl;
import ad.objects.Discipline;
import ad.objects.Specialty;

public class SpecialtiesServlet extends HttpServlet {
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	                                    throws ServletException, IOException {

		 Collection<Specialty> specialities= null;
		 DaoContainer container = DaoContainerFactory.create();
		 try {
			 SpecialtyDao sdao = container.getSpecialtyDao();
			 specialities = sdao.readAll();
		 } catch (DaoException e) {
			 throw new ServletException(e);
		 } finally {
			 // TODO: container.close();
		 }
		 req.setAttribute("specialities", specialities);
		 getServletContext().getRequestDispatcher("/WEB-INF/jsp/specialities.jsp").forward(req,  resp);
	    }
}
