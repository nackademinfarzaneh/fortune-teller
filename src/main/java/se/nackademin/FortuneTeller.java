package se.nackademin;

import se.nackademin.gui.FortuneTellerGui;

public class FortuneTeller {
    MagicNumbers magicNumbers;
    FortuneTellerGui fortuneTellerGui;
    Translator translator;
    Ordlista ordlista;

    /*
     * Returns a fortune based on name, income, location, age and height
     *
     * Calculates the magical numbers A-E, and then feeds these numbers to the Translator. The translator class returns
     * individual words which are fed into the magical template. The result of this operation is a scientifically
     * proven fortune.
     *
     * @return A scientifically proven fortune
     *
     */
    public String calculate() { 
        //TODO: Implement            
         
       int calA = magicNumbers.calculateA();
       int calB = magicNumbers.calculateB();
       int calC = magicNumbers.calculateC();
       int calD = magicNumbers.calculateD();
       int calE = magicNumbers.calculateE();
       
       String adjA = translator.getAdjektiv(calA);
       String verbB = translator.getVerb(calB);
       String subsC = translator.getSubstantiv(calC);
       String verbD = translator.getVerb(calD);
       String adjE = translator.getAdjektiv(calE); 
 
       String mal = translator.generertMall ( adjA,verbB,subsC, verbD, adjE);      
      
        return mal;
    }

    public static void main(String[] args) {
        new FortuneTeller();
    }

    FortuneTeller() {
        fortuneTellerGui = new FortuneTellerGui(this);
        magicNumbers = new MagicNumbers();
        ordlista=new Ordlista();
        ordlista.createData();
        translator = new Translator(ordlista);
        translator.setMagicNumbers(magicNumbers);

    }

    public boolean setName(String name) {

        magicNumbers.setName(name);
        return name != null;
    }

    Integer convertToInteger(String input) {
        Integer output = null;
        try {
            output = Integer.valueOf(input);
        } catch (NumberFormatException numberFormatException) {
            //if an exception is caught we'll return null
        }
        return output;
    }

    public boolean setIncome(String income) {
        Integer incomeValue = convertToInteger(income);
        if (incomeValue == null) {
            return false;
        } else {
            magicNumbers.setIncome(incomeValue);
            return incomeValue<=10_000_000;
        }
    }

    public boolean setLocation(String location) {
        magicNumbers.setLocation(location);
        return location != null;
    }

    public boolean setAge(String age) {
        Integer ageValue = convertToInteger(age);
        if (ageValue == null) {
            return false;
        } else {
            magicNumbers.setAge(ageValue);
            return true;
        }
    }

    public boolean setHeight(String height) {
        Integer heightValue = convertToInteger(height);
        if (heightValue == null) {
            return false;
        } else {
            magicNumbers.setHeight(heightValue);
            return true;
        }
    }
}
