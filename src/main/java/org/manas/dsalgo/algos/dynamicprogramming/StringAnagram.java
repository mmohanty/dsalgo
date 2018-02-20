package org.manas.dsalgo.algos.dynamicprogramming;

/**
 * abc is an anagram of cba
 * Created by mohanty on 29-09-2016.
 */
public class StringAnagram {

    public static void main(String[] args) {
        StringAnagram sa = new StringAnagram();
        System.out.println(sa.isAngram("abc", "cba"));
        System.out.println(sa.isAngram("abc", "cca"));
    }
    public boolean isAngram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        int sum1 = 0;
        int sum2 = 0;
        int prime =7;

        for(int i = 0; i < str1.length(); i ++){
            sum1 += prime * Integer.valueOf(str1.charAt(i));
            sum2 += prime * Integer.valueOf(str2.charAt(i));
        }
        if(sum1 == sum2){
            return true;
        }
        return false;
    }
}
