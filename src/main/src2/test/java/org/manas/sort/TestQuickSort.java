package org.manas.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mohanty on 27-07-2016.
 */
public class TestQuickSort {

    private QuickSort quickSort;

    @Before
    public void init(){
        quickSort = new QuickSort();
    }

    @Test
    public void testQuickSort(){
        //when
        int [] arr = new int[]{11,33,4,5,6,20,7};

        quickSort.sort(arr, 0, arr.length -1 );

        Assert.assertSame(5, arr[0]);
        Assert.assertSame(6, arr[1]);
        Assert.assertSame(7, arr[2]);
        Assert.assertSame(11, arr[3]);
        Assert.assertSame(20, arr[4]);
        Assert.assertSame(33, arr[5]);
    }

}
