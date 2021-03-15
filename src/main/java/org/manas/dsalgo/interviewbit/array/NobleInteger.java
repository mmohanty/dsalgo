package org.manas.dsalgo.interviewbit.array;

import java.util.Collections;
import java.util.List;

/**
 * Problem Description
 *
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater
 * than p in the array equals to p.
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return 1 if any such integer p is found else return -1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [3, 2, 1, 3]
 * Input 2:
 *
 *  A = [1, 1, 3, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For integer 2, there are 2 greater elements in the array. So, return 1.
 * Explanation 2:
 *
 *  There is no such integer exists.
 */
public class NobleInteger {

    public static void main(String[] args) {
        int a[] = {5, 6, 2}; // expected 5;
        List<Integer> input = ArrayUtil.toList(a);
        NobleInteger nobleInteger = new NobleInteger();
        int result = nobleInteger.solve(input);
        System.out.println(result);
    }

    public int solve(List<Integer> arr) {
        Collections.sort(arr);

        // Return a Noble element if present
        // before last.
        int n = arr.size();
        for (int i=0; i<n-1; i++)
        {
            if (arr.get(i) == arr.get(i+1))
                continue;

            // In case of duplicates, we
            // reach last occurrence here.
            if (arr.get(i) == n-i-1) {
                // return arr.get(i);
                return 1;
            }
        }

        if (arr.get(n-1) == 0) {
            //return arr.get(n-1);
            return 1;
        }

        return -1;
    }
}
