package ad.servlets.specialtyservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.DaoContainer;
import ad.dao.DaoContainerFactory;
import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.domain.bean.SpecialtyImpl;

public class SpecialtiesSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        DaoContainer container = DaoContainerFactory.create();
        try {
            SpecialtyDao dao = container.getSpecialtyDao();

            String[] sIndex = req.getParameter("select").split(" ");
            SpecialtyImpl specialtyImpl = new SpecialtyImpl();
            specialtyImpl.setCode(req.getParameter("code"));
            specialtyImpl.setName(req.getParameter("name"));
            specialtyImpl.setShortName(req.getParameter("shortName"));
            specialtyImpl.setQualification(req.getParameter("qualification"));
            specialtyImpl.setSpecialtyDirection(req.getParameter("specialtyDirection"));
            if(!sIndex[0].isEmpty()) {
                SpecialtyImpl parent = new SpecialtyImpl();
                parent.setId(Integer.valueOf(sIndex[0]));
                specialtyImpl.setParent(parent);
            }

            try {
                specialtyImpl.setId(Integer.parseInt(req.getParameter("id")));
            } catch(NumberFormatException e) {}
            if(specialtyImpl.getId() == null) {
                try {
                    dao.create(specialtyImpl);
                } catch(DaoException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    dao.update(specialtyImpl);
                } catch(DaoException e) {
                    e.printStackTrace();
                }
            }
            resp.sendRedirect(req.getContextPath() + "/specialties.html");
        } catch(DaoException e) {
            throw new ServletException(e);
        } finally {
            // TODO: container.close();
        }
    }
}
