package kata5.mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MailTableApp {

    private Connection connect() {
        Connection conn = null;
        try {
            String database = "jdbc:sqlite:kata5P1.db";
            conn = DriverManager.getConnection(database);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    public void insert(String mail) {
        String sql = "INSERT INTO direcc_email(Mail) VALUES(?)";
        try ( Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mail);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
