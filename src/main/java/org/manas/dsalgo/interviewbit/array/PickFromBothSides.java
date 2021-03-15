package org.manas.dsalgo.interviewbit.array;

import java.util.*;

public class PickFromBothSides {
    public static void main(String[] args) {

        PickFromBothSides pickFromBothSides = new PickFromBothSides();
        ArrayList<Integer> list = new ArrayList<>();

        int []a = {5, -3, 0 , 8, 1, 2};
        int b =3;
        // expected 8

        //int []a = {5, -2, 3 , 1, 2};
        //int b =3;
        // expected 8

        //int []a = {1, 2};
        //int b =1;
        //expected 2

        //int []a = {556, 993, -824, 705, -38, -452, 881, -700, -587, -359, 855, -145, 142, 462, 611, -123, -576, -322, 752, -557, -704, -327, -960, 313, -125, -928, -182, -390, 17, -68, -888, -305, 169, 831, -960, -512, -315, 90, 497, -411, 990, 145, 353, 314, -349, -260, -956, 258, -665, -241, 192, 605, 264, -819};
        //int b = 46;
        //expected -583

        for(int element: a){
            list.add(element);
        }

        int sum = pickFromBothSides.solve(list,b);
        System.out.println(sum);

    }

    public int solve(ArrayList<Integer> A, int B) {

        int n = A.size();

        int result = 0;

        for (int i = 0; i < B; i++) {
            result += A.get(i);
        }

        int sum = result;

        for (int i = 0; i < B; i++) {
            sum -= A.get(B - 1 - i);
            sum += A.get(n - 1 - i);

            result = Math.max(result, sum);
        }

        return result;
    }


}
