package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisciplinesCheckServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
        int correct=0;
        String name=req.getParameter("name");
        String shortname=req.getParameter("shortname");
        Collection<ad.objects.Discipline> disciplines = ad.Storage.getAllDisciplines();
        if(name==null || name.equals("")){
        	correct+=1;
        }
        else{
        	for(ad.objects.Discipline discipline : disciplines){
        		if(name.equalsIgnoreCase(discipline.getName())){
        			if( (req.getParameter("id")==null) || req.getParameter("id").equals("") || (Integer.parseInt(req.getParameter("id"))!=discipline.getId())){
        				correct+=1;
        				break;
        			}
        		}
        	}
        }
        if(shortname==null|| shortname.equals("")){
        	correct+=1;
        }
        else{
        	for(ad.objects.Discipline discipline : disciplines){
        		if(shortname.equalsIgnoreCase(discipline.getShortName())){
        			if( (req.getParameter("id")==null) || req.getParameter("id").equals("") || (Integer.parseInt(req.getParameter("id"))!=discipline.getId())){
        				correct+=1;
        				break;
        			}
        		}
        	}
        }
        if(correct==0){
        	getServletContext().getRequestDispatcher("/save.html")
            .forward(req, resp);
        }
        else{
        	req.setAttribute("check", false);
        	resp.sendRedirect(req.getContextPath() + "/editdiscipline.html");
        }
	}
}
