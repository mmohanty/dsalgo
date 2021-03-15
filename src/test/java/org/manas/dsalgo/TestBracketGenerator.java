package org.manas.dsalgo;

import org.junit.Before;
import org.junit.Test;
import org.manas.dsalgo.algos.BracketGenerator;

import java.util.ArrayList;

/**
 * Created by mohanty on 07-09-2016.
 */
public class TestBracketGenerator {

    private BracketGenerator bracketGenerator;

    @Before
    public void init(){
        bracketGenerator = new BracketGenerator();
    }

    @Test
    public void testBracketCombination(){
        ArrayList<String> result = new ArrayList<String>();
        int n = 2;
        bracketGenerator.dfs(result, "", n, n);
        System.out.println(result);
    }
}
