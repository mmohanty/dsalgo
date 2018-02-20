package org.manas.stack;

import java.util.Stack;

/**
 * Created by mohanty on 23-09-2016.
 *
 * Find minimum elements after considering all possible transformations
 Given an array of three colors. The array elements have a special property. Whenever two elements of different colors become adjacent to each other, they merge into an element of the third color. How many minimum number of elements can be there in array after considering all possible transformations.

 Example:
 Input : arr[] = {R, G}
 Output : 1
 G B -> {G B} R -> R

 Input : arr[] = {R, G, B}
 Output : 2
 Explanation :
 R G B -> [R G] B ->  B B
 OR
 R G B -> R {G B} ->  R R
 */
public class ColorTransformer {

    public static void main(String[] args) {
        ColorTransformer transformer = new ColorTransformer();
        Character []arr = {'R', 'G', 'B', 'B', 'G', 'R'};

        int count = transformer.getColorCOuntAfterTransormation(arr);
        System.out.println(count);
    }
    private Character getThirdColor(Character c1, Character c2){
        if((c1 == 'R' && c2 == 'G') || (c1=='G' && c2=='R')){
            return 'B';
        }
        else if((c1 == 'R' && c2 == 'B') || (c1=='B' && c2=='R')){
            return 'G';
        }
        else if((c1 == 'B' && c2 == 'G') || (c1=='G' && c2=='B')){
            return 'R';
        }
        return ' ';
    }
    public int getColorCOuntAfterTransormation(Character []colorArray){
        Stack<Character> stack = new Stack<Character>();
        for(Character c : colorArray){
            if(stack.isEmpty() || stack.peek() == c){
                stack.push(c);
            }else{
                Character transformedColor = c;
                while(!stack.isEmpty() && stack.peek() != transformedColor){
                    transformedColor = getThirdColor(stack.pop(), transformedColor);
                }
                stack.push(transformedColor);
            }
        }
        return  stack.size();
    }
}
