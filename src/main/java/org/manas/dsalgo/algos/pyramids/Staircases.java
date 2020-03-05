package org.manas.dsalgo.algos.pyramids;

/**
 * Created by mohanty on 17-09-2016.
 */
public class Staircases {

    public static void main(String[] args) {
        Staircases cases = new Staircases();
        cases.printStairCase(4);
    }

    private void printStairCase(int steps) {
        for(int i = 1; i <= steps ; i++){
            for(int j = 1; j <= steps ; j++){
                if(i+j > steps){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
