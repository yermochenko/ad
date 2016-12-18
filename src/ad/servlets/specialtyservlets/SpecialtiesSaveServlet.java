package ad.servlets.specialtyservlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
import ad.objects.bean.DisciplineImpl;
import ad.objects.bean.SpecialtyImpl;

public class SpecialtiesSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        DaoContainer container = DaoContainerFactory.create();
        try {
            SpecialtyDao dao = container.getSpecialtyDao();

            String [] sIndex = req.getParameter("select").split(" ");
            SpecialtyImpl specialtyImpl;
            if(sIndex[0]!="") {
                SpecialtyImpl parent = new SpecialtyImpl();
                parent.setId(Integer.valueOf(sIndex[0]));
                specialtyImpl = new SpecialtyImpl(req.getParameter("code"), req.getParameter("name"),
                        req.getParameter("shortName"), req.getParameter("qualification"), req.getParameter("specialtyDirection"), parent);
            }else{
                specialtyImpl = new SpecialtyImpl(req.getParameter("code"), req.getParameter("name"),
                        req.getParameter("shortName"), req.getParameter("qualification"), req.getParameter("specialtyDirection"), null);
            }

            try {
                specialtyImpl.setId(Integer.parseInt(req.getParameter("id")));
            } catch (NumberFormatException e) {
            }
            if(specialtyImpl.getId() == null) {
                try {
                    dao.create(specialtyImpl);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    dao.update(specialtyImpl);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
            resp.sendRedirect(req.getContextPath() + "/specialties.html");
        } catch (DaoException e) {
            throw new ServletException(e);
        }
        finally {
            // TODO: container.close();
        }
    }
}