package org.manas.dsalgo.interviewbit.math;

/**
 * Problem Description
 *
 * Given an integer A you need to find the Ath fibonacci number modulo 109 + 7.
 *
 * The first fibonacci number F1 = 1
 *
 * The first fibonacci number F2 = 1
 *
 * The nth fibonacci number Fn = Fn-1 + Fn-2 (n > 2)
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109.
 *
 *
 *
 * Input Format
 * First argument is an integer A.
 *
 *
 *
 * Output Format
 * Return a single integer denoting Ath fibonacci number modulo 109 + 7
 */
public class FindNthFibonacci {

    static int[] dp;

    static int MODULO = 1000000007;

    public static void main(String[] args) {
        FindNthFibonacci findNthFibonacci = new FindNthFibonacci();
        int num = findNthFibonacci.solve(50); //expected 586268941 for 50

        System.out.println(num);
    }

    public int solve(int n) {
        int F[][] = new int[][]{{1,1},{1,0}};
        if (n == 0)
            return 0;
        power(F, n-1);

        return F[0][0];

    }
    static void power(int F[][], int n)
    {
        if( n == 0 || n == 1)
            return;
        int M[][] = new int[][]{{1,1},{1,0}};

        power(F, n/2);
        multiply(F, F);

        if (n%2 != 0)
            multiply(F, M);
    }

    static void multiply(int F[][], int M[][])
    {
        long modulo = 1000000007l;

        long x = ((((F[0][0] % modulo) * (M[0][0] % modulo)) % modulo) + (F[0][1]*M[1][0] % modulo)) % modulo;
        long y = ((((F[0][0] % modulo) * (M[0][1] % modulo)) % modulo) + (F[0][1]*M[1][1] % modulo)) % modulo ;
        long z = ((((F[1][0]% modulo ) * (M[0][0] % modulo)) % modulo) + (F[1][1]*M[1][0] % modulo)) % modulo;
        long w = ((((F[1][0] % modulo) * (M[0][1] % modulo)) % modulo) + (F[1][1]*M[1][1] % modulo)) % modulo;

        F[0][0] = (int)x;
        F[0][1] = (int)y;
        F[1][0] = (int)z;
        F[1][1] = (int)w;
    }

}
