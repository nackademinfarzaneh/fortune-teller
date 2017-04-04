/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author testautom-nack
 */
public class TranslatorTest {

    /**
     * Test of getNoun method, of class Translator.
     */
    @Test
    public void testGetNoun() {

        Translator translator = new Translator();

        String result = translator.getNoun(0);
        assertEquals("en lönehöjning", result);

    }

    /**
     * Test of getVerb method, of class Translator.
     */
    @Test
    public void testGetVerb() {

        Translator translator = new Translator();
        String result = translator.getVerb(0);

        assertEquals("springa", result);

    }

    /**
     * Test of getAdjective method, of class Translator.
     */
    @Test
    public void testGetAdjective() {

        Translator translator = new Translator();
        String result = translator.getAdjective(0);

        assertEquals("stor", result);

    }

}
