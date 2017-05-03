package ad.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ad.dao.mysql.Connector;

public class Initializator implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext context = servletContextEvent.getServletContext();
            String jdbcDriver = context.getInitParameter("jdbc-driver");
            String jdbcUrl = context.getInitParameter("jdbc-url");
            String jdbcUser = context.getInitParameter("jdbc-user");
            String jdbcPassword = context.getInitParameter("jdbc-password");
            Connector.init(jdbcDriver, jdbcUrl, jdbcUser, jdbcPassword);
        } catch(ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
