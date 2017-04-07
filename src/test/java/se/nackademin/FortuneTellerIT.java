package se.nackademin;

import static junit.framework.Assert.assertFalse;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FortuneTellerIT {

    @Test
    public void testGetFortune() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("16");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("11000");
        fortuneTeller.setLocation("Hagfors");
        fortuneTeller.setName("Sture Hagfors");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);
    }

    //Issue #37:  Svante/-10000/Malmö/27/0 ger ArrayIndexOutOfBoundsException
    //Löst genom att ignorera tecken på inkomst (ex. -10000 = 10000)
    @Test
    public void testNegIncomeToPosIncom() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("-27");
        fortuneTeller.setHeight("-165");
        fortuneTeller.setIncome("-10000");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setName("Svante");
        String output = fortuneTeller.calculate();
        assertEquals("Verify issue #37 have been fixed, negative income input should switch to positive value.", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa en lönesänkning. Snart kommer du vilja mäta, men då är det viktigt att du är snabb.", output);

    }
    //incomeValue <= 10_000_000

    @Test
    public void testIncomeLessThen_10_000_000() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean output = fortuneTeller.setIncome("9999999");
        assertTrue("Should return true", output);

    }

    @Test
    public void testIncomeEquleTo_10_000_000() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean output = fortuneTeller.setIncome("10000000");
        assertTrue("Should return true", output);

    }
    
        @Test
    public void testIncomeGreterThen_10_000_000() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean output = fortuneTeller.setIncome("10000001");
        assertFalse("Should return false", output);

    }

    @Test
    public void testSetNameNull() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());

        assertFalse("should return false,", fortuneTeller.setName(null));
        // assertFalse(message, true);
    }

    @Test
    public void testSetNameEmpty() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());

        assertFalse("should return false,", fortuneTeller.setName(""));
        // assertFalse(message, true);
    }

    @Test
    public void testHeightNull() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());

        assertFalse("should return false,", fortuneTeller.setHeight(null));
        // assertFalse(message, true);
    }

    @Test
    public void testAgeNull() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());

        assertFalse("should return false,", fortuneTeller.setAge(null));
        // assertFalse(message, true);
    }

    @Test
    public void testLocationNull() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());

        assertFalse("should return false,", fortuneTeller.setLocation(null));
    }

    @Test
    public void testLocationEmpty() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());

        assertFalse("should return false,", fortuneTeller.setLocation(""));
    }

    //Issue #38: Svante/10000/Malmö/27/0 ger ArrayIndexOutOfBoundsException
    //Löst genom att tvinga C att vara negativ innan man kommer in i while-loopen.
    @Test
    public void testForstCtobeNegativ() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("10000");
        fortuneTeller.setName("Svante");
        fortuneTeller.setLocation("Malmö");
        String output = fortuneTeller.calculate();
        assertEquals("Verify issue #38 is fixed, ", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa en lönesänkning. Snart kommer du vilja mäta, men då är det viktigt att du är snabb.", output);
    }

    //Issue #39: Svante/10000/Malmö/-5/165 ger ArrayIndexOutOfBoundsException
    //Löst genom att ignorera tecken på ålder (ex. -27 = 27)
    @Test
    public void testDenyMinusAge() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("-27");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("10000");
        fortuneTeller.setName("Svante");
        fortuneTeller.setLocation("Malmö");
        String output = fortuneTeller.calculate();
        assertEquals("Verify issue #39 is fixed, ", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa en lönesänkning. Snart kommer du vilja mäta, men då är det viktigt att du är snabb.", output);

    }

    // Issue #40: Svante/10000/Malmö/27/-20 ger ArrayIndexOutOfBoundsException
    //Löst genom att ignorera tecken på längd (ex. -165 = 165);
    @Test
    public void testDenyMinusHeight() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("-165");
        fortuneTeller.setIncome("10000");
        fortuneTeller.setName("Svante");
        fortuneTeller.setLocation("Malmö");
        String output = fortuneTeller.calculate();
        assertEquals("Verify issue #40 is fixed, ", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa en lönesänkning. Snart kommer du vilja mäta, men då är det viktigt att du är snabb.", output);

    }
    //Issue #41: Svante/0/Malmö/27/165 ger ArrayIndexOutOfBoundsException
    //Löst genom att tvinga D att vara negativ innan man kommer in i while-loopen.

    @Test
    public void testForstDtobNegativ() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("0");
        fortuneTeller.setName("Svante");
        fortuneTeller.setLocation("Malmö");
        String output = fortuneTeller.calculate();
        assertEquals("Verify issue #41 is fixed, ", "Din framtid är vacker. Du borde sluta äta. Vi ser att du snart kommer att skaffa ett elstängsel. Snart kommer du vilja röra, men då är det viktigt att du är stor.", output);

    }

}
