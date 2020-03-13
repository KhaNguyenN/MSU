/* Purpose : Calculate gross pay, savings and investment
 and then show it on dialog box.
Kha Nguyen
Assignment 3
jGrasp
Confer - Having a meeting to talk something over
"It always seems impossible until its done." Nelson Mandela (1918-2013)
*/

import javax.swing.JOptionPane;	
import java.text.DecimalFormat;		
import java.util.StringTokenizer;





public class KhaNguyen_4_03 {
 
   public static void main (String [] args) {
   
      DecimalFormat formatnum = new DecimalFormat ("###.00");
      double grossPay;        // Input values for gross pay
      double savingsRate;     // Input values for savings rate
      double iraRate;	      // Input values for IRA rate
      
      
      double savings;         // Savings amount
      double iraInvestment;   // IRA investment amount
      double total;           // Sum of Savings amount and IRA investment amount
      String inputStr;				
      StringTokenizer  st;
      
      // Explain what the program does
      inputStr = JOptionPane.showInputDialog(
         		"Enter gross pay, savings rate and IRA rate separated by spaces");
     
      // Input three values that are gross pay, savings rate and IRA rate
      st = new StringTokenizer(inputStr);
      grossPay = Double.parseDouble(st.nextToken());
      savingsRate = Double.parseDouble(st.nextToken());
      iraRate = Double.parseDouble(st.nextToken());
      
      
      // Calculate the percentages and total for the program
      savings  = (savingsRate / 100.0) * grossPay ;
      iraInvestment  = (iraRate / 100.0) * grossPay;
      total = iraInvestment + savings;
     
      // Dialog box shows input values
      JOptionPane.showMessageDialog(null, " Gross pay is " + 
         formatnum.format (grossPay) + " " + ", savings rate is " +
         formatnum.format (savingsRate) + " " + " and the IRA rate is " +
         formatnum.format (iraRate) +
         "\nSavings is " + formatnum.format (savings) +
         " \nIRA Investment is " + formatnum.format (iraInvestment) + 
         " \nTotal of the investment and savings is " + formatnum.format (total) +  
         " \nKha Nguyen");
      
            
      // Close files and exit
      
      System.exit(0);
   } // End main
} // End class
