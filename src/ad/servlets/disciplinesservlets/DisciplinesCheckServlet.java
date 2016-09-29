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
        PrintWriter w = resp.getWriter();
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
        			if( (req.getParameter("id")==null) || (Integer.parseInt(req.getParameter("id"))!=discipline.getId())){
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
        			if( (req.getParameter("id")==null) || (Integer.parseInt(req.getParameter("id"))!=discipline.getId())){
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
            w.println("<HTML>");
            w.println("<HEAD>");
            w.println("<META http-equiv=\"Content-Type\"");
            w.println("      content=\"text/html; charset=UTF-8\" />");
            w.println("<TITLE>Редактирование дисциплины</TITLE>");
            w.println("</HEAD>");
            w.println("<BODY>");
            w.println("<FORM action=\"check.html\" method=\"post\">");
            if(req.getParameter("id")!=null){
            	w.printf("<INPUT type=\"hidden\" name=\"id\" value=\"%d\">\n", Integer.parseInt(req.getParameter("id")));
            }
            w.println("<P>Название</P>");
            w.printf("<INPUT type=\"text\" name=\"name\" value=\"%s\">\n", name);
            w.println("<P>Сокращенное название</P>");
            w.printf("<INPUT type=\"text\" name=\"shortname\" value=\"%s\">\n",shortname);
            w.println("<P>");
            w.println("<BUTTON type=\"submit\">Сохранить</BUTTON>");
            if(req.getParameter("id")!=null){
            	w.printf("<BUTTON formaction=\"delete.html?id=%s\">Удалить</BUTTON>", req.getParameter("id"));
            }
            w.println("</P>");
            w.println("</FORM>");
            w.println("<P><FORM><BUTTON formaction=\"disciplines.html\">Вернуться назад</BUTTON></FORM></P>");
            w.println("</BODY>");
            w.println("</HTML>");
        }
	}
}
