package ad.servlets.specialtyservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.exception.DaoException;
import ad.dao.mysql.Connector;
import ad.dao.mysql.SpecialtyDaoImpl;
import ad.domain.bean.SpecialtyImpl;

/**
 * Created by HomeInc on 28.10.2016.
 */
/*
* Пока не используется
* */
public class SpecialtiesViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SpecialtyDaoImpl sdao = new SpecialtyDaoImpl();
            Connection c= Connector.getConnection();
            sdao.setConnection(c);
            if (req.getParameter("check") == null || req.getParameter("check").equals("")) {
                Integer id = Integer.parseInt(req.getParameter("id"));
                SpecialtyImpl specialtyImpl = (SpecialtyImpl) sdao.read(id);
                req.setAttribute("specialtyImpl", specialtyImpl);
            }
            c.close();
        } catch (NumberFormatException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/viewSpecialities.jsp").forward(req, resp);
    }
}