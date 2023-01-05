package burger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class RemoveIngredientParameterizedTest {

    private final int index;

    public RemoveIngredientParameterizedTest(int index) {
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getTestIndex() {
        return new Object[][]{
                {-1},
                {3}
        };
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "Cutlet", 564.5f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Sauce", 444.4f);
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Tomato", 98.4f);
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(tomato);
        burger.removeIngredient(index);
    }


}
