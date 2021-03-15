package org.manas.dsalgo.interviewbit.array;

import java.util.ArrayList;

/**
 * Given an array of real numbers greater than zero in form of strings.
 * Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
 * Return 1 for true or 0 for false.
 *
 * Example:
 *
 * Given [0.6, 0.7, 0.8, 1.2, 0.4] ,
 *
 * You should return 1
 *
 * as
 *
 * 0.6+0.7+0.4=1.7
 *
 * 1<1.7<2
 *
 * Hence, the output is 1.
 *
 * O(n) solution is expected.
 *
 * Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no
 * leading zeroes in numbers.
 * Extra memory usage is allowed.
 */
public class TripletsWithSumBetweenGivenRange {


    public static void main(String[] args) {
        String []str = {"0.6", "0.7", "0.8", "1.2", "0.4"};
        ArrayList<String> list = new ArrayList<>();
        for(String s:str){
            list.add(s);
        }

        TripletsWithSumBetweenGivenRange tripletsWithSumBetweenGivenRange = new TripletsWithSumBetweenGivenRange();
        int result = tripletsWithSumBetweenGivenRange.solve(list);
        System.out.println(result);
    }
    public int solve(ArrayList<String> A) {
        Double a= Double.parseDouble(A.get(0));//arr[0],
        Double b = Double.parseDouble(A.get(1));// b=arr[1],
        Double c = Double.parseDouble(A.get(2));// c=arr[2];

        Double one = Double.parseDouble("1");
        Double two = Double.parseDouble("2");

        int n = A.size();
        for(int i=3 ; i<n ; i++){
            // check if sum fall in (1, 2)
            Double sum = a + b + c;
            if(sum.compareTo(one) > 0 && sum.compareTo(two) < 0){
                return 1;
            }
            // if not, then check is sum greater than 2
            // if so, then replece MAX(a,b,c) to new number
            else if(sum.compareTo(two) > 0){
                if( a.compareTo(b) > 0 && a.compareTo(c)>0){
                    a = Double.parseDouble(A.get(i));
                }
                else if(b.compareTo(a)>0 && b.compareTo(c)>0){
                    b = Double.parseDouble(A.get(i));
                }
                else if(c.compareTo(a)>0 && c.compareTo(b)>0){
                    c = Double.parseDouble(A.get(i));
                }
            }
            // else then sum must be less than 1
            // then replace MIN(a,b,c) to new number
            else{
                if(a.compareTo(b)<0 && a.compareTo(c)<0){
                    a = Double.parseDouble(A.get(i));
                }
                else if(b.compareTo(a)<0 && b.compareTo(c)<0){
                    b = Double.parseDouble(A.get(i));
                }
                else if(c.compareTo(a)<0 && c.compareTo(b)<0){
                    c = Double.parseDouble(A.get(i));
                }
            }
        }
// check for last a, b, c  triplet
        Double sum = a + b +c;
        if(sum.compareTo(one) > 0 && sum.compareTo(two) < 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
