package org.manas.dsalgo.dynamicprogramming;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.manas.dsalgo.algos.dynamicprogramming.BracketValidator;

/**
 * Created by mohanty on 03-09-2016.
 */
public class TestBracketValidator {


    private BracketValidator bracketValidator;

    @Before
    public  void  init(){
        bracketValidator =  new BracketValidator();
    }

    @Test
    public void testValidateBracket_For_ValidTokens(){
        String token = "{[()]}";
        boolean result = bracketValidator.validateBracket(token);
        Assert.assertTrue(result);
    }

    @Test
    public void testValidateBracket_For_InValidTokens(){
        String token = "([)]";
        boolean result = bracketValidator.validateBracket(token);
        Assert.assertFalse(result);
    }

}
