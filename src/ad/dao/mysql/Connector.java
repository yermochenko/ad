package ad.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static String jdbcUrl = null;
    private static String jdbcUser = null;
    private static String jdbcPassword = null;

    public static void init(String jdbcDriver, String jdbcUrl, String jdbcUser, String jdbcPassword) throws ClassNotFoundException {
        Class.forName(jdbcDriver);
        Connector.jdbcUrl = jdbcUrl;
        Connector.jdbcUser = jdbcUser;
        Connector.jdbcPassword = jdbcPassword;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
    }
}
