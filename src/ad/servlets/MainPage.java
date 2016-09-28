package ad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\"/>");
        w.println("<TITLE>Документооборот кафедры</TITLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<CENTER><FORM>");
        w.println("<BUTTON formaction=\"disciplines.html\">Дисциплины</BUTTON>");
        w.println("<BUTTON formaction=\"curriculumdisciplines.html\">Дисциплины учебных планов</BUTTON>");
        w.println("<BUTTON formaction=\"specialties.html\">Специальности</BUTTON>");
        w.println("<BUTTON formaction=\"curriculums.html\">Учебные планы</BUTTON>");
        w.println("</FORM></CENTER>");
        w.println("</BODY>");
        w.println("</HTML>");
	}
}