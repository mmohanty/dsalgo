package org.manas.dsalgo.interviewbit.binarysearch;

/**
 * Given an integar A.
 *
 * Compute and return the square root of A.
 *
 * If A is not a perfect square, return floor(sqrt(A)).
 *
 * DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 *
 *
 *
 * Input Format
 *
 * The first and only argument given is the integer A.
 * Output Format
 *
 * Return floor(sqrt(A))
 * Constraints
 *
 * 1 <= A <= 10^9
 * For Example
 *
 * Input 1:
 *     A = 11
 * Output 1:
 *     3
 *
 * Input 2:
 *     A = 9
 * Output 2:
 *     3
 */
public class SquareRootOfInteger {

    public static void main(String[] args) {
        SquareRootOfInteger squareRootOfInteger = new SquareRootOfInteger();
        System.out.println(squareRootOfInteger.sqrt(11));
    }

    public int sqrt(int A) {

        if(A<=1) return A;
        int  l=0,r=A,mid,x,y;
        while(l<r){
            mid = (l+r)/2;
            // x and y is used to check for floor value.
            x = mid*mid;
            y = (mid+1)*(mid+1);
            if(x==A||x<A && y>A) return mid;
            if(x<A) l=mid+1;
            else r = mid;
        }
        return l;
    }
}
