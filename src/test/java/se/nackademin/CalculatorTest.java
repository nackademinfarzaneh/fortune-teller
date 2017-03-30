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
public class CalculatorTest {
    
    double delta = 0.01;
            
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testAddition() {
     
         Calculator c= new Calculator();
        double resultat = c.add(1 ,1);
        
        assertEquals("Resultat of 1.0 + 1.0 should be ", 2 , resultat, delta);
         
     }
     @Test
     public void testMultiplication(){
         Calculator c = new Calculator();
         double result = c.multiply( 2, 2);
         
         assertEquals("Result of 2*2 suould be ", 4, result ,delta);
     }
     
     @Test
     public void testDivition() {
         Calculator c = new Calculator();
         double result = c.divide(15, 15);
         
         assertEquals( " Result of 15/ 15 sould be" , 1 , result, delta);
     }
     
     @Test
     public void testSubtraction() {
         
         Calculator c = new Calculator();
         double result = c.subtract (15 , 5);
         
         assertEquals("Result of 15 - 5 sould be ", 10, result, delta);
     }
}
