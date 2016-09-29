package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDisciplinesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		@SuppressWarnings("unchecked")
		Collection <ad.objects.Discipline> disciplines=(Collection <ad.objects.Discipline>)req.getAttribute("disciplines");
		resp.setCharacterEncoding("UTF-8");
        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\"/>");
        w.println("<TITLE>Дисциплины</TITLE>");
        w.println("<STYLE>");
        w.println("TABLE {");
        w.println("border-collapse: collapse;");
        w.println("}");
        w.println("TH, TD {");
        w.println("border: 1px solid black;");
        w.println("padding: 5px 5px 5px 5px;");
        w.println("}");
        w.println("</STYLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<FORM  action=\"edit.html\" method=\"post\">");
        if(!disciplines.isEmpty()){
        	w.println("<CENTER>");
        	w.println("<TABLE>");
        	w.println("<TR><TH>ID</TH><TH>Название</TH><TH>Сокращенное название</TH></TR>");
        	for(ad.objects.Discipline discipline : disciplines){
        		w.print("<TR>");
        		w.printf("<TD><CENTER><A href=\"edit.html?id=%d\">%d</A></CENTER></TD>", discipline.getId(), discipline.getId());
        		w.printf("<TD><CENTER>%s</CENTER></TD>", discipline.getName());
        		w.printf("<TD><CENTER>%s</CENTER></TD>", discipline.getShortName());
        		w.print("</TR>");
        	}
        	w.println("</TABLE>");
        	w.println("</CENTER>");
        }
        else{
        	w.println("<P>Список дисциплин пока пуст.</P>");
        }
        w.println("</FORM>");
        w.println("<CENTER>");
        w.println("<P>");
        w.println("<FORM>");
        w.println("<BUTTON formaction=\"edit.html\">Добавить</BUTTON>");
        w.println("<BUTTON formaction=\"index.html\">Вернуться на главную страницу</BUTTON>");
        w.println("</FORM>");
        w.println("</P>");
        w.println("</CENTER>");
        w.println("</BODY>");
        w.println("</HTML>");
	}
}