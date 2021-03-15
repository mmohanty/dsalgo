package org.manas.dsalgo.interviewbit.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using
 * less than O(n) space and traversing the stream sequentially O(1) times.
 *
 * Sample Input:
 *
 * [3 4 1 4 1]
 * Sample Output:
 *
 * 1
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 *
 * If there is no duplicate, output -1
 */
public class FindDuplicateInArray {
    public static void main(String[] args) {

        int a[] = {3, 4, 1, 4, 1};
        List<Integer> list = ArrayUtil.toList(a);
        FindDuplicateInArray duplicateInArray = new FindDuplicateInArray();
        int element = duplicateInArray.repeatedNumber(list);
        System.out.println(element);
    }

    public int repeatedNumber(final List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < a.size(); index++){
            if(map.containsKey(a.get(index))){
                return  a.get(index);
            }else{
                map.put(a.get(index), 1);
            }
        }
        return  -1;
    }
}
