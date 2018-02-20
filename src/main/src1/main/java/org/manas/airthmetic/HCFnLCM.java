package org.manas.airthmetic;

/**
 * Created by mohanty on 14-08-2016.
 */
public class HCFnLCM {

    public int lcm(int num1, int num2){
        int a =  hcf(num1, num2);
        return (num1 * num2)/a;
    }

    public int hcf(int num1, int num2){
        int a = num1;
        int b = num2;

        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
