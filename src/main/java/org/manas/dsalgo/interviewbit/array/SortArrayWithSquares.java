package org.manas.dsalgo.interviewbit.array;

import java.util.Arrays;

/**
 * Problem Description
 *
 * Given a sorted array A containing N integers both positive and negative.
 *
 * You need to create another array containing the squares of all the elements in A and return it in non-decreasing order.
 *
 * Try to this in O(N) time.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105.
 *
 * -103 <= A[i] <= 103
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return a integer array as described in the problem above.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [-6, -3, -1, 2, 4, 5]
 * Input 2:
 *
 *  A = [-5, -4, -2, 0, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 4, 9, 16, 25, 36]
 * Output 2:
 *
 *  [0, 1, 4, 16, 25]
 */
public class SortArrayWithSquares {

    public static void main(String[] args) {
       // int a[] ={-6, -3, -1, 2, 4, 5};
        int a[] ={-855, -847, -747, -708, -701, -667, -666, -618, -609, -536, -533, -509, -500, -396, -336, -297, -284, -229, -173, -173, -132, -38, -5, 35, 141, 169, 281, 322, 358, 421, 436, 447, 478, 538, 547, 644, 667, 673, 705, 711, 718, 724, 726, 811, 869, 894, 895, 902, 912, 942, 961};
        SortArrayWithSquares saws = new SortArrayWithSquares();
        int []result = saws.solve(a);

        Arrays.stream(result).forEach( element -> System.out.print(element + " ") );
    }
    public int[] solve(int[] a) {
        int size = a.length;
        int []result = new int[size];

        int positivePointer = findPositiveNumberStartPosition(a);
        int negativePointer = positivePointer -1;

        int position=0;
        while(positivePointer < size || negativePointer > -1){
            if(positivePointer  < size && negativePointer > -1){
                int positiveValue = a[positivePointer];
                int negativeValue = Math.abs(a[negativePointer]);
                if(positiveValue == negativeValue){
                    result[position++] = (int)Math.pow(negativeValue,2);
                    negativePointer--;
                    result[position++] = (int)Math.pow(positiveValue,2);
                    positivePointer++;
                }else if(positiveValue > negativeValue){
                    result[position++] = (int)Math.pow(negativeValue,2);
                    negativePointer--;
                }else if(negativeValue > positiveValue){
                    result[position++] = (int)Math.pow(positiveValue,2);
                    positivePointer++;
                }
            }
            if(positivePointer >= size && negativePointer <= -1){
                break;
            }
            if(positivePointer >= size){ // only negative number remianing
                int negativeValue = Math.abs(a[negativePointer]);
                result[position++] = (int)Math.pow(negativeValue,2);
                negativePointer--;
            }else if(negativePointer <= -1){//only positive number remaining
                int positiveValue = a[positivePointer];
                result[position++] = (int)Math.pow(positiveValue,2);
                positivePointer++;
            }

        }
        return result;

    }

    private int findPositiveNumberStartPosition(int[] a) {
        for(int index =0; index < a.length-1; index++){
            if(a[index] > 0){
                return index;
            }
        }
        //all are negative number
        return a.length;
    }
}
