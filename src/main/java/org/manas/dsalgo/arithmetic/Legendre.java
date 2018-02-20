package org.manas.dsalgo.arithmetic;

import java.util.List;

/**
 * Created by mohanty on 24-09-2016.
 */
public class Legendre {

    /**
     * Input : n = 4
     Output: 24
     4! is 24. Divisors of 24 are 1, 2, 3, 4, 6,
     8, 12 and 24.

     Input : n = 5
     Output : 16
     5! is 120. Divisors of 120 are 1, 2, 3, 4,
     5, 6, 8, 10, 12, 15, 20, 24 30, 40, 60 and
     120
     * @return
     */

    public static void main(String[] args) {
        Legendre legendre = new Legendre();
        int result = legendre.countDivisorsOfFactorial(5);
        System.out.println(result);
    }
    public int countDivisorsOfFactorial(int num){
        SeivesPrimeNumberFinder sv = new SeivesPrimeNumberFinder();
        List<Integer> list = sv.getAllPrimeNumbers(num);
        int result = 1;

        for(Integer primeNumber : list){
            int exp = 0;
            int prime = primeNumber;
            while(prime <= num){
                exp = exp + (num/prime);
                prime = prime * primeNumber;
            }
            result = result * (exp +1);
        }
        return result;
    }
}
