package org.manas.dsalgo.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mohanty on 27-07-2016.
 */
public class TestDijkstra {

    private static int NO_OF_VETEXES;
    private int [][]graph;
    private DijkstrasAlgo.ShortestPath sp;
    @Before
    public void init(){
        NO_OF_VETEXES = 9;
        sp = new DijkstrasAlgo.ShortestPath(NO_OF_VETEXES);
        graph = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                            {4, 0, 8, 0, 0, 0, 0, 11, 0},
                            {0, 8, 0, 7, 0, 4, 0, 0, 2},
                            {0, 0, 7, 0, 9, 14, 0, 0, 0},
                            {0, 0, 0, 9, 0, 10, 0, 0, 0},
                            {0, 0, 4, 0, 10, 0, 2, 0, 0},
                            {0, 0, 0, 14, 0, 2, 0, 1, 6},
                            {8, 11, 0, 0, 0, 0, 1, 0, 7},
                            {0, 0, 2, 0, 0, 0, 6, 7, 0}};
    }
    @Test
    public void testShortestPath(){

        //when
    		sp.dijkstra(graph,0);
        //int[] shortestPath = sp.dijkstra(graph,0);

        //then
       // Assert.assertSame(shortestPath[0],0);
        //Assert.assertSame(shortestPath[1],4);
        //Assert.assertSame(shortestPath[2],12);
        //Assert.assertSame(shortestPath[3],19);
       // Assert.assertSame(shortestPath[4],21);
        //Assert.assertSame(shortestPath[5],11);
        //Assert.assertSame(shortestPath[6],9);
        //Assert.assertSame(shortestPath[7],8);
        //Assert.assertSame(shortestPath[8],14);

    }

    @Test
    public void testLongestPath(){
        Assert.assertSame(2,3);
    }

    @Test
    public void testLongestPath2(){
        throw new NullPointerException("");
    }
}
