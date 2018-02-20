package org.manas.airthmetic;

/**
 * Created by mohanty on 14-08-2016.
 */
public class Calculator {

    public int add(int num1, int num2){
        while (num2 != 0){
            int carry = num1 & num2;
            num1 = num1 ^ num2;
            num2 = carry << 1;
        }
        return num1;
    }
}
