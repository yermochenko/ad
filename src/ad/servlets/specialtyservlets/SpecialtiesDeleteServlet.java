package ad.servlets.specialtyservlets;

import ad.Connector;
import ad.dao.mysql.SpecialtyDaoImpl;
import ad.objects.Specialty;
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

            Specialty specialty = sdao.read(Integer.parseInt(req.getParameter("id")));
            if(specialty.getParent()!=null){
                specialty.getParent().deleteChild(specialty);
            }

            for (Specialty object: specialty.getChildren()) {
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