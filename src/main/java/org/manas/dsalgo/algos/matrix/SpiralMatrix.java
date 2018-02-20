package org.manas.dsalgo.algos.matrix;

/**
 * Created by mohanty on 13-08-2016.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int [][]matrix = new int[][]{
                                        {1,2,3,4},
                                        {5,6, 7,8},
                                        {9,10,11,12},
                                        {13,14,15,16}};
        printMatrix(matrix, 0, 0, 3, 3, Moves.nextMoves());
    }

    private static void printMatrix(int[][] matrix, int rowStart, int columnStart, int rowEnd, int columnEnd, Moves moves) {
        if(rowStart <= rowEnd && columnStart <= columnEnd){

            if(moves == Moves.FORWARD){
                for (int i = columnStart ; i <= columnEnd; i++){
                    System.out.println(matrix[rowStart][i]);
                }
                rowStart++;
            }else if(moves == Moves.DOWNWARD){
                for (int i = rowStart ; i <= rowEnd; i++){
                    System.out.println(matrix[i][columnEnd]);
                }
                columnEnd--;
            }else if (moves == Moves.BACKWARD){
                for (int i = columnEnd ; i >= columnStart; i--){
                    System.out.println(matrix[rowEnd][i]);
                }
                rowEnd--;
            }else if(moves == Moves.UPWARD){
                for (int i = rowEnd ; i >= rowStart; i--){
                    System.out.println(matrix[i][columnStart]);
                }
                columnStart++;
            }
            printMatrix(matrix, rowStart, columnStart, rowEnd, columnEnd, Moves.nextMoves());
        }
    }

    enum Moves{
        FORWARD,DOWNWARD,BACKWARD,UPWARD;
        private static int count;

        public static Moves nextMoves(){
            Moves []moves = Moves.values();
            if(count == moves.length){
                count=0;
            }
            return moves[count++];
        }
    }
}
