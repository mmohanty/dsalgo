package org.manas.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by mohanty on 28-07-2016.
 */
public class TestMergeSort {

    private MergeSort mergeSort;

    @Before
    public void init(){
        mergeSort = new MergeSort();
    }

    @Test
    public void testMergeSort(){
        int arr[] = new int[]{34, 2, 17, 10, 8, 23};
        mergeSort.sort(arr, 0, arr.length - 1);
        System.out.print(arr);
    }
}
