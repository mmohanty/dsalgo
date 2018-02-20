package org.manas.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by mohanty on 03-08-2016.
 */
public class TestBfsTreeTraversal {

    private BFSTraversal bfsTraversal;

    private Node node;

    @Before
    public void init(){
        Node node = TreeUtil.buildNode();
       bfsTraversal = new BFSTraversal(node);
    }

    @Test
    public void testBFSTraversing(){
        List<Integer> traversedTree = bfsTraversal.traverse();
        for (int indices: traversedTree) {
            System.out.println(indices);
        }
    }
    @Test
    public void testBFSTraversingUsingQueue(){
        List<Integer> traversedTree = bfsTraversal.traverseThroughQueue();
        for (int indices: traversedTree) {
            System.out.println(indices);
        }
    }

}
