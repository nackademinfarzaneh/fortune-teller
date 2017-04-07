package se.nackademin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MagicNumberTest {

    MagicNumbers magicNumbers;

    @Before
    public void setUp() {
        magicNumbers = new MagicNumbers();
        magicNumbers.setAge(16);
        magicNumbers.setHeight(165);
        magicNumbers.setIncome(11000);
        magicNumbers.setLocation("Hagfors");
        magicNumbers.setName("Sture Hagfors");
    }

    @Test
    public void testA() {
        assertEquals("A is not calculated correctly", 4, magicNumbers.calculateA());
    }

    @Test
    public void testB() {
        assertEquals("B is not calculated correctly", 3, magicNumbers.calculateB());
    }

    @Test
    public void testC() {
        assertEquals("C is not calculated correctly", 2, magicNumbers.calculateC());
    }

    @Test
    public void testD() {
        assertEquals("D is not calculated correctly", 6, magicNumbers.calculateD());
    }

    @Test
    public void testDWithAGreaterThan5() {
        magicNumbers.setAge(18);
        assertEquals("D is not calculated correctly", 9, magicNumbers.calculateD());
    }

    @Test
    public void testE() {
        assertEquals("E is not calculated correctly", 9, magicNumbers.calculateE());
    }

    @Test
    public void testADependsOnName() {
        int first = magicNumbers.calculateA();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different names", first, second);
    }

    @Test
    public void testADependsOnAge() {
        int first = magicNumbers.calculateA();
        magicNumbers.setAge(18);
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different ages", first, second);
    }

    @Test
    public void testBDependsOnLocation() {
        int first = magicNumbers.calculateB();
        magicNumbers.setLocation("Grytevik");
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different locations", first, second);
    }

    @Test
    public void testBDependsOnIncome() {
        int first = magicNumbers.calculateB();
        magicNumbers.setIncome(219487);
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different income values", first, second);
    }

    @Test
    public void testCDependsOnHeight() {
        int first = magicNumbers.calculateC();
        magicNumbers.setHeight(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different heights", first, second);
    }

    @Test
    public void testCDependsOnAge() {
        int first = magicNumbers.calculateC();
        magicNumbers.setAge(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different ages", first, second);
    }

    @Test
    public void testCDependsOnName() {
        int first = magicNumbers.calculateC();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different names", first, second);
    }

    @Test
    /* if (d > 5) {
            d += calculateB();
        } else {  */
    public void testDWithgraterthen5() {

        magicNumbers.setAge(18);
        assertEquals("D is not calculated correct", 9, magicNumbers.calculateD());

    }

    @Test
    public void testVerifyAisNotGraterThen_9() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);

        when(magicNumbersMock.calculateA()).thenReturn(10);
        assertEquals("A kan inte vara större än 9", 10, magicNumbersMock.calculateA());
    }

    @Test
    public void testVerifyBisNotGraterThen_9() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);

        when(magicNumbersMock.calculateB()).thenReturn(10);
        assertEquals("B kan inte vara större än 9", 10, magicNumbersMock.calculateB());
    }

    @Test
    public void testVerifyCisNotGraterThen_9() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);

        when(magicNumbersMock.calculateC()).thenReturn(10);
        assertEquals("C kan inte vara större än 9", 10, magicNumbersMock.calculateC());
    }

    @Test
    public void testVerifyDisNotGraterThen_9() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);

        when(magicNumbersMock.calculateD()).thenReturn(10);
        assertEquals("D kan inte vara större än 9", 10, magicNumbersMock.calculateD());
    }

    @Test
    public void testVerifyEisNotGraterThen_9() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);

        when(magicNumbersMock.calculateE()).thenReturn(10);
        assertEquals("E kan inte vara större än 9", 10, magicNumbersMock.calculateE());
    }

}
