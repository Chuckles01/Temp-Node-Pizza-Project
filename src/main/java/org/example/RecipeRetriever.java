package org.example;

import java.sql.SQLException;
import java.sql.*;

public class RecipeRetriever {
    public String getRecipe(int recipe_id) {
        String recipe_string = "";

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://47.42.131.112:3306/mealers_choice",
                    "appUser",
                    "password"
            );

            // query to get recipe_lines in order
            Statement statement = connection.createStatement();
            String query = "SELECT line" +
                    " FROM recipe_line" +
                    " WHERE recipe_id = " + recipe_id +
                    " ORDER BY recipe_line" +
                    ";";

            ResultSet resultSet = statement.executeQuery(query);

            // constructs a single string from the retrieved lines
            while (resultSet.next()) {
                recipe_string = resultSet.getString("line");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return recipe_string;
    }
}
