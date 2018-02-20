package org.manas.pyramids;

/**
 *       1
 *      1 1
 *     1 2 1
 *    1 3 3 1
 *   1 4 6 4 1
 * Created by mohanty on 29-09-2016.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        int output = pt.getNumberByIndex(5,3);
        System.out.println(output);
    }
    public int getNumberByIndex(int row, int column){
        if(isAtBoundary(row, column)){
            return 1;
        }
        return getNumberByIndex(row -1, column-1) + getNumberByIndex(row -1 , column);
    }
    private boolean isAtBoundary(int row, int column) {
        if(row == 1 || column ==1 || row == column){
            return true;
        }else{
            return false;
        }
    }
}
