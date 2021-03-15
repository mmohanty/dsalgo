package org.manas.dsalgo.interviewbit.array;

import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 *
 * Example
 *
 * Given [1, 2, 3, 4]
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 *  NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
 * So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {

    public static void main(String[] args) {
        int a[] = {1, 2, 3}; // expected [2, 1, 4, 3]
        List<Integer> input = ArrayUtil.toList(a);

        WaveArray waveArray = new WaveArray();

        List result = waveArray.wave(input);

        result.stream().forEach(item -> System.out.print( item + " "));

    }

    public List<Integer> wave(List<Integer> A) {

        Collections.sort(A);

        for(int firstIndex = 0, secondIndex =1; firstIndex < A.size() -1 || secondIndex < A.size() -1;
            firstIndex = firstIndex +2,secondIndex = secondIndex +2){
            swap(A, firstIndex, secondIndex);
        }
        return  A;
    }

    void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
