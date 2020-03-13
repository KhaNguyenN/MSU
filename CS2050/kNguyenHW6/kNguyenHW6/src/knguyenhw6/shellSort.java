/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knguyenhw6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author khang
 *
 * 
 **/ 
    
public class shellSort {
private static final String OUTPUT_FILE = "src\\output\\output1.txt";
    
    /**
     * Processes input array through shellSort
     * @param array 
     */
public  void shellSort(int[] array) {	
        int space = array.length / 2;

        while(space > 0){
            
	// insertion sort 
            for (int i = space; i < array.length; i++) {
		
                int temp = array[i];
		
                int index = i;
		
                while (index >= space && array[index - space] > temp) 
                {
                    array[index] = array[index - space];
                    index = index - space;
		}
                    array[index] = temp;
            }
            space = space / 2;
        }
        
        //generates output of sorted array
        generateOutput(array);                
    }
    
    /**
     * Generates output file
     * @param shellSortArray 
     */
private void generateOutput(int[] shellSortArray){
        
        File file1 = new File (OUTPUT_FILE);
        try
        {
        PrintWriter pw = new PrintWriter (file1);
        
        //prints array
        for (int k = 0; k < shellSortArray.length; k++)
           { 
            pw.printf(Integer.toString(shellSortArray[k]));
            pw.println();
           }
         pw.close();
        }
         catch (FileNotFoundException ex)
        {
            System.err.println ("Cannot create the file: " + OUTPUT_FILE);
        }   
    }  
  
}
