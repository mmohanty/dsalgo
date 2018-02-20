package org.manas.dsalgo.array;

/**
 * Find minimum sum of array of each three adjacent numbers.
 * e.g. 1,2,3,4,5,1
 * 1,2,3
 * 2,3,4
 * 3,4,5
 * 4,5,1
 *
 * Take 3 as its getting repeated in first three sub arrays.
 * Take 1 from last sub array. Sum would be 3 + 1 = 4
 * Created by mohanty on 27-09-2016.
 */
public class MinimumSumOfEachThreeConsecutiveNumbers {

    public static void main(String[] args) {
        MinimumSumOfEachThreeConsecutiveNumbers ms = new MinimumSumOfEachThreeConsecutiveNumbers();
        int sum = ms.findMinimumSumOfEachThreeConsecutiveNumbers(new int[]{1,2,3,4,5,1});
        System.out.println(sum);
    }

    public int findMinimumSumOfEachThreeConsecutiveNumbers(int []arr){
        if(arr.length == 1){
            return arr[0];
        }else if (arr.length ==2){
            return  Math.min(arr[0], arr[1]);
        }else if(arr.length == 3){
            return Math.min(Math.min(arr[0], arr[1]), arr[2]);
        }else{
            int []sum = new int[arr.length];
            sum[0] = arr[0];
            sum[1] = arr[1];
            sum[2] = arr[2];

            for(int index = 3; index < arr.length ; index++){
                sum[index] = arr[index] + Math.min(Math.min(arr[index-1], arr[index-2]), arr[index-3]);
            }
            int length = arr.length;
            return Math.min(Math.min(sum[length-1], sum[length-2]), sum[length-3]);
        }
    }
}
