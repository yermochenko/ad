package ad.servlets.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ad.dao.DaoContainer;
import ad.dao.DisciplineDao;
import ad.dao.exception.DaoException;
import ad.domain.Discipline;
import ad.domain.factory.exception.EntityCreateException;

public class DisciplineServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoContainer container = (DaoContainer) req.getAttribute("dao-container");
		try {
			DisciplineDao dao = container.getDisciplineDao();
			List<Discipline> disciplines = dao.readAll();
			resp.setCharacterEncoding("UTF-8");
			new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValue(resp.getOutputStream(), disciplines);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoContainer container = (DaoContainer) req.getAttribute("dao-container");
		try {
			Discipline discipline = new ObjectMapper().readValue(req.getReader(), container.getDisciplineFactory().create().getClass());
			DisciplineDao dao = container.getDisciplineDao();
			if (discipline.getId() == null) {
				dao.create(discipline);
				resp.setStatus(201);
			} else {
				dao.update(discipline);
				resp.setStatus(200);
			}
		} catch (EntityCreateException | DaoException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: реализовать удаление
	}
}
