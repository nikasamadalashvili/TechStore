package webapp.techstore;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@RequestScoped
public class jdbcConfig {


    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Properties properties;
        try {
            properties = PropertyReader.getProperties();
            Class.forName(properties.getProperty("datasource.jdbc.driver-class-name"));
            Connection con= DriverManager.getConnection(
                    properties.getProperty("datasource.jdbc.url"),
                    properties.getProperty("datasource.jdbc.username"),
                    properties.getProperty("datasource.jdbc.password"));
            return con;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

