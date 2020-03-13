/* Purpose :Calculate gross pay, savings, IRA invesment, and total
            using two classes
Kha Nguyen
Assignment 9
jGrasp Windows 10 on Lenovo y50 series
Gongoozler - an idle spectator
"Success is no accident. It is hard work, perseverance, learning, studying, 
sacrifice and most of all, 
love of what you are doing or learning to do." Pele (b 1940)

*/




public class KhaNguyen_4_09 {

   public static void main(String[] args) {
      
      //Variables used to finalize calculations
      double savingsAmount = 0.0;
      double iraInvestmentAmount = 0.0;
     
     
    
      //Create an instance of class to get values from it
      KhaNguyen_4_09_Calc value = new KhaNguyen_4_09_Calc();
      
      //Call method explain program
      explainProgram();
   
      //Input user gets called
      value.getUserInput();
   
      //Calculated savings amount assign to a value
      savingsAmount = value.calculateSavingAmount();
   
   
      //Calcuated ira invesment amount assign to a value
      iraInvestmentAmount = value.calculateIraInvestmentAount();
   
      
      //Display user input and caluated result
      displayResult(value,savingsAmount,iraInvestmentAmount);
   
   
   }

   // Method to diplay user input and the result of the calculation
   // First parameter is of type KhaNguyen_4_09_Calc use this to display uer input
   // Second and third parameter is of type double use this to diplay the calculation result
  
  
  
  //Method prints out the result of user input
//*******************************************************************************************
   public static void displayResult(KhaNguyen_4_09_Calc value, double inpuSavingAmount, 
                                    double inputIraInvestmentAmount){
      value.displayInput();
      System.out.println("\nThe calculated saving amount is: $" + inpuSavingAmount +
         "\nThe calculated ira investment amount is: $" + inputIraInvestmentAmount +
         "\nThe total of the two is: " + (inpuSavingAmount + inputIraInvestmentAmount));
   }
 
 
  //Method used for getting called by main to explain the program 
//*******************************************************************************************
   public static void explainProgram(){
      System.out.println("This program will use a class to calculate the savings" +
         " amount and ira investment amount " + "\nby prompting user to" +
         " enter gross pay, savings rate and ira investment rate from the console " +
         "\nKha Nguyen");
   }

}
