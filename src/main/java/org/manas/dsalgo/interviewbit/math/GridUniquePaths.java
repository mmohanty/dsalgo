package org.manas.dsalgo.interviewbit.math;

/**
 * A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).
 *
 * Path Sum: Example 1
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
 *
 * Example :
 *
 * Input : A = 2, B = 2
 * Output : 2
 *
 * 2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 *               OR  : (0, 0) -> (1, 0) -> (1, 1)
 */
public class GridUniquePaths {

    static int possiblePath =0;
    public static void main(String[] args) {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        int a =3;
        int b =3; //expected 2

        System.out.println(gridUniquePaths.uniquePaths(a, b));
    }

    public int uniquePaths(int A, int B) {
        int n = A;
        int m = B;
        // We have to calculate m+n-2 C n-1 here
        // which will be (m+n-2)! / (n-1)! (m-1)!
        int path = 1;
        for (int i = n; i < (m + n - 1); i++) {
            path *= i;
            path /= (i - n + 1);
        }
        return path;
    }

}
