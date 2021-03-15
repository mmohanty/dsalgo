package org.manas.dsalgo.interviewbit.math;

import org.manas.dsalgo.interviewbit.array.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of digits (A) in sorted order, find how many numbers of length B are possible
 * whose value is less than number C.
 *
 *  NOTE: All numbers can only have digits from the given set.
 * Examples:
 *
 * 	Input:
 * 	  0 1 5
 * 	  1
 * 	  2
 * 	Output:
 * 	  2 (0 and 1 are possible)
 *
 * 	Input:
 * 	  0 1 2 5
 * 	  2
 * 	  21
 * 	Output:
 * 	  5 (10, 11, 12, 15, 20 are possible)
 * Constraints:
 *
 *     1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9
 */
public class NumbersOfLengthNAndValueLessThanK {

    public static void main(String[] args)
    {
        int arr[] = { 0, 1, 2, 5 };
        // Digits array
        List<Integer> A = ArrayUtil.toList(arr);
        int N = 2;
        int k = 21;
        NumbersOfLengthNAndValueLessThanK nl = new NumbersOfLengthNAndValueLessThanK();
        System.out.println(nl.solve(A, N, k));
    }

    public int solve(List<Integer> A, int B, int C) {

        int MAX = 10;
        List<Integer> digit = new ArrayList<>();
        int d, d2;

        // Convert number to digit array
        digit = numToVec(C);
        d = A.size();

        // Case 1: No such number possible as the
        // generated numbers will always
        // be greater than C
        if (B > digit.size() || d == 0)
            return 0;

            // Case 2: All integers of length B are valid
            // as they all are less than C
        else if (B < digit.size()) {
            // contain 0
            if (A.get(0) == 0 && B != 1)
                return (int) ((d - 1) * Math.pow(d, B - 1));
            else
                return (int) Math.pow(d, B);
        }

        // Case 3
        else {
            int[] dp = new int[B + 1];
            int[] lower = new int[MAX + 1];

            // Update the lower[] array such that
            // lower[i] stores the count of elements
            // in A[] which are less than i
            for (int i = 0; i < d; i++)
                lower[A.get(i) + 1] = 1;
            for (int i = 1; i <= MAX; i++)
                lower[i] = lower[i - 1] + lower[i];

            boolean flag = true;
            dp[0] = 0;
            for (int i = 1; i <= B; i++) {
                d2 = lower[digit.get(i - 1)];
                dp[i] = dp[i - 1] * d;

                // For first index we can't use 0
                if (i == 1 && A.get(0) == 0 && B != 1)
                    d2 = d2 - 1;

                // Whether (i-1) digit of generated number
                // can be equal to (i - 1) digit of C
                if (flag)
                    dp[i] += d2;

                // Is digit[i - 1] present in A ?
                flag = (flag & (lower[digit.get(i - 1) + 1] ==
                        lower[digit.get(i - 1)] + 1));
            }
            return dp[B];

        }
    }
        List<Integer> numToVec(int N){
            List<Integer> digit = new ArrayList<>();

            // Push all the digits of N from the end
            // one by one to the vector
            while (N != 0)
            {
                digit.add(N % 10);
                N = N / 10;
            }

            // If the original number was 0
            if (digit.size() == 0)
                digit.add(0);

            // Reverse the vector elements
            Collections.reverse(digit);

            // Return the required vector
            return digit;
        }


    }
