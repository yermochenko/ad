package ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static final String jdbcUrl = "jdbc:mysql://localhost/ad?useUnicode=true&characterEncoding=UTF-8";
	public static final String jdbcUser = "root";
	public static final String jdbcPassword = "";
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
	}
}
