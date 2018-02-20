package org.manas.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohanty on 12-10-2016.
 * Count ways to reach the n’th stair
 There are n stairs, a person standing at the bottom wants to reach the top.
 The person can climb either 1 stair
 or 2 stairs at a time. Count the number of ways, the person can reach the top.
 */
public class StairCaseNumberFinder {

    private static int totalPosition;
    public static void main(String[] args) {
        int totalStairs = 4;
        int currentPosition = 0;
        countNoOfWaysToClimbUpStairs(totalStairs, currentPosition);
        System.out.println(totalPosition);
        List<String> strList = new ArrayList<String>();
        strList.parallelStream();
    }

    private static void countNoOfWaysToClimbUpStairs(int totalStairs, int currentPosition){
        if(totalStairs == currentPosition){
            totalPosition++;
            return;
        }else if(currentPosition > totalStairs){
            return;
        }else{
            countNoOfWaysToClimbUpStairs(totalStairs, currentPosition+1);
            countNoOfWaysToClimbUpStairs(totalStairs, currentPosition+2);
        }
    }
}
