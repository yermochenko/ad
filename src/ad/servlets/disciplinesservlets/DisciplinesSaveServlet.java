package ad.servlets.disciplinesservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisciplinesSaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ad.objects.Discipline discipline=new ad.objects.Discipline(req.getParameter("name"),req.getParameter("shortname"));
		try {
            discipline.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
		if(discipline.getId() == null) {
            ad.Storage.createDiscipline(discipline);
        } else {
            ad.Storage.updateDiscipline(discipline);
        }
		resp.sendRedirect(req.getContextPath() + "/disciplines.html");
	}
}
