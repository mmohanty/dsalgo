package org.manas.dsalgo.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDuplicateElemntFinder {

    private DuplicateFinder duplicateFinder;

    @Before
    public void doSetup(){
        duplicateFinder = new DuplicateFinder();
    }

    @Test
    public void testDuplicateElemnts(){
        int[] input = {1, 2, 3, 1, 3, 6, 6};
        StringBuilder expected = new StringBuilder();
        expected.append(136);
        StringBuilder output = duplicateFinder.getDuplicateElements(input);
        Assert.assertEquals(expected.toString(), output.toString());
    }
}
