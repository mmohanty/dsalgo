package org.manas.dsalgo.algos;

import java.util.ArrayList;

/**
 * Created by mohanty on 07-09-2016.
 */
public class BracketGenerator{

    public void dfs(ArrayList<String> result, String s, int left, int right){
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
