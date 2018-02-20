package org.manas.airthmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohanty on 21-09-2016.
 *
 * Input  : str = "gfg"
 Output : 7
 The seven distinct subsequences are "", "g", "f",
 "gf", "fg", "gg" and "gfg"

 Input  : str = "ggg"
 Output : 4
 The six distinct subsequences are "", "g", "gg"
 and "ggg"
 */
public class CharacterSubsequence {

    public static void main(String[] args) {
        String str = "abc";
        CharacterSubsequence subSequence = new CharacterSubsequence();
        int count = subSequence.getCharSubsequenceCount(str);
        System.out.println(count+1);
    }
    public int getCharSubsequenceCount(String str){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = str.length();
        int []count = new int[length+1];
        count[0]=1;
        char []tokens = str.toCharArray();
        for (int index = 1; index <= tokens.length; index++){
            count[index] = 2 * count[index -1];
            if(map.containsKey(tokens[index -1])){
                int lastIndex = map.get(tokens[index -1]);
                count[index] = count[index] - count[lastIndex];
            }else{
                map.put(tokens[index - 1], index);
            }
        }
        return count[tokens.length];
    }
}
