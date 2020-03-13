/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylist;

/**
 *
 * @author khang
 */
public class MergeSort {
    
    private void merge(start, end,mid){
        int [] temp = new int [end-start+1];
        
        int leftIndex = start;
        int rightIndex = mid+1;
        int index = 0;
        
        while ((leftIndex <= mid) && (rightIndex <= end)){
            if (list[leftIndex] < list[rightIndex])
            {
                temp[index] = list[leftIndex]
                leftIndex++;
                index++
            }
            else{
                temp[index] = list[rightIndex]
                        rightIndex++
                                index++
                                       
            }
        }
        while (leftIndex <= mid)
            temp[index] = list[leftIndex]
                    leftIndex++
                            index++
         while (rightIndex <= end)
             
             temp[index] = list[rightIndex]
                     rightIndex++
                             index++
                                     
                                     
         index = start;
         for ( int i = 0; i < temp.lenght; i++)
             list[index] = temp[i]
                     index++
    }
}
