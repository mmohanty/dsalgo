package org.manas.pyramids;

/**
 * Created by mohanty on 17-09-2016.
 */
public class StarPyramids {

    public static void main(String[] args) {
        StarPyramids pyramids = new StarPyramids();
        pyramids.printStarPyramid(3);
    }

    private void printStarPyramid(int rows) {
        for(int i = 1; i<= rows; i ++){
            for(int j = 1; j<= 2* rows -1 ; j++){
                if(j > rows -i && j < rows +i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
