package org.manas.dsalgo.interviewbit.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example:
 *
 * Given [1,2,0] return 3,
 *
 * [3,4,-1,1] return 2,
 *
 * [-8, -7, -6] returns 1
 *
 * Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingInteger {

    public static void main(String[] args) {
        List<Integer> list =ArrayUtil.toList(new int[]{-8, -7, -6});
        FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
        int i = firstMissingInteger.firstMissingPositive((ArrayList<Integer>) list);

        System.out.println(i);
    }

    public int firstMissingPositive(ArrayList<Integer> A) {
        // First separate positive and
        // negative numbers
        int size = A.size();
        int shift = segregate(A, size);
        int arr2[] = new int[size - shift];
        int j = 0;
        for (int i = shift; i < size; i++) {
            arr2[j] = A.get(i);
            j++;
        }
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);
    }


    /* Utility function that puts all non-positive
       (0 and negative) numbers on left side of
       arr[] and return count of such numbers */
    static int segregate(ArrayList<Integer> arr, int size)
    {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr.get(i) <= 0) {
                int temp;
                temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    /* Find the smallest positive missing
       number in an array that contains
       all positive integers */
    static int findMissingPositive(int arr[], int size)
    {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }

        // Return the first index value at which
        // is positive
        for (i = 0; i < size; i++)
            if (arr[i] > 0)
                return i + 1; // 1 is added becuase indexes
        // start from 0

        return size + 1;
    }
}
