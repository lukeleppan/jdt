package jdt.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

	private static final String DB_URL = "jdbc:ucanaccess://src/main/resources/jdt/db/jdtdb.accdb";
	private Connection conn;

	public DBConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL);
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public ResultSet query(String sql, String[] args) {
		try (PreparedStatement stmt = conn.prepareStatement(sql, args)) {
			return stmt.executeQuery();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public int update(String sql, String[] args) {
		try (PreparedStatement stmt = conn.prepareStatement(sql, args)) {
			return stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
			return -1;
		}
	}

}
