package ad.servlets.specialtyservlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.dao.DaoContainer;
import ad.dao.DaoContainerFactory;
import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.domain.Specialty;

public class SpecialtiesEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DaoContainer container = DaoContainerFactory.create();
        try {
            SpecialtyDao dao = container.getSpecialtyDao();
            try{
                Specialty specialty = null;
                if (req.getParameter("check") == null || req.getParameter("check").equals("")) {
                    Integer id = Integer.parseInt(req.getParameter("id"));
                    specialty = dao.read(id);
                    req.setAttribute("specialtyImpl", specialty);
                }

                Collection<Specialty> specialities = dao.readAll();
                ArrayList<Specialty> arrSpec = new ArrayList<>();
                for (Specialty s: specialities) {
                    if(s!=null && specialty!=null){
                        if(s.getParent()!=null){
                            if(s.getParent().getId()!=specialty.getId()){
                                if(s.getId() != specialty.getId()) {
                                    if(specialty.getParent()!=null){
                                        if(specialty.getParent().getId()!=s.getId()){
                                            arrSpec.add(s);
                                        }
                                    }else{
                                        arrSpec.add(s);
                                    }
                                }
                            }
                        }else{
                            if(s.getId() != specialty.getId()){
                                if(specialty.getParent()!=null) {
                                    if (specialty.getParent().getId() != s.getId()) {
                                        arrSpec.add(s);
                                    }
                                }else{
                                    arrSpec.add(s);
                                }

                            }
                        }
                    }

                }

                req.setAttribute("specialties", arrSpec);
            }catch (NumberFormatException e) {
                Collection<Specialty> specialities = dao.readAll();
                req.setAttribute("specialties", specialities);
            }

        } catch (DaoException e) {
            throw new ServletException(e);
        }finally {
            // TODO: container.close();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/editspecialities.jsp").forward(req, resp);
    }
}

