package org.manas.dsalgo.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohanty on 23-09-2016.
 */
public class SeivesPrimeNumberFinder {

    public static void main(String[] args) {
        SeivesPrimeNumberFinder sv = new SeivesPrimeNumberFinder();
        List<Integer> result = sv.getAllPrimeNumbers(5);

        for(Integer i : result){
            System.out.println(i);
        }
    }
    public List<Integer> getAllPrimeNumbers(int maxNumber){
        Boolean []numberTrack = new Boolean[maxNumber+1];
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 2; i <= maxNumber ; i ++){
            numberTrack[i] = true;
        }
        for(int start=2; start * start <= maxNumber ; start++){
            // If prime[p] is not changed, then it
            // is a prime
            if (numberTrack[start] == true)
            {
                // Update all multiples of p
                for (int i=start*2; i <= maxNumber; i += start)
                    numberTrack[i] = false;
            }
        }

        for(int i = 2 ; i < numberTrack.length; i++){
            if(numberTrack[i]){
                list.add(i);
            }
        }
        return  list;
    }
}
