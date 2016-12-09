package ad.servlets.specialtyservlets;


import ad.dao.exception.DaoException;
import ad.dao.mysql.Connector;
import ad.dao.mysql.SpecialtyDaoImpl;
import ad.objects.bean.SpecialtyImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SpecialtiesSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        SpecialtyDaoImpl sdao = new SpecialtyDaoImpl();
        Connection c= null;
        try {
            c = Connector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sdao.setConnection(c);
        /*
        * быдло
        * */
        String [] sIndex = req.getParameter("select").split(" ");
        SpecialtyImpl specialtyImpl;
        if(sIndex[0]!="") {
            SpecialtyImpl parent = new SpecialtyImpl();
            parent.setId(Integer.valueOf(sIndex[0]));
            specialtyImpl = new SpecialtyImpl(req.getParameter("code"), req.getParameter("name"),
                    req.getParameter("shortName"), req.getParameter("qualification"), req.getParameter("specialtyDirection"), parent);
           // specialtyImpl.setParentId(parent.getId());
           // parent.addChild(specialtyImpl);
        }else{
            specialtyImpl = new SpecialtyImpl(req.getParameter("code"), req.getParameter("name"),
                    req.getParameter("shortName"), req.getParameter("qualification"), req.getParameter("specialtyDirection"), null);
        }
        /*
        * быдло
        * */

        try {
            specialtyImpl.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(specialtyImpl.getId() == null) {
            try {
                sdao.create(specialtyImpl);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } else {
            try {
                sdao.update(specialtyImpl);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect(req.getContextPath() + "/specialties.html");
    }
}