package org.manas.trees;

/**
 * Created by mohanty on 18-09-2016.
 */
public class Island {
    /**
     * Start with count 0.
     * Two for loops for rows and column iteration
     * when there is an 1 , increment count by 1 and replace all adjacent 1 with some character
     * so that it will form an iceland. And next iteration it will not be considered as it has been
     * already considered. All other islands will be consider in following iteration.
     *
     * e.g
     *  1  1  1  1  0                x  x  x  x  0
     *  1  1  0  1  0                x  x  0  x  0
     *  1  1  0  0  0      ------\\  x  x  0  0  0
     *  0  0  0  0  0      ------//  0  0  0  0  0
     *
     *  output : 1 Island
     */


    public int findIsland(int arr[][], int noOfRows, int noOfColumns){
        int count =0;
        for(int i=0 ; i < noOfRows ; i++){
            for(int j = 0 ; j< noOfColumns ; j++){
                if(arr[i][j] == 1){
                    count++;
                    replaceAllAdjacentOnes(arr, i, j,noOfRows, noOfColumns);
                }
            }
        }
        return count;
    }

    private void replaceAllAdjacentOnes(int[][] arr, int i, int j, int rows, int columns) {
        if(i < 0 || j < 0 || i > rows || j > columns || arr[i][j] != 1){
            return;
        }else{
            arr[i][j] = -1;
            replaceAllAdjacentOnes(arr, i-1, j , rows, columns);
            replaceAllAdjacentOnes(arr, i+1, j, rows, columns);
            replaceAllAdjacentOnes(arr, i , j-1, rows, columns);
            replaceAllAdjacentOnes(arr, i , j+1, rows, columns);
        }

    }
}
