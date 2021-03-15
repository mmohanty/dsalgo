package org.manas.dsalgo.arithmetic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mohanty on 14-08-2016.
 */
public class TestHCFnLCM {

    private HCFnLCM hcFnLCM;

    @Before
    public void init(){
        hcFnLCM = new HCFnLCM();
    }

    @Test
    public void testHCF(){
        int hcf = hcFnLCM.hcf(1,2);
        Assert.assertSame(1,hcf);
    }

    @Test
    public void testLCM(){
        int lcm = hcFnLCM.lcm(1,2);
        Assert.assertSame(2,lcm);
    }

}
