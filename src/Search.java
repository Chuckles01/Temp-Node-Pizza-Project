import java.util.ArrayList;
import java.util.List;

public class Search {

    private String flavor;
    private String texture;
    private String type;
    private String time;
    private String allergens;

    private List<Recipe> result;

    public Search() {
        result = new ArrayList<>();
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    // Getters
    public String getFlavor() {
        return flavor;
    }

    public String getTexture() {
        return texture;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public String getAllergens() {
        return allergens;
    }

    public List<Recipe> getResult() {
        return result;
    }

    public List<Recipe> search(List<Recipe> allRecipes) {
        result.clear();

        for (Recipe recipe : allRecipes) {
            boolean match = true;

            if (flavor != null && !flavor.equalsIgnoreCase(recipe.getFlavor())) {
                match = false;
            }
            if (texture != null && !texture.equalsIgnoreCase(recipe.getTexture())) {
                match = false;
            }
            if (type != null && !type.equalsIgnoreCase(recipe.getType())) {
                match = false;
            }
            if (time != null && !time.equalsIgnoreCase(recipe.getTime())) {
                match = false;
            }
            if (allergens != null && allergens.equalsIgnoreCase(recipe.getAllergens())) {
                match = false;
            }

            if (match) {
                result.add(recipe);
            }
        }

        return result;
    }
}