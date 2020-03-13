/* Purpose : Calculate gross pay, savings, IRA invesment, and total
Kha Nguyen
Assignment 5
jGrasp Windows 10 on Lenovo y50 series
attune - bring into harmony
"The whole problem with the world is that fools and fanatics are
always so certain of themselves, and wiser people so full of 
doubts" Bertrand Russell (1872-1970)
*/
import java.text.DecimalFormat;
import java.util.Scanner;

public class KhaNguyen_4_05 {

   public static void main (String [] args) {
      
      
      //Reduce nonsensical value of decimals into a manageble one.
      DecimalFormat formatnum = new DecimalFormat ("###.00");
      
      
      Scanner console = new Scanner(System.in);
      
      
      double grossPay;              //Value for gross pay
      double savingsRate;           //Value for the savings rate
      double iraRate;               //Value for the IRA rate
      double itsSavings = 0.0;      //Initializing method of itsSavings
      double itsIRAinvestment = 0.0;//Initializing method of itsIRAinvestment
      double itsTotal = 0.0;        //Initializing method of itsTotal
      
      String messageUser;           //Initializing the string for messageUser
                
      
      //Actually input values into the program to execute.
      System.out.print(" Input your gross pay : " );
      grossPay = console.nextDouble();
      System.out.print(" Input your savings rate : " );
      savingsRate = console.nextDouble();
      System.out.print( " Input IRA investment rate : ");
      iraRate = console.nextDouble();
      //Stops negative numbers from going into the program, and prompt a quote.
      if ( grossPay > 0 &&
           savingsRate > 0 &&
           iraRate > 0) { 
            }
                    
      else { System.out.print(" Are you sure you want a negative? ");
         return;
         }



      //Setting the variable into a function.
      itsSavings = itsSavings(grossPay,savingsRate);
      itsIRAinvestment = itsIRAinvestment(grossPay,iraRate);
      itsTotal = itsTotal(itsSavings,itsIRAinvestment);
      
      //Printing out the output and calculations when done.
      messageUser = messageUser();
      System.out.println(" Gross pay input: " + (formatnum.format (grossPay)) +
                       " \n Savings rate input: " + (formatnum.format (savingsRate)) +
                       " \n IRA investment rate input: " 
                        + (formatnum.format(iraRate)) +
                       " \n Savings is " +  (formatnum.format (itsSavings)) +
                       " \n IRA investment is " + (formatnum.format (itsIRAinvestment)) +
                       " \n Total is " + (formatnum.format (itsTotal)) 
                       );                   
   }
   
   //********************************************************************
    //Method with parameters that calculate the savings.
    public static double itsSavings (double grossPay, double savingsRate){ 
            
           return grossPay * savingsRate / 100.0;
           
            }
    //*******************************************************************     
    //Method with parameters that calculate the IRA investment.
    public static double itsIRAinvestment(double grossPay, double iraRate) {
          
            return grossPay * iraRate / 100.0;
          
      }
    //*******************************************************************  
    //Method with parameters that calculate the total.
    public static double itsTotal (double itsSavings, double itsIRAinvestment) {
           
           return itsSavings + itsIRAinvestment;
      }   
    //*******************************************************************  
    //Method to call on string
    public static String messageUser() {
    String messageUser = "";
      System.out.print(" This program prompts the user to enter" + 
      " all real numbers for calculations using\n" + 
      " methods to calculate the the total, IRA investment amount and savings rate." +
      "\n Kha Nguyen\n");

          return messageUser;
    }      

       }

  
   

