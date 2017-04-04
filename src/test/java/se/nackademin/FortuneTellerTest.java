package se.nackademin;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FortuneTellerTest {

    @Test
    public void testCalculate() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        when(magicNumbersMock.calculateA()).thenReturn(1);
        when(magicNumbersMock.calculateB()).thenReturn(1);
        when(magicNumbersMock.calculateC()).thenReturn(1);
        when(magicNumbersMock.calculateD()).thenReturn(1);
        when(magicNumbersMock.calculateE()).thenReturn(1);

        Translator translatorMock = mock(Translator.class);
        when(translatorMock.getAdjective(anyInt())).thenReturn("liten");
        when(translatorMock.getVerb(anyInt())).thenReturn("springa");
        when(translatorMock.getNoun(anyInt())).thenReturn("en lönehöjning");
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        assertEquals("Din framtid är liten. Du borde sluta springa. Vi ser att du snart kommer att skaffa en lönehöjning. Snart kommer du vilja springa, men då är det viktigt att du är liten.", fortuneTeller.calculate());
    }

    @Test
    public void testSetAge() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("25");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setAge(25);
    }

    @Test
    public void testSetAgeWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("not an integer");
        assertFalse("should return false for invalid input", result);
    }

    @Test
    public void testSetLocation() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation("Gavle");
        assertTrue("Should return true if you written location", result);

    }

    @Test
    public void testSetLocationWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation("");
        assertFalse("Should return false for tom fält", result);
    }

    @Test
    public void testSetLocationWithNullValue() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation(null);
        assertFalse("Should return false for tom fält", result);
    }

    @Test
    public void testSetNameWithInvalidInput() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setName("");
        assertFalse("Should return false for tom fält", result);

    }

    @Test
    public void testSetNameWithNullValue() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setName(null);
        assertFalse("Should return false for tom fält", result);

    }

    @Test
    public void testSetName() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setName("Farzaneh");
        assertTrue("Should return true if you write a name.", result);
    }

    @Test
    public void testsetHeight() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setHeight("160");
        assertTrue("Should return true if you write a height.", result);

    }

    @Test
    public void testSetHeightWithInvalidInput() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setHeight("");
        assertFalse("Should return false if you dose not write a height", result);

    }

    @Test
    public void testSetIncomeLike10_000_000() {

        //  magicNumbers.setIncome(incomeValue);
        // return incomeValue <= 10_000_000;
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setIncome("10000000");
        assertTrue("Should return true if you write 10_000_000", result);

    }

    @Test
    public void testSetIncomelessThen10_000_000() {

        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setIncome("10000");
        assertTrue("Should return true if you write a number less then 10_000_000", result);

    }

    @Test
    public void testSetIncomeWithInvalidInput() {
        //  if (incomeValue == null) {
        //      return false;
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);

        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setIncome("");
        assertFalse("Should return false if you dose not write a income", result);

    }

    @Test
    public void testSetIncomeWithhigerThen10_000_000() {
        //  if (incomeValue == null) {
        //      return false;
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);

        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);

        boolean result = fortuneTeller.setIncome("10000001");
        assertFalse("Should return false if you dose not write a income", result);

    }

}
