package org.manas.dsalgo.interviewbit.array;

import java.util.ArrayList;

/**
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN.
 * In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and
 * flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
 * If you don’t want to perform the operation, return an empty array. Else, return an array consisting of
 * two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of
 * L and R.
 *
 * Notes:
 *
 * Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 * For example,
 *
 * S = 010
 *
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | 110
 * [1 2]          | 100
 * [1 3]          | 101
 * [2 2]          | 000
 * [2 3]          | 001
 *
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 * Another example,
 *
 * If S = 111
 *
 * No operation can give us more than three 1s in final string. So, we return empty array [].
 */
public class Flip {
    public static void main(String[] args) {
        Flip flip = new Flip();
        //String a = "01010110";//Expected 1 1

        //String a = "010";//Expected 1 1
        //String a = "111";//Expected Empty
        //String a = "110";//Expected 3 3
        //String a = "101";//Expected 2 2
        //String a = "100101101";//Expected 2 3
        //String a = "0111000100010"; // expected 5 11
        String a = "0001000101010101"; //Expected 1 7
        ArrayList<Integer> response = flip.flip(a);
        response.stream().forEach(item -> System.out.print(item + " "));
    }

    public ArrayList flip(String A) {
        int zero_minus_one = 0;
        int max_zero_minus_one = 0;
        int start_index = 0;
        int end_index = 0;

        ArrayList result_list = new ArrayList();
        for (int i = 0; i < A.length(); i++) {
            int digit_at_i = A.charAt(i) - '0';
            if (digit_at_i == 0) {
                zero_minus_one++;
                if (max_zero_minus_one < zero_minus_one) {
// there is a new max, adjust end to here
// and record the window. The check above
// is less_than, and not less_than_equal
// this guarantees lexical ordering
                    max_zero_minus_one = zero_minus_one;
                    end_index = i;
                    result_list.clear();
                    result_list.add(0, start_index + 1);
                    result_list.add(1, end_index + 1);
                }
            } else { // digit == 1
                if (zero_minus_one == 0) {
// equal number of 0s and 1s
// so start from next digit
// to see if we can find max there
                    start_index = i + 1;
                } else {
                    zero_minus_one--;
                }
            }
        }
        return result_list;
    }
}
