package org.manas.dsalgo.interviewbit.array;

import java.util.List;

/**
 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
 *
 * For example,
 *
 * A=[1, 3, -1]
 *
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 *
 * So, we return 5.
 */
public class MaximumAbsoluteDifference {


    public static void main(String[] args) {
        MaximumAbsoluteDifference maximumAbsoluteDifference = new MaximumAbsoluteDifference();
        int a[] = {1, 3, -1}; // expected 5;
        List<Integer> input = ArrayUtil.toList(a);
        int result = maximumAbsoluteDifference.maxArr(input);
        System.out.println(result);
    }

    public int maxArr(List<Integer> a) {
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        int size = a.size();
        for (int i = 0; i < size; i++)
        {

            // Updating max and min variables
            // as described in algorithm.
            max1 = Math.max(max1, a.get(i) + i);
            min1 = Math.min(min1, a.get(i) + i);
            max2 = Math.max(max2, a.get(i) - i);
            min2 = Math.min(min2, a.get(i) - i);
        }

        // Calculating maximum absolute difference.
        return Math.max(max1 - min1, max2 - min2);
    }
}
