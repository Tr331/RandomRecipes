import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RecipeRepository recipeRepository = new RecipeRepository();
        UserInterface userInterface = new UserInterface(recipeRepository,scanner);

        userInterface.start();
    }
}
