package ad.servlets;

import ad.dao.mysql.Connector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by HomeInc on 25.11.2016.
 */
public class Initializator implements ServletContextListener  {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/ad?useUnicode=true&characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            Class.forName(DRIVER);
            Connector.init(DRIVER, URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
