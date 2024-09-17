import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private static final float DELTA = 0.01f;

    @Test
    public void createBunTest(){
        String nameBun = "Bunny";
        float priceBun = 111.45f;

        Bun bun = new Bun(nameBun, priceBun);
        Assert.assertEquals(nameBun, bun.name);
        Assert.assertEquals(priceBun, bun.price, DELTA);
    }

    @Test
    public void getNameTest(){
        String nameBun = "Bunny";
        float priceBun = 111.45f;

        Bun bun = new Bun(nameBun, priceBun);
        Assert.assertEquals(nameBun, bun.getName());
    }

    @Test
    public void getPriceTest(){
        String nameBun = "Bunny";
        float priceBun = 111.45f;

        Bun bun = new Bun(nameBun, priceBun);
        Assert.assertEquals(priceBun, bun.getPrice(), DELTA);
    }
}
