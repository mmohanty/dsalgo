package org.manas.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.manas.sort.HeapSort;

/**
 * Created by mohanty on 27-07-2016.
 */
public class TestHeapSort {
    private HeapSort heapSort;


    @Before
    public void init(){
        heapSort = new HeapSort();
    }

    @Test
    public void testHeapSort(){
        //when
        int [] arr = new int[]{12,34,5,4,19,7};

        heapSort.sort(arr);

        Assert.assertSame(4, arr[0]);
        Assert.assertSame(5, arr[1]);
        Assert.assertSame(7, arr[2]);
        Assert.assertSame(12, arr[3]);
        Assert.assertSame(19, arr[4]);
        Assert.assertSame(34, arr[5]);
    }
}
