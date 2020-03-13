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
 */
public class quickSort {
private int array[];
   
   private static final String OUTPUT_FILE = "src\\output\\output2.txt";
  
   /**
     * Processes input array through shellSort
     * @param array 
     */
   public void quickSort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }
        this.array = array;
        
        implementQuickSort(0, array.length - 1);
        
        //prints sorted array into output1
        generateOutput(array); 
 
   }

    /**
     * Processes input array through shellSort
     * @param low
     * @param high
     */
    private void implementQuickSort(int low, int high) {
        int i = low;
        int j = high;

        
        int pivot = array[high];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            implementQuickSort(low, j);
        }

        if (i < high) {
            implementQuickSort(i, high);
        }  
    }

    //swaps arrays
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;       
    }
    
    
    /**
     * Generates output file
     * @param quickSortArray 
     */
    private void generateOutput(int quickSortArray[]){
        
        File file1 = new File (OUTPUT_FILE);
        try
        {
        PrintWriter pw = new PrintWriter (file1);
        
        //prints array
        
        for (int k = 0; k < quickSortArray.length; k++)
           { 
            pw.printf(Integer.toString(quickSortArray[k]));
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
