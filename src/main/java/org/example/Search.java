package org.example;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Search {
    private Flavor flavor;
    private Texture texture;
    private Type type;
    private Time time;
    private List<Allergen> allergens =  new ArrayList<Allergen>();

    public Search(Flavor flavor, Texture texture, Type type, Time time, List<Allergen> allergens) {
        this.flavor = flavor;
        this.texture = texture;
        this.type = type;
        this.time = time;
        this.allergens = allergens;
    }

    public  List<SearchResult> runSearch() {
        List<SearchResult> results = new ArrayList<>();

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mealers_choice",
                    "root",
                    "password"
            );

            Statement statement = connection.createStatement();
            String query = "SELECT r.recipe_id, r.recipe_name" +
                    " FROM recipe r"+
                    " WHERE";

            // construct the rest of the where statement
            if (flavor != null) query += " r.flavor = '" + flavor.getFlavor() + "' AND";
            if (texture != null) query += " r.texture = '" + texture.getTexture() + "' AND";
            if (type != null) query += " r.type = '" + type.getType() + "' AND";
            if (time != null) query += " r.time = '" + time.getTime() +"'";
            else {
                // ending of query has AND if time is not a search condition
                query = query.substring(0, query.length() - 4) + "'";
            }

            // subquery for common_allergens associative table (or condition so any allergen is caught)
            if (!allergens.isEmpty()) {
                query += " AND r.recipe_id NOT IN (" +
                        " SELECT a.recipe_id" +
                        " FROM common_allergen a" +
                        " WHERE";
                for (int i = 0; i < allergens.size() - 1; i++) {
                    query += " a.common_allergen = '" + allergens.get(i).getAllergen() + "' OR";
                }
                query += " a.common_allergen = '" + allergens.get(allergens.size() - 1).getAllergen() + "')";
            }
            query += ";";

            ResultSet resultSet = statement.executeQuery(query);

            // extract needed info from resultSet into the format we are using (Our own type SearchResult)
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

// special enums that match sql enum names with their string data
    public enum Flavor {
        salty("salty"),
        sour("sour"),
        sweet("sweet"),
        bitter("bitter"),
        savory("savory");

        private final String flavor;

        Flavor(String flavor) {
            this.flavor = flavor;
        }

        public String getFlavor() {
            return this.flavor;
        }
    }

    public enum Texture {
        crumbly("crumbly"),
        soft("soft"),
        creamy("creamy"),
        tender("tender"),
        chewy("chewy"),
        crispy("crispy"),
        moist("moist"),
        dry("dry"),
        flakey("flakey"),
        gooey("gooey");

        private final String texture;

        Texture(String texture) {
            this.texture = texture;
        }

        public String getTexture() {
            return this.texture;
        }
    }

    public enum Type {
        breakfast("breakfast"),
        lunch("lunch"),
        dinner("dinner"),
        appatezier("appatezier"),
        dessert("dessert"),
        snack("snack");

        private final String type;
        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public enum Time {
        min15("15min"),
        min30("30min"),
        min45("45min"),
        hr1("1hr"),
        hr1min15("1hr15min"),
        hr1min30("1hr30min"),
        hr1min45("1hr45min"),
        hr2("2hr"),
        hr2plus("2hr+");

        private final String time;
        Time(String time) {
            this.time = time;
        }

        public String getTime() {
            return this.time;
        }
    }

    public enum Allergen {
        milk("milk"),
        eggs("eggs"),
        fish("fish"),
        tree_nuts("tree nuts"),
        peanuts("peanuts"),
        wheat("wheat"),
        soy("soy"),
        shellfish("shellfish"),
        sesame("sesame");

        private final String allergen;
        Allergen(String allergen) {
            this.allergen = allergen;
        }

        public String getAllergen() {
            return this.allergen;
        }
    }
}