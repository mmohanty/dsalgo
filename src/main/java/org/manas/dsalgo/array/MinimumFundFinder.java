package org.manas.dsalgo.array;

/**
 * Given an array of integer. Find out initial amount required to clear tolls.
 * At any point balance can not be negative. If all elements are positive then
 * minimum balance would be 1. When you left all toll you should have at least 0 balance.
 * e.g [1,2,3] -> 1
 * e.g. [2,-6,3,-8, 7] -> 9 as 9 + 2 + (-6) + 3 + (-8) + .. +ve integers >=0
 * Created by mohanty on 27-09-2016.
 */
public class MinimumFundFinder {

    public static void main(String[] args) {
        MinimumFundFinder fundFinder = new MinimumFundFinder();
        int result = fundFinder.findMinimumFundRequiredToClearTolls(new int[]{2,-6,3,-8, 7});
        System.out.println(result);
    }
    public int findMinimumFundRequiredToClearTolls(int []arr){
        int totalSum = 0;
        int minimumBalance = 0;

        for(int item : arr){
            int currentSum = totalSum+item;
            totalSum += item;
            if(currentSum < 0){
                minimumBalance += Math.abs(currentSum);
                totalSum += Math.abs(currentSum);
            }
        }

        return minimumBalance == 0 ? 1 : minimumBalance;
    }
}
