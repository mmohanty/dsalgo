package org.manas.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohanty on 01-10-2016.
 */
public class AllStringAnagrams {

    public static void main(String[] args) {
        String str = "abcd";
        AllStringAnagrams anagrams = new AllStringAnagrams();
        List<String> list = new ArrayList<String>();
        char []chars = str.toCharArray();
        anagrams.findAllCombination(chars, list, "");
        for(String s : list){
            System.out.println(s);
        }
    }

    private void findAllCombination(char[] chars, List<String> list, String str) {
        if(chars.length == 1){
            list.add(str + chars[0]);
            return ;
        }
        for(int index= 0; index < chars.length; index++){
            char []remainingChars = getRemainingChars(chars, chars[index]);
            findAllCombination(remainingChars, list, str+chars[index]);
        }
    }

    private char[] getRemainingChars(char[] chars, char excludeChar) {
        char []tmp = new char[chars.length-1];
        int tmpIndex =0;
        for(char c : chars){
            if(c != excludeChar){
                tmp[tmpIndex++] = c;
            }
        }
        return tmp;
    }
}
