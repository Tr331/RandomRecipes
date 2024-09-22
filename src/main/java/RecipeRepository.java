import java.util.*;

public class RecipeRepository {

    private HashMap<String, List<String>> recipes;

    public RecipeRepository() {
        this.recipes = new HashMap<>();
    }
    public void addRecipe(String recipeName, List<String> ingredients){
        recipes.put(recipeName, ingredients);
    }
    public HashMap<String, List<String>> getRandomRecipe(){
        Random random = new Random();
        String key = recipes.keySet().stream()
                .skip(random.nextInt(recipes.size()))
                .limit(1)
                .findFirst()
                .orElse(null);

        return new HashMap<>(){{
            put(key,recipes.get(key));
        }};
    }
    public HashMap<String, List<String>> getAllRecipes(){
        return new HashMap<>(recipes);
    }
}
