package org.manas.dsalgo.interviewbit.array;

import java.util.*;
import java.util.stream.Stream;

/**
 *
 * Problem Description
 *
 * Given an array A containing N integers.
 *
 * You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.
 *
 * If no such triplet exist return 0.
 *
 *
 *
 * Problem Constraints
 * 3 <= N <= 105.
 *
 * 1 <= A[i] <= 108.
 *
 *
 *
 * Input Format
 * First argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting the maximum sum of triplet as described in the question.
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 5, 3, 1, 4, 9]
 * Input 2:
 *
 *  A = [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  16
 * Output 2:
 *
 *  6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All possible triplets are:-
 *     2 3 4 => sum = 9
 *     2 5 9 => sum = 16
 *     2 3 9 => sum = 14
 *     3 4 9 => sum = 16
 *     1 4 9 => sum = 14
 *   Maximum sum = 16
 * Explanation 2:
 *
 *  All possible triplets are:-
 *     1 2 3 => sum = 6
 *  Maximum sum = 6
 *  \
 *  \\\\
 */
public class MaxSumOfTriplet {

    public static void main(String[] args) {
      int a[] = {18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146, 23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605}; //expected 88252
       // int a[] = {2, 5, 3, 1, 4, 9}; // expected 16
       //int []a = {32592, 18763, 1656, 17411, 6360, 27625, 20538, 21549, 6484, 27596}; //expected : 69683
        MaxSumOfTriplet maxSumOfTriplet = new MaxSumOfTriplet();
        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i < a.length ; i++){
            list.add(a[i]);
        }
        int sum = maxSumOfTriplet.solve(list);
        System.out.println(sum);
    }
    public int solve(List<Integer> A) {
        int n = A.size();
        // Initialize Maximum, second maximum and third
        int maxSuffixList[] = new int[n];
        maxSuffixList[n-1] = A.get(n -1);
        for(int index = n -2; index >= 0 ; index--){
            if(A.get(index) > maxSuffixList[index+1]){
                maxSuffixList[index] =  A.get(index);
            }else{
                maxSuffixList[index]  = maxSuffixList[index +1];
            }
        }
        int maxSum = 0;
        TreeSet<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());
        set.add(A.get(0));
        for(int j = 1 ; j < n -1; j ++){
            int leftElement = findLeftElement(set, A.get(j));
            int middleElement = A.get(j);
            int rightElement =  maxSuffixList[j+1];
            if( leftElement != -1 && rightElement > middleElement){
                int sum = leftElement + middleElement + rightElement;
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
            set.add(A.get(j));
        }
        return maxSum;
    }

    private int findLeftElement(TreeSet<Integer> set, Integer element) {
        Stream<Integer> stream = set.stream();
       return stream.filter(item -> item < element).findFirst().orElse(-1);
    }
}
