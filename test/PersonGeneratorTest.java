import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonGeneratorTest {

    PersonGenerator P1, P2, P3;

    @BeforeEach
    void setUp() {

        P1 = new PersonGenerator("000001", "Tom", "Billings", "Mr", 1976);
        P2 = new PersonGenerator("000002", "Selena", "Gomez", "Ms", 1999);
        P3 = new PersonGenerator("000003", "Betty", "Hawkins", "Ms", 1998);
    }

    @Test
    void setID() {

        P1.setID("000006");
        assertEquals("000006", P1.getID());

    }

    @Test
    void setFirstName() {

        P1.setFirstName("TestFirstNameP1");
        assertEquals("TestFirstNameP1", P1.getFirstName());

    }

    @Test
    void setLastName() {

        P1.setLastName("TestLastNameP1");
        assertEquals("TestLastNameP1", P1.getLastName());

    }

    @Test
    void setTitle() {

        P1.setTitle("TestTitle");
        assertEquals("TestTitle", P1.getTitle());

    }

    @Test
    void setYearOfBirth() {

        P1.setYearOfBirth(2005);
        assertEquals(2005, P1.getYearOfBirth());

    }

    @Test
    void fullName() {

        P1.setFirstName("Tanya");
        P1.setLastName("James");

        assertEquals("Tanya" + " " + "James", P1.getFirstName() + " " + P1.getLastName());

    }

    @Test
    void formalName() {

        P1.setTitle("Mrs");
        P1.setFirstName("Shaurya");
        P1.setLastName("Kumar");

        assertEquals("Mrs" + " " + "Shaurya" + " " + "Kumar", P1.getTitle() + " " + P1.getFirstName() + " " + P1.getLastName());

    }

    @Test
    void getAge() {

        P1.setYearOfBirth(2010);

        assertEquals(2010, P1.getYearOfBirth());

    }
}