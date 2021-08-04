package webapp.techstore;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@RequestScoped
public class jdbcConfig {
    Connection connection;

    public jdbcConfig() {
        try {
            connection = DataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAll() {
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from demo");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

