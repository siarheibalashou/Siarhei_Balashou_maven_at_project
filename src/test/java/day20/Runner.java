package day20;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Runner {
    ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        Runner runner = new Runner();
        runner.toJson();
        runner.fromJson();
    }

    public void toJson() throws IOException {
        Recipe recipe = new Recipe("Salad", Arrays.asList(new Ingredient("Tomatossssssssssss", 121212), new Ingredient("Cucumber", 1)), 3);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/recipe2221.json"), recipe);

        //  String stringg = objectMapper.writeValueAsString(recipe);
    }

    public void fromJson() throws IOException {
        Recipe recipe = objectMapper
                .readValue(new File("src/test/resources/recipe.json"), Recipe.class);
        System.out.println(recipe);
    }
}
