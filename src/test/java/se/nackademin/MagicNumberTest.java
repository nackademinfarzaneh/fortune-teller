package se.nackademin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MagicNumberTest {
    private MagicNumbers generateTestData() {
        MagicNumbers magicNumbers = new MagicNumbers();
        magicNumbers.setAge(16);
        magicNumbers.setHeight(165);
        magicNumbers.setIncome(11000);
        magicNumbers.setLocation("Hagfors");
        magicNumbers.setName("Sture Hagfors");
        return magicNumbers;
    }

    @Test
    public void testA() {
        MagicNumbers magicNumbers = generateTestData();
        assertEquals("A is not calculated correctly", 4, magicNumbers.calculateA());
    }

    @Test
    public void testB() {
        MagicNumbers magicNumbers = generateTestData();
        assertEquals("B is not calculated correctly", 3, magicNumbers.calculateB());
    }

    @Test
    public void testC() {
        MagicNumbers magicNumbers = generateTestData();
        assertEquals("C is not calculated correctly", 2, magicNumbers.calculateC());
    }

    @Test
    public void testD() {
        MagicNumbers magicNumbers = generateTestData();
        assertEquals("D is not calculated correctly", 6, magicNumbers.calculateD());
    }
    @Test
    public void testDWithAGreaterThan5() {
        MagicNumbers magicNumbers = generateTestData();
        magicNumbers.setAge(18);
        assertEquals("D is not calculated correctly", 9, magicNumbers.calculateD());
    }

    @Test
    public void testE() {
        MagicNumbers magicNumbers = generateTestData();
        assertEquals("E is not calculated correctly", 9, magicNumbers.calculateE());
    }

    @Test
    public void testADependsOnName() {
        MagicNumbers magicNumbers = generateTestData();
        int first = magicNumbers.calculateA();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different names", first, second);
    }

    @Test
    public void testADependsOnAge() {
        MagicNumbers magicNumbers = generateTestData();
        int first = magicNumbers.calculateA();
        magicNumbers.setAge(18);
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different ages", first, second);
    }

    @Test
    public void testBDependsOnLocation() {
        MagicNumbers magicNumbers = generateTestData();
        int first = magicNumbers.calculateB();
        magicNumbers.setLocation("Grytevik");
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different locations", first, second);
    }

    @Test
    public void testBDependsOnIncome() {
        MagicNumbers magicNumbers = generateTestData();
        int first = magicNumbers.calculateB();
        magicNumbers.setIncome(219487);
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different income values", first, second);
    }

    @Test
    public void testCDependsOnHeight() {
        MagicNumbers magicNumbers = generateTestData();
        int first = magicNumbers.calculateC();
        magicNumbers.setHeight(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different heights", first, second);
    }

    @Test
    public void testCDependsOnAge() {
        MagicNumbers magicNumbers = generateTestData();
        int first = magicNumbers.calculateC();
        magicNumbers.setAge(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different ages", first, second);
    }

    @Test
    public void testCDependsOnName() {
        MagicNumbers magicNumbers = generateTestData();
        int first = magicNumbers.calculateC();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different names", first, second);
    }
}
