package org.manas.dsalgo.interviewbit.math;

import org.manas.dsalgo.interviewbit.array.ArrayUtil;

import java.util.List;

/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 *
 * Example:
 *
 * Input : [1, 0]
 * Return : [0, 1]
 *  Lets say N = size of the array. Then, following holds true :
 * All elements in the array are in the range [0, N-1]
 * N * N does not overflow for a signed integer
 */
public class RearrangeArray {

    public static void main(String[] args) {
        RearrangeArray rearrangeArray = new RearrangeArray();
        int arr[] = new int[]{3, 2, 0, 1};
        List<Integer> list = ArrayUtil.toList(arr);
        rearrangeArray.arrange(list);

        list.stream().forEach(item -> {
            System.out.println(item);
        });
    }

    public void arrange(List<Integer> a) {

        int n = a.size();
        // First step: Increase all values by (arr[arr[i]]%n)*n
        for (int i = 0; i < n; i++){
            int temp = a.get(i) + (a.get(a.get(i)) % n) * n;
            a.set(i, temp);
        }
        // Second Step: Divide all values by n
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }
    }
}
