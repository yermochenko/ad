package ad.servlets.specialtyservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.exception.DaoException;
import ad.dao.mysql.Connector;
import ad.dao.mysql.SpecialtyDaoImpl;
import ad.objects.Specialty;

public class SpecialtiesServlet extends HttpServlet {
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	                                    throws ServletException, IOException {
		 Collection<Specialty> specialities= null;

		 try {
			 SpecialtyDaoImpl sdao = new SpecialtyDaoImpl();
			 Connection c= Connector.getConnection();
			 sdao.setConnection(c);
			 specialities = sdao.readAll();
			 c.close();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 } catch (DaoException e) {
			 e.printStackTrace();
		 }
		 req.setAttribute("specialities", specialities);
		 getServletContext().getRequestDispatcher("/WEB-INF/jsp/specialities.jsp").forward(req,  resp);
	    }
}
