package org.manas.dsalgo.interviewbit.binarysearch;

import org.manas.dsalgo.interviewbit.array.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a matrix of integers A of size N x M in which each row is sorted.
 *
 * Find an return the overall median of the matrix A.
 *
 * Note: No extra memory is allowed.
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 *
 *
 *
 * Input Format
 *
 * The first and only argument given is the integer matrix A.
 * Output Format
 *
 * Return the overall median of the matrix A.
 * Constraints
 *
 * 1 <= N, M <= 10^5
 * 1 <= N*M  <= 10^6
 * 1 <= A[i] <= 10^9
 * N*M is odd
 * For Example
 *
 * Input 1:
 *     A = [   [1, 3, 5],
 *             [2, 6, 9],
 *             [3, 6, 9]   ]
 * Output 1:
 *     5
 * Explanation 1:
 *     A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 *     Median is 5. So, we return 5.
 *
 * Input 2:
 *     A = [   [5, 17, 100]    ]
 * Output 2:
 *     17 ``` Matrix=
 */
public class MatrixMedian {
    public static void main(String[] args) {
        MatrixMedian matrixMedian = new MatrixMedian();

        List<List<Integer>> input= new ArrayList<>();
        input.add(ArrayUtil.toList(new int[]{1, 3, 5}));
        input.add(ArrayUtil.toList(new int[]{2, 6, 9}));
        input.add(ArrayUtil.toList(new int[]{3, 6, 9}));
        int result = matrixMedian.findMedian(input);
        System.out.println(result);
    }

    public int findMedian(List<List<Integer>> matrix) {

        int row = matrix.size();
        int column = matrix.get(0).size();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i< row ; i++)
        {

            // Finding the minimum element
            if( matrix.get(i).get(0) < min)
                min = matrix.get(i).get(0);

            // Finding the maximum element
            if(matrix.get(i).get(column-1) > max)
                max = matrix.get(i).get(column-1);
        }

        int desired = (row * column + 1) / 2;
        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;

            // Find count of elements smaller than mid
            for(int i = 0; i < row; ++i)
            {

                get = Collections.binarySearch( matrix.get(i),mid);

                // If element is not found in the array the
                // binarySearch() method returns
                // (-(insertion_point) - 1). So once we know
                // the insertion point we can find elements
                // Smaller than the searched element by the
                // following calculation
                if(get < 0)
                    get = Math.abs(get) - 1;

                    // If element is found in the array it returns
                    // the index(any index in case of duplicate). So we go to last
                    // index of element which will give  the number of
                    // elements smaller than the number including
                    // the searched element.
                else
                {
                    while(get < matrix.get(i).size() && matrix.get(i).get(get) == mid)
                        get += 1;
                }

                place = place + get;
            }

            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }
}
