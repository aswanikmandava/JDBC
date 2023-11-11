package com.kumar.example;
import com.mysql.jdbc.Driver;

import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) {
        try {
            // load and register driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create connection
            // url syntax - jdbc:<db_type>:<network_path_to_db>
            //              jdbc:<db_type>://<host>:<port>/<db_name>
            String url = "jdbc:mysql://localhost:3306/demo";
            String username = "dummy_user";
            String password = "dummy_pwd";
            String query = "SELECT * FROM student";
            String ins_query = "INSERT INTO student VALUES(102, 'Hello User', 90)";
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to MySQL server");
            Statement st = con.createStatement();
            // execute the insert query
            boolean status = st.execute(ins_query);
            System.out.println("Insert query executed. Running Select query ...");
            ResultSet rs = st.executeQuery(query);
            // collect query results
            System.out.println("Fetching the results ...");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("sid") +
                        ", Name: " + rs.getString("name") +
                        "Marks: " + rs.getInt("marks"));
            }
            con.close();
            System.out.println("Connection is closed");
        }
        catch (java.sql.SQLException e) {
            System.out.println("Caught DB Error: " + e);
        }
        catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }

    }
}