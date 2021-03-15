package org.manas.dsalgo.interviewbit.array;

import java.util.List;

/**
 * Problem Description
 *
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum value of j - i;
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 5, 4, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Maximum value occurs for pair (3, 4).
 */
public class MaxDistance {

    public static void main(String[] args) {
        int a[] = {100, 100, 100, 100, 100}; // expected 4;
        List<Integer> input = ArrayUtil.toList(a);
        MaxDistance maxDistance = new MaxDistance();
        int result = maxDistance.maximumGap(input);
        System.out.println(result);
    }


    int max(int x, int y)
    {
        return x > y ? x : y;
    }

    int min(int x, int y)
    {
        return x < y ? x : y;
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> a) {
        int n = a.size();
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = a.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = min(a.get(i), LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = a.get(n-1);
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(a.get(j), RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0;
        j = 0;
        maxDiff = 0;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;

    }
}
