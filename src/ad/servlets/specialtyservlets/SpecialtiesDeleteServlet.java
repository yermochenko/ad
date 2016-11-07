package ad.servlets.specialtyservlets;

import ad.Storage;
import ad.objects.Specialty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpecialtiesDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try{
            Specialty specialty = Storage.getSpecialtyById(Integer.parseInt(req.getParameter("id")));
            if(specialty.getParent()!=null){
                specialty.getParent().deleteChild(specialty);
            }

            for (Specialty object: specialty.getChildren()) {
                object.setParent(null);
            }

            ad.Storage.deleteSpecialtyById(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        resp.sendRedirect(req.getContextPath() + "/specialties.html");
    }
}