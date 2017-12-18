package org.manas.dsalgo.array;

/**
Find duplicates in O(n) time and O(1) extra space | Set 1
        2.6
        Given an array of n elements which contains elements from 0 to n-1, with any of these
        numbers appearing any number of times. Find these repeating numbers in O(n) and using only
        constant memory space.

        For example, let n be 7 and array be {1, -2, -3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 **/
public class DuplicateFinder {

    public StringBuilder getDuplicateElements(final int[] arr){
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < arr.length; index++){
            int value = Math.abs(arr[index]);
            int element = arr[value];
            if(element > 0){
                arr[value] = -element;
            }
            else{
                builder.append(value);
            }

        }
        return builder;
    }
}
