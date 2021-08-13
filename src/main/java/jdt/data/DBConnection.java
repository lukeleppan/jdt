package jdt.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
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
				}
			}
			return stmt.executeQuery();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

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
				}
			}
			return stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
			return -1;
		}
	}

}
