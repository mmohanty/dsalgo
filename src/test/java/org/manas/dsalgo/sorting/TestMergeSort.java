package org.manas.dsalgo.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMergeSort {

    private MergeSort mergeSort;

    @Before
    public void doSetup(){
        mergeSort = new MergeSort();
    }

    @Test
    public void test_Sorting_when_elements_are_in_natural_order(){
        int[] input = {1,2,3,4,5,6};
        mergeSort.sort(input, 0, input.length-1);
        int[] expected = {1,2,3,4,5,6};
        Assert.assertArrayEquals(expected, input);
    }
}
