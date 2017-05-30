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
import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.domain.Discipline;
import ad.domain.Specialty;
import ad.domain.factory.exception.EntityCreateException;

public class SpecialtyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoContainer container = (DaoContainer) req.getAttribute("dao-container");

		System.out.println("\n\n" + "GET SPECIALTY2");


		try {
			SpecialtyDao dao = container.getSpecialtyDao();
			resp.setCharacterEncoding("UTF-8");

			String stringId = req.getParameter("id");

			if (stringId == null || stringId.isEmpty()) {
				List<Specialty> specialties = dao.readAll();
				new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValue(resp.getOutputStream(),
						specialties);
			} else {
				Integer id = Integer.parseInt(stringId);
				Specialty specialty = dao.read(id);
				new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValue(resp.getOutputStream(),
						specialty);
			}
		} catch (NumberFormatException e) {
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoContainer container = (DaoContainer) req.getAttribute("dao-container");
		try {
			Specialty specialty = new ObjectMapper().readValue(req.getReader(),
					container.getSpecialtyFactory().create().getClass());
			SpecialtyDao dao = container.getSpecialtyDao();
			if (specialty.getId() == null) {
				dao.create(specialty);
				resp.setStatus(201);
			} else {
				dao.update(specialty);
				resp.setStatus(200);
			}
		} catch (EntityCreateException | DaoException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoContainer container = (DaoContainer) req.getAttribute("dao-container");
		try {
			Integer id = Integer.parseInt(req.getParameter("id"));
			SpecialtyDao dao = container.getSpecialtyDao();
			dao.delete(id);
		} catch (NumberFormatException e) {
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}
}
