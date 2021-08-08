package jdt.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private final String dbURL = "jdbc:ucanaccess://src/main/resources/jdt/db/jdtdb.accdb";
    private Connection conn;
    private Statement stmt;

    public DBConnection() {
        try {
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet query(String sql) throws SQLException {
        ResultSet result = stmt.executeQuery(sql);
        return result;
    }

    public int update(String sql) throws SQLException {
        int done = stmt.executeUpdate(sql);
        return done;
    }

}
