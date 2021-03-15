package org.manas.dsalgo.interviewbit.array;

import java.util.Arrays;

public class SpriralMatrixPractice {

    public static void main(String[] args) {
        SpriralMatrixPractice spriralMatrixPractice = new SpriralMatrixPractice();
        //happy path - Direction will be in cyclic order starting from 0 - 1 - 2 - 3 -0,
        //int [][]a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        //int [][]a = {{1}};

        //Hint1 - Single Column - direction =0 and left = right (It has to move from top to bottom)
        //int [][]a = {{1}, {2}, {3}};

        //Hint2 // After 2nd traversal direction =2 and left = right (It has to move from bottom to top)
        //int [][]a = {{1, 2,}, {3,4}, {5,6}};

        //Hint3 -After first traversal - top = bottom and direction =1 (It has to move right to left)
        //int [][]a = {{1, 2, 3}, {4, 5, 6}};

        //Hint4 : after 1st iteration, direction =1 top =bottom (it has to move from right to left)
        //int [][]a = {{1,2},{3,4}};

        //Hint5 = After 3rd iteration :top = bottom, direction =3 ( it has to move from left to right)
        int [][]a = {{133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198},
        {401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10},
        {112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126}};
        spriralMatrixPractice.spiralOrder(a);

    }
    public int[] spiralOrder(final int[][] a) {

        int direction =0;


        int leftIndex =0;
        int topIndex=0;
        int rightIndex = a[0].length -1;
        int bottomIndex = a.length -1;

        int size = (rightIndex+1) * (bottomIndex+1);
        int []result = new int[size];
        findSpiralMatrix(result, a, direction, leftIndex, rightIndex, topIndex,
                bottomIndex, 0, size);

        Arrays.stream(result).forEach( item -> System.out.print(item + " "));
        return result;


    }

    void findSpiralMatrix(int []result, int a[][], int direction, int leftIndex,
                          int rightIndex, int topIndex,
                          int bottomIndex , int index, int size){


        int left = leftIndex;
        int right = rightIndex;
        int top = topIndex;
        int bottom = bottomIndex;

        //exit criteria
        if(index >= size){
            return;
        }

        //single column
        //Hint 1 and 2
        if(left == 0 && right == 0){

            //Hint 1
            if(direction == 0) {
                //add element to a
                while (top <= bottom) {
                    result[index++] = a[top++][left];
                }
            }
            //Hint 2
            if(direction == 2){
                while (top <= bottom) {
                    result[index++] = a[bottom--][left];
                }
            }

        }else if(top == 1 && bottom == 1){ // Hint 3, 4 and 5
            //Hint 3 n=and 4
            if(direction ==1){
                while (left <= right) {
                    result[index++] = a[bottom][right--];
                }
            }
            //Hint 5
            if(direction == 3){
                while (left <= right) {
                    result[index++] = a[bottom][left++];
                }
            }

        } //Happy path Starts :: //from left to right
        else if(direction ==0){

            //add element to a
            while(left <= right){
                result[index++] = a[top][left++];
            }
            topIndex++;
            direction =1;
        }
        else if(direction == 1){//top to bottom

            //add element to a
            while(top <= bottom){
                result[index++] = a[top++][right];
            }
            rightIndex--;
            direction =2;

        }
        else if(direction == 2){ // right to left
            //add element to a
            while(left <= right){
                result[index++] = a[bottom][right--];
            }
            bottomIndex--;
            direction =3;
        }
        else if(direction==3){ //bottom to top
            //add element to a
            while(top <= bottom){
                result[index++] = a[bottom--][left];
            }
            leftIndex++;
            direction =0;

        }
        findSpiralMatrix(result, a, direction, leftIndex, rightIndex,
                topIndex, bottomIndex, index, size);
    }
}
