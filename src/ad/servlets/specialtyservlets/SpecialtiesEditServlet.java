package ad.servlets.specialtyservlets;

import ad.Storage;
import ad.objects.Specialty;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialtiesEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("check") == null || req.getParameter("check").equals("")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                ad.objects.Specialty specialty = Storage.getSpecialtyById(id);
                req.setAttribute("specialty", specialty);

            }
        } catch (NumberFormatException e) {
        }
        Collection<Specialty> specialities=ad.Storage.getAllSpecialties();
        req.setAttribute("specialties", specialities);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editspecialities.jsp").forward(req, resp);
    }
}
