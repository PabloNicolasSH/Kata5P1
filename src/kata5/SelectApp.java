package kata5;

import java.sql.*;

public class SelectApp {

    private Connection connect() {
        Connection conn = null;
        try {
            String ruta = "jdbc:sqlite:kata5P1.db";
            conn = DriverManager.getConnection(ruta);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE")) {

            while (rs.next()){
                System.out.println(rs.getInt("ID") + "\t" +
                        rs.getString("NAME").trim() + "\t" +
                        rs.getString("APELLIDOS").trim() + "\t" +
                        rs.getString("DEPARTAMENTO").trim() + "\t" );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
