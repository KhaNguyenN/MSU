/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.util.Objects;

/**
 *
 * @author khang
 */

/**
 * 
 * @author khang
 */
public class BankAccount {
     private String bankName;
     private String accountNumber;
     private double balance;
    
     
    public static void main(String[] args) {
      
    }
/**
      * This is a constructor which will initialize all the fields. It will also
      * validate the balance. If balance less than 0 then it will throw
      * IllegalArguement exception.
      * @param bankName Name of bank name
      * @param accountNumber Account number
      * @param balance Initial balance
      */
    public BankAccount(String bankName, String accountNumber, double balance) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("The balance value of "
                    + balance + " is illegal");
        }
    }
/**
 * Return the value of bank name
 * @return return the bank name
 */
    public String getBankName() {
        return bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "bankName=" + bankName + ", accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.bankName);
        hash = 31 * hash + Objects.hashCode(this.accountNumber);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankAccount other = (BankAccount) obj;
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if (!Objects.equals(this.bankName, other.bankName)) {
            return false;
        }
        if (!Objects.equals(this.accountNumber, other.accountNumber)) {
            return false;
        }
        return true;
    }

    
    
    
    
}



public static void generateReport ();
try{
PrintWriter pw = nre PrintWriter (file);

System.err.println ();
System.err.println("List of Banks");
pw.println ("Bank Name             Account Number           Initial Balance");
pw.println ("===================================================");

for (int i = 0; i< list.length; i++)
{
BankAccount ba2 = (BankAccount) list[i];
pw.printf(" %s %s %f%n",ba2.getBankName(),
(ba2.getAccountNumber(), 
(ba2.getInitialBalnce());
)
}
pw.close();
}
catch (FileNOtFoundException ex)
{
System.err.println (" Cannot create the file:" + OUTPUT_FILE);
}
}