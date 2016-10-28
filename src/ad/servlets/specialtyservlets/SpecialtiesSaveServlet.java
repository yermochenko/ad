package ad.servlets.specialtyservlets;


import ad.Storage;
import ad.objects.Specialty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpecialtiesSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        /*
        * быдло
        * */
        String [] sIndex = req.getParameter("select").split(" ");
        ad.objects.Specialty specialty;
        if(sIndex[0]!="") {
            Specialty parent = Storage.getSpecialtyById(Integer.valueOf(sIndex[0]));
            specialty = new ad.objects.Specialty(req.getParameter("code"), req.getParameter("name"),
                    req.getParameter("shortName"), req.getParameter("qualification"), req.getParameter("specialtyDirection"), parent);
            parent.addChild(specialty);
        }else{
            specialty = new ad.objects.Specialty(req.getParameter("code"), req.getParameter("name"),
                    req.getParameter("shortName"), req.getParameter("qualification"), req.getParameter("specialtyDirection"), null);
        }
        /*
        * быдло
        * */

        try {
            specialty.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(specialty.getId() == null) {
            ad.Storage.createSpecialty(specialty);
        } else {
            ad.Storage.updateSpecialty(specialty);
        }
        resp.sendRedirect(req.getContextPath() + "/specialties.html");
    }
}
