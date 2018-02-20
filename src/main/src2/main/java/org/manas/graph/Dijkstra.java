package org.manas.graph;

/**
 * Created by mohanty on 27-07-2016.
 */
public class Dijkstra {

    private final int VERTEXES;

    public Dijkstra(int VERTEXES) {
        this.VERTEXES = VERTEXES;
    }

    public int[] findShortestPath(int[][] graph, int i) {
        int []distance = new int[VERTEXES];
        boolean []processedIndices = new boolean[VERTEXES];
        fillDistanceWithMaximumValue(distance);
        fillIndicesWithFalseTag(processedIndices);

        distance[i] = 0;


        // Find shortest path for all vertices
        for (int count = 0; count < VERTEXES-1; count++) {

            int vertexU = findSmallestVertex(distance, processedIndices);
            processedIndices[vertexU] = Boolean.TRUE;

            for (int vertexV = 0; vertexV < VERTEXES; vertexV++) {

                if (distance[vertexU] != Integer.MAX_VALUE && graph[vertexU][vertexV] != 0
                        && (distance[vertexV] > distance[vertexU] + graph[vertexU][vertexV])) {
                    distance[vertexV] = distance[vertexU] + graph[vertexU][vertexV];
                }

            }
        }
        return distance;
    }

    private int findSmallestVertex(int[] distance, boolean[] processedIndices) {
        int minValue = Integer.MAX_VALUE;
        int min_index=-1;
        for (int start = 0; start < VERTEXES; start++){
            if (processedIndices[start] == false && distance[start] <= minValue)
            {
                minValue = distance[start];
                min_index = start;
            }
        }
        return min_index;
    }

    private void fillIndicesWithFalseTag(boolean[] processedIndices) {
        for (int index = 0 ; index < processedIndices.length ; index++){
            processedIndices[index] = Boolean.FALSE;
        }
    }

    private void fillDistanceWithMaximumValue(int[] distance) {
        for (int index = 0 ; index < distance.length ; index++){
            distance[index] = Integer.MAX_VALUE;
        }
    }
}
