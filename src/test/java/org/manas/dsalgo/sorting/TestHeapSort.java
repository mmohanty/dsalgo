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
    public void testSorting_When__elements_are_in_order(){
        int a[] = {1,2,3,4,5,6};
        int []expected = {1,2,3,4,5,6};
        heapSort.sort(a);
        Assert.assertArrayEquals(expected, a);
    }
}
