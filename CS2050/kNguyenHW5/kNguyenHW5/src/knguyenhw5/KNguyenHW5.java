/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw5;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author khang
 */
public class KNguyenHW5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
    
    Scanner scan = new Scanner(System.in);
    String input, output;
    
    //takes input
    System.out.println("Enter input");
    input = scan.nextLine();
    
    //creates postfix class and parses into convertToPostfix 
    //and returns output
    PostFix postfix =  new PostFix();
    output = postfix.convertToPostfix(input);
    
    //prints output
    System.err.println(output);

    }
    
}
