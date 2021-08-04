package webapp.techstore;

import javax.enterprise.context.RequestScoped;
import java.sql.*;

@RequestScoped
public class jdbcConfig {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test","sopochokheli","Tantalikovol1!");
        return con;
    }

    public void getAll() {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from demo");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2));
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

