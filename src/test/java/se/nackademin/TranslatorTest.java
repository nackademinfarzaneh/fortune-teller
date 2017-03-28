/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author testautom-nack
 */
public class TranslatorTest {
    
    Ordlista ordlist;
    
    Translator translator ;
    MagicNumbers magicNumbers ;
    
  @Before
   public void setUp(){
      ordlist=new Ordlista();     
      
       ordlist.getAdjektivs().put(0, "stor");  
       ordlist.getAdjektivs().put(1, "liten");
       ordlist.getAdjektivs().put(2, "stark");
        ordlist.getAdjektivs().put(3, "svag");
       ordlist.getAdjektivs().put(4, "mjuk");
        ordlist.getAdjektivs().put(5, "hård");
       ordlist.getAdjektivs().put(6, "snabb");
        ordlist.getAdjektivs().put(7, "vacker");
       ordlist.getAdjektivs().put(8, "ljus");
        ordlist.getAdjektivs().put(9, "mörk");         
    
        
        ordlist.getSubstantivs().put(0, "en lönehöjning");
        ordlist.getSubstantivs().put(1, "en lönesänkning");
        ordlist.getSubstantivs().put(2, "en fotboja");
        ordlist.getSubstantivs().put(3, "en katt");
        ordlist.getSubstantivs().put(4, "en hund");
        ordlist.getSubstantivs().put(5, "ett hus");
        ordlist.getSubstantivs().put(6, "ett barn");
        ordlist.getSubstantivs().put(7, "ett elstängsel");
        ordlist.getSubstantivs().put(8, "en dator");
        ordlist.getSubstantivs().put(9, "ett golv");   
        
        ordlist.getVerbs().put(0, "springa");
        ordlist.getVerbs().put(1, "ljuga");
        ordlist.getVerbs().put(2, "flyga");
        ordlist.getVerbs().put(3, "se");
        ordlist.getVerbs().put(4, "vara");
        ordlist.getVerbs().put(5, "äta");
        ordlist.getVerbs().put(6, "mäta");
        ordlist.getVerbs().put(7, "gå");
        ordlist.getVerbs().put(8, "röra");
        ordlist.getVerbs().put(9, "resa");   
      
     magicNumbers = new MagicNumbers();
     translator = new Translator(ordlist);
   
   }

    // TODO add test methods here.

      @Test
     public void TestgenereraOrd() {
         //tar den magiska siffran somman har räknat i MagicNumberClassen
         //Genererar Addjektiv från adjektivList  
    
       magicNumbers.setName("Sture Hagfors");
       magicNumbers.setAge(35);

       magicNumbers.setLocation("Hagfors");
       magicNumbers.setIncome(11000);
        
         magicNumbers.setHeight(165);         

         String adjectiveA= translator.getAdjektiv(magicNumbers.calculateA());
         String verbB= translator.getVerb(magicNumbers.calculateB());
         String sub= translator.getSubstantiv(magicNumbers.calculateC());
         String verbD= translator.getVerb(magicNumbers.calculateD());
         String adjectiveE= translator.getAdjektiv(magicNumbers.calculateE()); 
         
        String mal = translator.generertMall( adjectiveA,verbB,sub, verbD, adjectiveE);
     }

}
