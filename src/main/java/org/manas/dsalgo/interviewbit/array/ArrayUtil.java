package org.manas.dsalgo.interviewbit.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    public static List<Integer> toList(int []a){
        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i < a.length ; i++){
            list.add(a[i]);
        }
        return list;
    }
}
