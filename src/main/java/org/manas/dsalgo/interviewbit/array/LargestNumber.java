package org.manas.dsalgo.interviewbit.array;

import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        //int []A = {3, 30, 34, 5, 9};
        int []A = {0, 0, 0, 0, 0};
        String str  = largestNumber.largestNumber(A);
        System.out.println(str);
    }

    public String largestNumber(final int[] a) {
        StringBuilder finalOutput = new StringBuilder();

        List<String> list = new ArrayList<>();
        int index =0;
        int noOfZeros = 0;
        for(int element: a){
            if(element == 0){
                noOfZeros++;
            }
            list.add(a[index++]+"");
        }
        if(noOfZeros == a.length){
            return "0";
        }

        Collections.sort(list, new Comparator<String>()
        {
            // A comparison function which is used by
            // sort() in printLargest()
            @Override
            public int compare(String X, String Y)
            {

                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;

                // Now see which of the two
                // formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        for(Object obj: list){
            finalOutput.append(obj.toString());
        }
        return finalOutput.toString();
    }
}
