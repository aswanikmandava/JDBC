package com.kumar.example;

import java.sql.*;

public class DemoPreparedStatement {
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
            String ins_query = "INSERT INTO student VALUES(?, ?, ?)";
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to MySQL server");
            PreparedStatement st = con.prepareStatement(ins_query);
            // set values for prepared statement query at runtime
            st.setInt(1, 103);
            st.setString(2, "Anil Ghorakavi");
            st.setInt(3, 100);
            // execute the insert query
            boolean status = st.execute();
            System.out.println("Dynamic insert query executed");
            con.close();
            System.out.println("Connection is closed");
        }
        catch (SQLException e) {
            System.out.println("Caught DB Error: " + e);
        }
        catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }

    }
}