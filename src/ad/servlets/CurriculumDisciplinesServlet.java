package ad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurriculumDisciplinesServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\"/>");
        w.println("<TITLE>Дисциплины учебного плана</TITLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<P>CurriculumDisciplinesPage...</P>");
        w.println("<FORM><BUTTON formaction=\"index.html\">Вернуться на главную страницу</BUTTON></FORM>");
        w.println("</BODY>");
        w.println("</HTML>");
    }
}
