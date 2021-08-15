package jdt.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database connection. Handles root connection from to the Database.
 *
 * @author Luke Leppan
 */
public class DBConnection {

	private static final String DB_URL = "jdbc:ucanaccess://src/main/resources/jdt/db/jdtdb.accdb";
	private Connection conn;

	/**
	 * Create a DBConnection object
	 */
	public DBConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL);
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Make a database query.
	 *
	 * @param sql The SQL query with ? for the prepared statement.
	 * @param args The data to apply to the prepared statement.
	 *
	 * @return ResultSet created from query.
	 */
	public ResultSet query(String sql, Object[] args) {
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof String) {
					stmt.setString(i + 1, (String) args[i]);
				} else if (args[i] instanceof Integer) {
					stmt.setInt(i + 1, (int) args[i]);
				} else if (args[i] instanceof LocalDate) {
					LocalDate localDate = (LocalDate) args[i];
					stmt.setDate(i + 1, java.sql.Date.valueOf(localDate));
				} else if (args[i] instanceof Boolean) {
					stmt.setBoolean(i + 1, (boolean) args[i]);
				}
			}
			return stmt.executeQuery();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	/**
	 * Make a database update.
	 *
	 * @param sql The SQL update query with ? for the prepared statement.
	 * @param args The data to apply to the prepared statement.
	 *
	 * @return -1 if failure, otherwise count of rows updated.
	 */
	public int update(String sql, Object[] args) {
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof String) {
					stmt.setString(i + 1, (String) args[i]);
				} else if (args[i] instanceof Integer) {
					stmt.setInt(i + 1, (int) args[i]);
				} else if (args[i] instanceof LocalDate) {
					LocalDate localDate = (LocalDate) args[i];
					stmt.setDate(i + 1, java.sql.Date.valueOf(localDate));
				} else if (args[i] instanceof Boolean) {
					stmt.setBoolean(i + 1, (boolean) args[i]);
				}
			}
			return stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
			return -1;
		}
	}

}
