package ad.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ad.dao.DaoContainer;
import ad.dao.DaoContainerFactory;
import ad.dao.DisciplineDao;
import ad.dao.exception.DaoException;
import ad.domain.Discipline;

public class DisciplineServlet extends HttpServlet{
	// READ
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		DaoContainer container = DaoContainerFactory.create();
		try{
			DisciplineDao dao=container.getDisciplineDao();
			Collection<Discipline> disciplines = dao.readAll();
			resp.setCharacterEncoding("UTF-8");
			new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValue(resp.getOutputStream(), disciplines);
		} catch(DaoException e){
			throw new ServletException(e);
		} finally{
			//TODO: container.close();
		}
	}
}
