package org.manas.dsalgo.interviewbit.math;

import java.util.ArrayList;

/**
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 *
 * NOTE A solution will always exist. read Goldbach’s conjecture
 *
 * Example:
 *
 *
 * Input : 4
 * Output: 2 + 2 = 4
 *
 * If there are more than one solutions possible, return the lexicographically smaller solution.
 *
 * If [a, b] is one solution with a <= b,
 * and [c,d] is another solution with c <= d, then
 *
 * [a, b] < [c, d]
 *
 * If a < c OR a==c AND b < d.
 */
public class PrimeSum {

    public static void main(String[] args) {
        PrimeSum primeSum = new PrimeSum();
        int a = 4;
        ArrayList<Integer> result = primeSum.primesum(a);
        result.stream().forEach(item-> System.out.println(item + " "));
    }

    public ArrayList<Integer> primesum(int A) {
        int n =A;
        ArrayList<Integer> list = new ArrayList<>();
        boolean isPrime[]=new boolean[n + 1];
        SieveOfEratosthenes(n, isPrime);

        // Traversing all numbers to find first
        // pair
        for (int i = 0; i < n; i++)
        {
            if (isPrime[i] && isPrime[n - i])
            {
                //System.out.print(i + " " + (n - i));
                list.add(i);
                list.add(n-i);
                return list;
            }
        }
        return list;
    }


    // Generate all prime numbers less than n.
    boolean SieveOfEratosthenes(int n, boolean isPrime[])
    {
        // Initialize all entries of boolean
        // array as true. A value in isPrime[i]
        // will finally be false if i is Not a
        // prime, else true bool isPrime[n+1];
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        for (int p = 2; p * p <= n; p++)
        {
            // If isPrime[p] is not changed,
            // then it is a prime
            if (isPrime[p] == true)
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    isPrime[i] = false;
            }
        }
        return false;
    }


}
