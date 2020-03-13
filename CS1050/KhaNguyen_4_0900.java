import java.io.*;

public class KhaNguyen_4_09 {

   public static void main (String [] args) {
       double grossPay = 0.0;
       double iraRate = 0.0;
       double savingsRate = 0.0;
       double itsSavings = 0.0;
       double itsIRAinvestment = 0.0;

   
   
   
   
   KhaNguyen_4_09_Calc values = new KhaNguyen_4_09_Calc();
   explainProgram();
   values.getInput();
   values.itsSavings(grossPay, savingsRate);
   

   values.itsIRAinvestment(grossPay, iraRate);
    
   values.itsTotal(itsSavings, itsIRAinvestment);
    
   
   values.getOutput();
  
    } 
   public static void explainProgram(){
      System.out.print("This program uses a class for its calculations " +
      "\nKha Nguyen\n");}
    public static void getInput(){
    return;}
    public static void itsSavings(){
    return;}
    public static void itsIRAinvestment(){
    return;
    }
    public static void itsTotal(){
    return;}
    
    public static void getOutput(){
    return;
    }
}