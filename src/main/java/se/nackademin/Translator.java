/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin;

import java.util.Arrays;

/**
 *
 * @author testautom-nack
 */
public class Translator {       
   
    String adjektiv;
    String substantive;
  //  String verb;
    MagicNumbers magicnumber;
    
    private Ordlista ordLista;


    Translator(Ordlista ordlist) {
              
        ordLista = ordlist;              
    }

    Translator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the adjektiv
     */
    public String getAdjektiv(int index) {
        
        return ordLista.getAdjektivs().get(index);
    }

    /**
     * @return the verb
     */
    public String getVerb(int index) {
        
        
        return ordLista.getVerbs().get(index);
    }

    String getSubstantiv(int index) {
        return ordLista.getSubstantivs().get(index);
    }

    /**
     * @return the ordLista
     */
    public Ordlista getOrdLista() {       

        
        return ordLista;
    }

    /**
     *
     * @param adjectiveA
     * @param verbB
     * @param sub
     * @param verbD
     * @param adjectiveE
     * @return 
     */
  public String generertMall(String adjectiveA, String verbB, String sub, String verbD, String adjectiveE) {
  //  public String generertMall(){
        

                
        String adj1 =  "Din framtid är " + adjectiveA + ". " ;
        String verb1 = "Du borde sluta "+ verbB  +". ";
        String subs = "Vi ser att du snart kommer att skaffa " + sub + ". ";
        String verb2 = "Snart kommer du vilja "+ verbD + ", ";
        String adj2 = "men då är det viktigt att du "+ adjectiveE;
        
         String mal = adj1 +verb1 + "\n" + subs+ "\n" +  verb2 + adj2 ;;
         
        return mal ;
        
    }

    void setMagicNumbers(MagicNumbers magicNumbers) {
       this.magicnumber=magicNumbers;
    }


    
}
