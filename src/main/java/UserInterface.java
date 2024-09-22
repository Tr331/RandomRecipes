import java.util.*;

public class UserInterface {

    private RecipeRepository recipeRepository;
    private Scanner scanner;

    public UserInterface(RecipeRepository recipeRepository, Scanner scanner){
        this.recipeRepository = recipeRepository;
        this.scanner = scanner;
    }
    public void start(){

        while (true) {
            displayMenu();
            String options = scanner.nextLine();

            if (options.equals("4")) {
                break;
            }
            processOptions(options);
        }

    }

    public void displayMenu(){
        System.out.println("\n" + "=".repeat(40));
        System.out.println("🍽️  Welcome to the Recipe Manager  🍽️");
        System.out.println("=".repeat(40));
        System.out.println("1. 📝 Add a recipe");
        System.out.println("2. 🎲 Get a random recipe");
        System.out.println("3. 📚 Show all recipes");
        System.out.println("4. 🚪 Exit");
        System.out.println("-".repeat(40));
        System.out.print("Enter your choice (1-4): ");
    }

    public void processOptions(String options){

        switch (options){
            case "1":
                addRecipe();
                break;

            case "2":
                getRandomRecipe();
                break;

            case "3":
                getAllRecipes();
                break;

            default:
                System.out.println("❌ Invalid option. Please try again.");
        }
    }

    public void addRecipe(){
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📝 Add a New Recipe");

        System.out.println("=".repeat(40));
        System.out.print("Recipe Name: ");

        String recipeName = scanner.nextLine();

        System.out.println("Ingredients (enter an empty line to finish):");

        List<String> ingredients = new ArrayList<>();

        String ingredient = scanner.nextLine();

        while (!ingredient.isEmpty()) {
            ingredients.add(ingredient);
            ingredient = scanner.nextLine();
        }

        recipeRepository.addRecipe(recipeName, ingredients);
        System.out.println("✅ Recipe added successfully!");
    }

    public void getRandomRecipe(){
        System.out.println("\n" + "=".repeat(40));
        System.out.println("🎲 Random Recipe");
        System.out.println("=".repeat(40));

        HashMap<String, List<String>> randomRecipe = recipeRepository.getRandomRecipe();

        System.out.println("🍽️ Here's a random recipe for you:");

        if (!randomRecipe.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : randomRecipe.entrySet()) {
                System.out.println("🍳 " + entry.getKey());
                printRecipe(entry.getValue());
                System.out.println("-".repeat(40));
            }
        } else {
            System.out.println("❌ No recipes available.");
        }
    }

    private void getAllRecipes() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📚 All Recipes");
        System.out.println("=".repeat(40));

        Map<String, List<String>> allRecipes = recipeRepository.getAllRecipes();
        if (!allRecipes.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : allRecipes.entrySet()) {
                System.out.println("🍳 " + entry.getKey());
                printRecipe(entry.getValue());
                System.out.println("-".repeat(40));
            }
        } else {
            System.out.println("❌ No recipes available.");
        }
    }

    private void printRecipe(List<String> ingredients) {
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println("  • " + ingredient);
        }
    }
}
