package ad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.Storage;

public class MainPage extends HttpServlet {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/ad?useUnicode=true&characterEncoding=UTF-8";
	public static final String USER = "root";
	public static final String PASSWORD = "";

	@Override
	public void init() throws ServletException {
		try {
			Class.forName(DRIVER);
			Storage.init(DRIVER, URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}
}