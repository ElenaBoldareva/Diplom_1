import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngredient;

    @Test
    public void testSetBuns() {
        Bun bun = new Bun("Bun", 123.12f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "Cutlet", 564.5f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Sauce", 444.4f);
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Tomato", 98.4f);
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(tomato);
        Assert.assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "Cutlet", 564.5f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Sauce", 444.4f);
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Tomato", 98.4f);
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(tomato);
        burger.removeIngredient(1);
        Assert.assertFalse(burger.ingredients.contains(sauce));
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "Cutlet", 564.5f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Sauce", 444.4f);
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Tomato", 98.4f);
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(tomato);
        burger.moveIngredient(1, 2);
        Assert.assertEquals(2, burger.ingredients.indexOf(sauce));
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        Mockito.when(mockBun.getPrice()).thenReturn(123.12f);
        Mockito.when(mockIngredient.getPrice()).thenReturn(564.53f);

        Assert.assertEquals(810.77f, burger.getPrice(), 0.01f);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        Bun bun = new Bun("Bun", 123.12f);
        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "Cutlet", 564.5f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Sauce", 444.4f);
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Tomato", 98.4f);
        burger.setBuns(bun);
        burger.addIngredient(cutlet);
        burger.addIngredient(sauce);
        burger.addIngredient(tomato);

        String receipt = "(==== Bun ====)\r\n" +
                "= filling Cutlet =\r\n" +
                "= sauce Sauce =\r\n" +
                "= filling Tomato =\r\n" +
                "(==== Bun ====)\r\n" +
                "\r\nPrice: 1353,540039\r\n";
        Assert.assertEquals(receipt, burger.getReceipt());
    }
}
