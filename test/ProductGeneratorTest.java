import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductGeneratorTest {

    ProductGenerator P1, P2, P3;


    @BeforeEach
    void setUp() {

        P1 = new ProductGenerator("Coca-Cola", "SoftDrink", 2.99);
        P2 = new ProductGenerator("Sprite", "SoftDrink", 2.99);
        P3 = new ProductGenerator("Mountain Dew", "SoftDrink", 2.99);

    }

    @Test
    void setName() {

        P1.setName("Root Beer");
        assertEquals("Root Beer", P1.getName());
    }

    @Test
    void setDescription() {

        P1.setDescription("AnnoyingDrink");
        assertEquals("AnnoyingDrink", P1.getDescription());

    }

    @Test
    void setCost() {

        P1.setCost(1.99);
        assertEquals(1.99, P1.getCost());

    }

    @Test
    void fullDesc() {

        P1.setName("Limca");
        P1.setDescription("Drink");
        P1.setCost(3.99);

        assertEquals("Limca" + " " + "Drink" + " " + 3.99 , P1.getName() + " " + P1.getDescription() + " " + P1.getCost());

    }
}