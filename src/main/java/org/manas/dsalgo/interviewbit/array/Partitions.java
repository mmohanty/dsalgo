package org.manas.dsalgo.interviewbit.array;

import java.util.List;

/**
 * Problem Description
 *
 * You are given a 1D integer array B containing A integers.
 *
 * Count the number of ways to split all the elements of the array into 3 contiguous parts so that the sum of elements in each part is the same.
 *
 * Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 105
 *
 * -109 <= B[i] <= 109
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 *
 * Second argument is an 1D integer array B of size A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the number of ways to split the array B into three parts with the same sum.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 5
 *  B = [1, 2, 3, 0, 3]
 * Input 2:
 *
 *  A = 4
 *  B = [0, 1, -1, 0]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are no 2 ways to make partitions -
 *  1. (1,2)+(3)+(0,3).
 *  2. (1,2)+(3,0)+(3).
 * Explanation 2:
 *
 *  There is only 1 way to make partition -
 *  1. (0)+(-1,1)+(0).
 */
public class Partitions {
    public static void main(String[] args) {
        Partitions partitions = new Partitions();
        int a[] = {1, 2, 3, 0, 3};//2

        List<Integer> list = ArrayUtil.toList(a);
        int result = partitions.solve(list.size(), list);
        System.out.println(result);
    }

    public int solve(int a, List<Integer> b) {
        int cnt[] = new int[a];
        int sum = 0;
        for (int element: b) {
            sum+=element;
        }

        int subArraySum = sum / 3;

        int reminder = sum % 3;
        if(reminder != 0){
            return 0;
        }

        int ss = 0;

        // If the sum of elements from i-th to n-th
        // equals to sum of part putting 1 in cnt
        // array otherwise 0.
        for (int i = a-1; i >= 0 ; i--)
        {
            ss += b.get(i);
            if (ss == subArraySum)
                cnt[i] = 1;
        }

        // Calculating the cumulative sum
        // of the array cnt from the last index.
        for (int i = a-2 ; i >= 0 ; i--)
            cnt[i] += cnt[i + 1];

        int ans = 0;
        ss = 0;

        // Calculating answer using original
        // and cnt array.
        for (int i = 0 ; i+2 < a ; i++)
        {
            ss += b.get(i);
            if (ss == subArraySum)
                ans += cnt[i + 2];
        }
        return ans;

    }
}
