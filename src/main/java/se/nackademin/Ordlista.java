/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author testautom-nack
 */
public class Ordlista {
    
    Map<Integer,String> adjektivs;
    Map<Integer,String>  substantivs;
    Map<Integer,String>  verbs; 

    public Ordlista() {
        adjektivs=new HashMap<>();
         substantivs=new HashMap<>();
          verbs=new HashMap<>();
          
        
    }
    
    public  Map<Integer,String> getAdjektivs(){
        return adjektivs;
    }

    public Map<Integer, String> getSubstantivs() {
        return substantivs;
    }

    public Map<Integer, String> getVerbs() {
        return verbs;
    }
    
    
    public void createData(){
       getAdjektivs().put(0, "stor");  
       getAdjektivs().put(1, "liten");
       getAdjektivs().put(2, "stark");
       getAdjektivs().put(3, "svag");
       getAdjektivs().put(4, "mjuk");
       getAdjektivs().put(5, "hård");
       getAdjektivs().put(6, "snabb");
       getAdjektivs().put(7, "vacker");
       getAdjektivs().put(8, "ljus");
       getAdjektivs().put(9, "mörk");         
    
        
        getSubstantivs().put(0, "en lönehöjning");
        getSubstantivs().put(1, "en lönesänkning");
        getSubstantivs().put(2, "en fotboja");
       getSubstantivs().put(3, "en katt");
        getSubstantivs().put(4, "en hund");
        getSubstantivs().put(5, "ett hus");
        getSubstantivs().put(6, "ett barn");
        getSubstantivs().put(7, "ett elstängsel");
        getSubstantivs().put(8, "en dator");
        getSubstantivs().put(9, "ett golv");   
        
        getVerbs().put(0, "springa");
        getVerbs().put(1, "ljuga");
        getVerbs().put(2, "flyga");
        getVerbs().put(3, "se");
        getVerbs().put(4, "vara");
        getVerbs().put(5, "äta");
        getVerbs().put(6, "mäta");
        getVerbs().put(7, "gå");
        getVerbs().put(8, "röra");
        getVerbs().put(9, "resa");  
    }
    

   
    
}
