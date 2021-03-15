package org.manas.dsalgo.interviewbit.array;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a positive integer n and a string s consisting only of letters D or I,
 * you have to find any permutation of first n positive integer that satisfy the given input string.
 *
 * D means the next number is smaller, while I means the next number is greater.
 *
 * Notes
 *
 * Length of given string s will always equal to n - 1
 * Your solution should run in linear time and space.
 * Example :
 *
 * Input 1:
 *
 * n = 3
 *
 * s = ID
 *
 * Return: [1, 3, 2]
 */
public class FindPermutation {

    public static void main(String[] args) {

        String s = "DI";
        int n =3;
        FindPermutation findPermutation = new FindPermutation();

        ArrayList<Integer> list = findPermutation.findPerm(s, n);
        list.stream().forEach(item -> System.out.println(item + " "));

    }


    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList result = new ArrayList();
        Stack<Integer> stk = new Stack<>();

        // run n+1 times where n is length of input sequence
        for (int i = 0; i <= A.length(); i++) {
            // push number i+1 into the stack
            stk.push(i + 1);

            // if all characters of the input sequence are
            // processed or current character is 'I'
            // (increasing)
            if (i == A.length() || A.charAt(i) == 'I') {
                // run till stack is empty
                while (!stk.empty()) {
                    // remove top element from the stack and
                    // add it to solution
                    //result += String.valueOf(stk.peek());
                    //result += " ";
                    result.add(stk.peek());
                    stk.pop();
                }
            }

        }
        return result;
    }
}
