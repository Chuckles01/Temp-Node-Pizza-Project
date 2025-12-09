package org.example;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public boolean login(String username, String password) {
        try{
           Connection connection = DriverManager.getConnection(
                   "jdbc:mysql://47.42.131.112:3306/mealers_choice",
                   "appUser",
                   "password"
           );

           // if username exists and the password matches then logic is successful and the username can be used.
           Statement statement = connection.createStatement();
           String query = "SELECT * FROM user WHERE username = '" + username + "'";
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
            return false;
        }

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
                    "jdbc:mysql://47.42.131.112:3306/mealers_choice",
                    "appUser",
                    "password"
            );

            // if user already exists send a string stating that
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM user WHERE username = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return false;
            }
            else {
                query = "INSERT INTO user (username, password) VALUES ('" + username + "', '" + password + "')";
                statement.executeUpdate(query);
                this.username = username;
                return true;
            }


        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Favorites a recipe for current user either need a successful login or createUser before using this
     * @param recipe_id that is the recipe you want to favorite
     */
    public void addFavorite(int recipe_id) {
        if (this.username == null) {
            return;
        }
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://47.42.131.112:3306/mealers_choice",
                    "appUser",
                    "password"
            );

            // add favorites update
            Statement statement = connection.createStatement();
            String update = "INSERT INTO favorite (username, recipe_id)" +
                    " VALUES ('"+ this.username + "', " + recipe_id + ");";
            statement.executeUpdate(update);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Removes a recipe from a users favorites in the db
     * Must have had a successful login or createUser to run
     * @param recipe_id to remove from favorites
     */
    public void removeFavorite(int recipe_id) {
        if (this.username == null) {
            return;
        }
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://47.42.131.112:3306/mealers_choice",
                    "appUser",
                    "password"
            );

            // add favorites update
            Statement statement = connection.createStatement();
            String update = "DELETE FROM favorite " +
                    "WHERE username = '" + this.username + "' " +
                    "AND recipe_id = " + recipe_id;
            statement.executeUpdate(update);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Return a list of recipe_ids that are favorited by the current user
     *
     * @return
     */
    public List<SearchResult> getFavorites(String username) {
        List<SearchResult> results = new ArrayList<>();
        if (username == null) {
            return null;
        }
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://47.42.131.112:3306/mealers_choice",
                    "appUser",
                    "password"
            );

            // add favorites update
            Statement statement = connection.createStatement();
            String update = "SELECT r.recipe_id, " +
                    "r.recipe_name " +
                    "FROM favorite f " +
                    "JOIN recipe r on f.recipe_id = r.recipe_id " +
                    "WHERE username = '" + username + "' " +
                    ";";
            ResultSet resultSet = statement.executeQuery(update);
            while (resultSet.next()) {
                int id = resultSet.getInt("recipe_id");
                String recipeName = resultSet.getString("recipe_name");
                results.add(new SearchResult(id, recipeName));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return results;
    }
}
