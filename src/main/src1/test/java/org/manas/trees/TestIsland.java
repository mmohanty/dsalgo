package org.manas.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mohanty on 19-09-2016.
 */
public class TestIsland {

    private Island island;

    @Before
    public void init(){
        island = new Island();
    }

    @Test
    public void testIslandCount(){
        int arr[][] = buildArray();
        int output = island.findIsland(arr,4,5);
        Assert.assertSame(1, output);
    }

    private int[][] buildArray() {
        int arr[][] = {{1, 1, 1, 1, 0},{1, 1, 0, 1, 0},{1, 1, 0, 0, 0},{0, 0, 0, 0, 0}};
        return arr;
    }
}
