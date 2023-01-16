import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private static final float DELTA = 0.01f;

    @Test
    public void createIngredientTest(){

        String nameIngredient = "Sauce";
        float priceIngredient = 191.01f;
        IngredientType type = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(type, nameIngredient, priceIngredient);
        Assert.assertEquals(nameIngredient, ingredient.name);
        Assert.assertEquals(priceIngredient, ingredient.price, DELTA);
        Assert.assertEquals(type, ingredient.type);
    }

    @Test
    public void getNameTest(){
        String nameIngredient = "Sauce";
        float priceIngredient = 191.01f;
        IngredientType type = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(type, nameIngredient, priceIngredient);
        Assert.assertEquals(nameIngredient, ingredient.getName());
    }

    @Test
    public void getPriceTest(){
        String nameIngredient = "Sauce";
        float priceIngredient = 191.01f;
        IngredientType type = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(type, nameIngredient, priceIngredient);
        Assert.assertEquals(priceIngredient, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getTypeTest(){
        String nameIngredient = "Sauce";
        float priceIngredient = 191.01f;
        IngredientType type = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(type, nameIngredient, priceIngredient);
        Assert.assertEquals(type, ingredient.getType());
    }
}
