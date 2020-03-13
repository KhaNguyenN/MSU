/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw6;

/**
 *
 * @author khang
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
public class KNguyenHW6 {
    
    private static final String INPUT_FILE = "src\\input\\hw6inputx.txt";
    private static final String OUTPUT_FILE = "src\\output\\hw6output.txt";
    private static final int[] inputArray = new int[100];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //process input text file into array
        processInput();
        
        //use the number to shell sort
        shellSort shellSort = new shellSort();
        shellSort.shellSort((inputArray));    
        
        //use the number to quick sort
        quickSort quickSort = new quickSort();
        quickSort.quickSort(inputArray);
    }
    
    //processes input file into array
    private static void processInput(){
        try{
            //Declaration of local variables
            boolean number;
            String digits = null;
            
            File file = new File(INPUT_FILE);
            Scanner inFile = new Scanner(file);
            
            for(int i = 0; i < 100; i++)
            {
                inputArray[i] = Integer.parseInt(inFile.nextLine());
            }   
        }catch (FileNotFoundException e){
            System.err.println("File " + INPUT_FILE + " not found.");
        }
        
    }   
}
