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
    private static final float DELTA = 0.01f;

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

        Ingredient cutlet = Mockito.mock(Ingredient.class);
        Ingredient sauce = Mockito.mock(Ingredient.class);
        Ingredient tomato = Mockito.mock(Ingredient.class);
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

        Assert.assertEquals(810.77f, burger.getPrice(), DELTA);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();

        Mockito.when(mockBun.getName()).thenReturn("Bun");
        Mockito.when(mockBun.getPrice()).thenReturn(123.12f);

        Ingredient cutlet = Mockito.mock(Ingredient.class);
        Ingredient sauce = Mockito.mock(Ingredient.class);
        Ingredient tomato = Mockito.mock(Ingredient.class);

        Mockito.when(cutlet.getName()).thenReturn("Cutlet");
        Mockito.when(cutlet.getPrice()).thenReturn(564.5f);
        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(sauce.getName()).thenReturn("Sauce");
        Mockito.when(sauce.getPrice()).thenReturn(444.4f);
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);

        Mockito.when(tomato.getName()).thenReturn("Tomato");
        Mockito.when(tomato.getPrice()).thenReturn(98.4f);
        Mockito.when(tomato.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(mockBun);
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
