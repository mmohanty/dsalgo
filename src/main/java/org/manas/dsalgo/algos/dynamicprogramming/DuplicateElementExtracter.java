package org.manas.dsalgo.algos.dynamicprogramming;

/**
 * Created by mohanty on 03-09-2016.
 */
public class DuplicateElementExtracter {

    public int getRepeatedNumber(int []arr){
        int size = arr.length;
        int mid = size/2;
        for(int i= 0 ;i < mid; i++){
            if(arr[i] == arr[i+mid]){
                return arr[i];
            }
        }
        return -1;
    }
}
