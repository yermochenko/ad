package ad.dao.mysql;

import java.sql.Connection;

abstract public class BasicStorage {
	protected Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}