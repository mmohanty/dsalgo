package org.manas.dsalgo.interviewbit.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits,
 *
 * add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 *
 * If the vector has [1, 2, 3]
 *
 * the returned vector should be [1, 2, 4]
 *
 * as 123 + 1 = 124.
 *
 *  NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
 * For example, for this problem, following are some good questions to ask :
 * Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class AddOneToNumber {

    public static void main(String[] args) {
        //int a[] = {1, 2, 3}; // expected {1, 2, 4};

        //int a[] = {0, 1, 2, 3, 9}; // expected {1, 2, 4};

        //int a[] = {9, 9, 9, 9, 9}; // expected {1, 0, 0, 0, 0, 0 };
        int a[] = {9}; // expected {1, 0 };
        List<Integer> input = ArrayUtil.toList(a);

        AddOneToNumber addOneToNumber = new AddOneToNumber();

        List output = addOneToNumber.plusOne(input);

        output.stream().forEach(System.out::println);
    }

    public List<Integer> plusOne(List<Integer> a) {
        List<Integer> output = new ArrayList<>();
        int size = a.size();
        int mostSignificantDigit = a.get(size-1);

        int startPosition = findStartPosition(a);
        if(mostSignificantDigit == 9 && size ==1){
            output.add(1);
            output.add(0);
            return output;
        }
        if(mostSignificantDigit == 9){
            List<Integer> tempArray = new ArrayList<>();
            tempArray.add(0);
            int carry = 1;
            for(int end = size-2; end >= startPosition ; end--){
                int element = a.get(end);
                if(element == 9 && carry == 1){
                    tempArray.add(0);
                    carry =1;
                    if(end == startPosition){
                        tempArray.add(1);
                        break;
                    }
                }else{
                    tempArray.add(element+carry);
                    carry=0;
                }

            }
            //add temp array to output
            for(int i = tempArray.size() -1; i >= 0; i--){
                output.add(tempArray.get(i));
            }
        }else{
            for(int index = startPosition ; index < size -1 ; index++){
                int element = a.get(index);
                output.add(element);

            }
            output.add(mostSignificantDigit+1);
        }
        return output;

    }

    private int findStartPosition(List<Integer> a) {
        for(int i=0; i < a.size(); i ++){
            if(a.get(i) != 0){
                return i;
            }
        }
        return a.size()-1;
    }


}
