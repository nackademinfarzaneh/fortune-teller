package se.nackademin;

import javax.swing.JOptionPane;

public class MagicNumbers {

    private String name;
    private int income;
    private String location;
    private int age;
    private int height;

    public int calculateA() {   
           
      int age = this.age;
      int sifra = 0;
      sifra = nameLength()+ age;
      
      while( sifra >=  10 ){
          
          sifra = sifra - 7;
      }
      
    return sifra;
    }

    public int calculateB() {
        
       int location = this.location.length();
       int incom = this.income;   
       int sifra = location + incom ;
       while (sifra >= 10){
           sifra = sifra - 7;
       }
 
       return sifra;
    }

    public int calculateC() {
       
       int abHeight =  calculateA()+calculateB()-this.height ;  
       
         while(abHeight < 0){
             
         abHeight = abHeight +10;
      }

       return abHeight;
    }

    public int calculateD() {
        
       int a = calculateA();
       int b = calculateB();       
       int c = calculateC();
       int sifra = 0;
       
       if (a > 5){
           a = a + b;
       }
       else {
          a = a + c;
       }
       
      sifra = a - this.income ;
      
      while(sifra < 0){
         sifra = sifra +10;
      }
      
        return sifra;
    }

    public int calculateE() {
        
        double ag = 0;
      
      ag = this.age * this.income;
      ag = (ag * this.income);
      ag = (ag * this.height);      
      
        double d = Math.sqrt(ag);         
        while ( d >= 10){
            
            d = d /2;
        }      
      return  Integer.valueOf(new Long(Math.round(d)).intValue());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public int subtrahera(int sifra){        
              
        while (sifra >= 10){  
            
            sifra =sifra - 7;            
        }        
        return sifra;
    }
    public int nameLength(){
       
       String delims = " ";
       String[] s1 = this.name.split(delims);        
 
        
        return s1.length;
    }

}
