package org.example;

import java.sql.SQLException;
import java.sql.*;

public class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public boolean login(String username, String password) {
        try{
           Connection connection = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/mealers_choice",
                   "root",
                   "password"
           );

           // if username exists and the password matches then logic is successful and the username can be used.
           Statement statement = connection.createStatement();
           String query = "SELECT * FROM users WHERE username = '" + username + "'";
           ResultSet resultSet = statement.executeQuery(query);
           if (resultSet.next()) {
               String user_password =  resultSet.getString("password");
               if (user_password.equals(password)) {
                   this.username = username; // sets user object to hold username for use in querying favorites
                   return true;
               }
               else return false;
           }
           else return false;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Creates a new user, sets user objects username to given username if successful.
     * @param username used to create new user
     * @param password used to create new user
     * @return false if username already exists true if successfully created new user
     */
    public boolean createUser(String username, String password) {
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mealers_choice",
                    "root",
                    "password"
            );

            // if user already exists send a string stating that
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return false;
            }
            else {
                query = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
                statement.executeUpdate(query);
                this.username = username;
                return true;
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
