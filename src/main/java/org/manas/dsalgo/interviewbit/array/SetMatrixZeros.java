package org.manas.dsalgo.interviewbit.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
 *
 * Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 *
 *
 *
 * Input Format:
 *
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output Format:
 *
 * Return a 2-d matrix that satisfies the given conditions.
 * Constraints:
 *
 * 1 <= N, M <= 1000
 * 0 <= A[i][j] <= 1
 * Examples:
 *
 * Input 1:
 *     [   [1, 0, 1],
 *         [1, 1, 1],
 *         [1, 1, 1]   ]
 *
 * Output 1:
 *     [   [0, 0, 0],
 *         [1, 0, 1],
 *         [1, 0, 1]   ]
 *
 * Input 2:
 *     [   [1, 0, 1],
 *         [1, 1, 1],
 *         [1, 0, 1]   ]
 *
 * Output 2:
 *     [   [0, 0, 0],
 *         [1, 0, 1],
 *         [0, 0, 0]   ]
 */
public class SetMatrixZeros {

    public static void main(String[] args) {
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        ArrayList row1 = new ArrayList(ArrayUtil.toList(new int[]{1,0}));
        ArrayList row2 = new ArrayList(ArrayUtil.toList(new int[]{0,1}));
       // ArrayList row3 = new ArrayList(ArrayUtil.toList(new int[]{1, 0, 1}));

        a.add(row1);
        a.add(row2);
       //a.add(row3);

        setMatrixZeros.setZeroes(a);

        System.out.println(a);

    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        List<Position> zeroPosition = findPositionsWhereZero(a);
        Map<String, Boolean> vertical = new HashMap<>();
        Map<String, Boolean> horizontal = new HashMap<>();


        int m = a.size();
        int n = a.get(0).size();
        for(int index = 0; index < zeroPosition.size(); index++){
            setZeroesINMatrix(a, zeroPosition.get(index), horizontal, 'F', m, n);
            setZeroesINMatrix(a, zeroPosition.get(index), horizontal, 'B', m, n);
            setZeroesINMatrix(a, zeroPosition.get(index), vertical, 'U', m, n);
            setZeroesINMatrix(a, zeroPosition.get(index), vertical, 'D', m, n);
        }

    }

    private void setZeroesINMatrix(ArrayList<ArrayList<Integer>> a, Position zeroPosition,
                                   Map<String, Boolean> alreadyVisited, char dir, int m ,int n) {
        int i = zeroPosition.x;
        int j = zeroPosition.y;


       if(dir == 'U'){
           while(i >= 0){
               if(!alreadyVisited.containsKey(""+i +""+j)) {
                   a.get(i).set(j, 0);
               }else{
                   alreadyVisited.put((""+i +""+j), Boolean.TRUE);
               }
               i--;
           }
       }

        if(dir == 'D'){
            while(i < m){

                if(!alreadyVisited.containsKey(""+i +""+j)) {
                    a.get(i).set(j,0);
                }else{
                    alreadyVisited.put((""+i +""+j), Boolean.TRUE);
                }
                i++;
            }
        }

        if(dir == 'F'){
            while(j < n){

                if(!alreadyVisited.containsKey(""+i +""+j)) {
                    a.get(i).set(j,0);
                }else{
                    alreadyVisited.put((""+i +""+j), Boolean.TRUE);
                }
                j++;
            }
        }
        if(dir == 'B'){
            while(j >= 0 ){

                if(!alreadyVisited.containsKey(""+i +""+j)) {
                    a.get(i).set(j,0);
                }else{
                    alreadyVisited.put((""+i +""+j), Boolean.TRUE);
                }
                j--;
            }
        }


    }


    private List<Position> findPositionsWhereZero(ArrayList<ArrayList<Integer>> a) {
        List<Position> positions = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            ArrayList<Integer> list = a.get(i);
            for (int j = 0; j < list.size(); j++){
                if(list.get(j) == 0){
                    Position position = new Position(i,j);
                    positions.add(position);
                }
            }
        }
        return positions;
    }

    class Position{
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        Position(){
            this.x =0;
            this.y =0;
        }
        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
