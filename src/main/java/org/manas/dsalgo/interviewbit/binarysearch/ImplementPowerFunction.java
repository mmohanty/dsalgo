package org.manas.dsalgo.interviewbit.binarysearch;

/**
 *
 */
public class ImplementPowerFunction {
    public static void main(String[] args) {
        ImplementPowerFunction implementPowerFunction = new ImplementPowerFunction();

        int x = 71045970;
        int y = 41535484;
        int d = 64735492;

        System.out.println(implementPowerFunction.pow(x, y, d));
    }

    public int pow(int x, int y, int p) {

        long a = x;
        int b = y;

        Long res = Long.valueOf(1); // Initialize result

        a = a % p; // Update x if it is more than or
        // equal to p

        if (a == 0)
            return 0; // In case x is divisible by p;

        while (b > 0)
        {

            // If y is odd, multiply x with result
            if ((b & 1) != 0)
                res = (res  * a ) % p;

            // y must be even now
            b = b >> 1; // y = y/2
            a = (a * a ) % p;
        }
        return res.intValue() < 0 ? p + res.intValue() : res.intValue();
    }

}
