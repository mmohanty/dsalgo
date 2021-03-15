package org.manas.dsalgo.algos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohanty on 07-09-2016.
 */
public class BracketGenerator{

    public static void main(String[] args) {
        BracketGenerator bracketGenerator = new BracketGenerator();
        ArrayList<String> result = new ArrayList<String>();
        int n = 2;
        bracketGenerator.dfs(result, "", n, n);
        System.out.println(result);
    }
    public void dfs(List<String> result, String s, int left, int right){
        if(left > right)
            return;

        if(left==0 && right==0){
            result.add(s);
            return;
        }

        if(left>0){
            dfs(result, s+"(", left-1, right);
        }

        if(right>0){
            dfs(result, s+")", left, right-1);
        }
    }
}
