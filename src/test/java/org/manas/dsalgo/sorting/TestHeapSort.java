package org.manas.dsalgo.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHeapSort {

    private HeapSort heapSort;

    @Before
    public void doSetup(){
        heapSort = new HeapSort();
    }

    @Test
    public void test_Sorting_when_elements_are_in_order(){
        int[] arrIn = {1,2,3,4,5,6};
        int[] arrOut = {1,2,3,4,5,6};

        heapSort.sort(arrIn);

        Assert.assertArrayEquals(arrOut,arrIn);
    }
}
