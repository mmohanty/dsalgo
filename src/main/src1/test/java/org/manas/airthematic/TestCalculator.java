package org.manas.airthematic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.manas.airthmetic.Calculator;

/**
 * Created by mohanty on 14-08-2016.
 */
public class TestCalculator {
    private Calculator calculator;
    @Before
    public void init(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
        int sum = calculator.add(10,19);
        Assert.assertSame(29, sum);
    }
}
