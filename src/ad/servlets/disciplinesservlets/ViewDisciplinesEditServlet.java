package ad.servlets.disciplinesservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDisciplinesEditServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		ad.objects.Discipline discipline=(ad.objects.Discipline)req.getAttribute("discipline");
		resp.setCharacterEncoding("UTF-8");
        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\" />");
        w.println("<TITLE>Редактирование дисциплины</TITLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<FORM action=\"check.html\" method=\"post\">");
        if(discipline!=null){
        	w.printf("<INPUT type=\"hidden\" name=\"id\" value=\"%d\">\n", discipline.getId());
        }
        w.println("<P>Название</P>");
        w.printf("<INPUT type=\"text\" name=\"name\" value=\"%s\">\n",
                discipline != null ? discipline.getName() : new String());
        w.println("<P>Сокращенное название</P>");
        w.printf("<INPUT type=\"text\" name=\"shortname\" value=\"%s\">\n",
                discipline != null ? discipline.getShortName() : new String());
        w.println("<P>");
        w.println("<BUTTON type=\"submit\">Сохранить</BUTTON>");
        if(discipline!=null){
        	w.printf("<BUTTON formaction=\"delete.html?id=%d\">Удалить</BUTTON>", discipline.getId());
        }
        w.println("</P>");
        w.println("</FORM>");
        w.println("<P><FORM><BUTTON formaction=\"disciplines.html\">Вернуться назад</BUTTON></FORM></P>");
        w.println("</BODY>");
        w.println("</HTML>");
	}
}