package org.manas.dsalgo.array.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new Solution();


       double d =  solution.findMedianSortedArrays(new int[] {1,2}, new int[]{4});
        System.out.println(d);
    }
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i =0;
        int j = 0;
        double sum =0;

        for(; i< nums1.length && j < nums2.length; i++, j++){
            int element1 = nums1[i];
            int element2 = nums2[j];
            sum += element1 + element2;
        }
        if(i < nums1.length){
            while(i < nums1.length){
                int element1 = nums1[i];
                sum += element1;
                i++;
            }



        }

        if(j < nums2.length){
            while(i < nums2.length){
                int element2 = nums2[i];
                sum += element2;
                j++;
            }


        }

        Double median = sum / (i+j);
        String str =median.toString();
        String []token = str.split("\\.");
        StringBuilder builder = new StringBuilder();
        if(Integer.valueOf(token[1].substring(0,1)) == 5){
            builder.append(token[0]);
            builder.append(".");
            builder.append("50000");
        }else if(Integer.valueOf(token[1].substring(0,1)) < 5){
            builder.append(token[0]);
            builder.append(".");
            builder.append("00000");
        }else
        {
            builder.append(Integer.valueOf(token[0]) +1);
            builder.append(".");
            builder.append("00000");
        }
        DecimalFormat df = new DecimalFormat(".#####");
        df.format(Double.valueOf(builder.toString()));
        return median;
    }
}