package org.manas.dsalgo.interviewbit.array;

/**
 * Problem Description
 *
 * There is a corridor in a Jail which is N units long. Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.
 *
 * All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].
 *
 * Initially all lights are off.
 *
 * Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000
 *
 * 1 <= B <= 1000
 *
 *
 *
 * Input Format
 * First argument is an integer array A where A[i] is either 0 or 1.
 *
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [ 0, 0, 1, 1, 1, 0, 0, 1].
 * B = 3
 * Input 2:
 *
 * A = [ 0, 0, 0, 1, 0].
 * B = 3
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * In the first configuration, Turn on the lights at 3rd and 8th index.
 * Light at 3rd index covers from [ 1, 5] and light at 8th index covers [ 6, 8].
 * Explanation 2:
 *
 * In the second configuration, there is no light which can light the first corridor.
 */
public class MinimumLightsToActivate {

    public static void main(String[] args) {
        MinimumLightsToActivate activate = new MinimumLightsToActivate();
        //int []a = {0, 0, 1, 1, 1, 0, 0, 1};
        //int b = 3;
        //expected 2

        int []a = {0, 0, 0, 1, 0};
        int b = 3;
        //expected -1
        int result = activate.solve(a,b);
        System.out.println(result);
    }

    public int solve(int[] A, int B) {

        int n = A.length;
        int i = 0;
        int result = 0;
        boolean flag = false;
        while (i < n) {
            int a = Math.max(0, i - B + 1);
            int b = Math.min(n - 1, i + B - 1);
            for (; b >= a; b--)
            {
                if (A[b] == 1) {
                    result++;
                    flag = true;
                    i = b + B;
                    break;
                }
            }
            if (!flag) {
                return -1;
            }
            flag = false;
        }
        return result;
    }
}
