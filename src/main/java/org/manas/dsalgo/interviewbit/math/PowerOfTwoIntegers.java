package org.manas.dsalgo.interviewbit.math;

/**
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as
 * A^P where P > 1 and A > 0. A and P both should be integers.
 *
 * Example
 *
 * Input : 4
 * Output : True
 * as 2^2 = 4.
 */
public class PowerOfTwoIntegers {

    public static void main(String[] args) {
        PowerOfTwoIntegers powerOfTwoIntegers = new PowerOfTwoIntegers();
        System.out.println(powerOfTwoIntegers.isPower(536870912));//expected 1
    }

    public int isPower(int a) {
        if(a==1) return 1;
        for (int i = 2; i*i <= a; i++) {
            int p = a;
            int count =0;
            while(p%i == 0){
                count++;
                p/=i;
            }
            if(p == 1) {
                return 1;
            }
        }
        return 0;
    }

    public boolean isPower1_givingwrong(int a) {

        double p ;
        if(a==1) {
            return true;
        }
        for (int i = 2; i*i <= a; i++) {
            p = Math.log(a) / Math.log(i);

            if ((Math.ceil(p) == Math.floor(p)) && p > 1)
            {
                return true;
            }
        }
        return false;
    }
}
