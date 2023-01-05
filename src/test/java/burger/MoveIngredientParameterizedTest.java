package burger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class MoveIngredientParameterizedTest {

    private final int index;
    private final int newIndex;

    public MoveIngredientParameterizedTest(int index, int newIndex) {
        this.index = index;
        this.newIndex = newIndex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestIndex() {
        return new Object[][]{
                {-1, -2},
                {-1, 1},
                {-1, 3},
                {1, -1},
                {1, 3},
                {3, -1},
                {3, 1},
                {3, 4}
        };
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "Cutlet", 564.5f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Sauce", 444.4f);
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Tomato", 98.4f);
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(tomato);
        burger.moveIngredient(index,newIndex);
    }


}
