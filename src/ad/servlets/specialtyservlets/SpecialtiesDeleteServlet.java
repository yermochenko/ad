package ad.servlets.specialtyservlets;

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

public class SpecialtiesDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try{
            SpecialtyDaoImpl sdao = new SpecialtyDaoImpl();
            Connection c= Connector.getConnection();
            sdao.setConnection(c);

            SpecialtyImpl specialtyImpl = sdao.read(Integer.parseInt(req.getParameter("id")));
            if(specialtyImpl.getParent()!=null){
                specialtyImpl.getParent().deleteChild(specialtyImpl);
            }

            for (SpecialtyImpl object: specialtyImpl.getChildren()) {
                object.setParent(null);
            }

            sdao.delete(Integer.parseInt(req.getParameter("id")));
            c.close();
        } catch(NumberFormatException e) {} catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/specialties.html");
    }
}