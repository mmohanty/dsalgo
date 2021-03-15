package org.manas.dsalgo.tree;

import org.junit.Before;
import org.junit.Test;
import org.manas.dsalgo.sorting.tree.BFSTreeTraversal;
import org.manas.dsalgo.sorting.tree.Node;

/**
 * Created by mohanty on 03-08-2016.
 */
public class TestBfsTreeTraversal {


    private Node<Integer> node;

    @Before
    public void init(){
        node = TreeUtil.buildNode();
    }

    @Test
    public void testBFSTraversing(){
        BFSTreeTraversal.traverseTreeThroughRecurssion(node);
    }
    @Test
    public void testBFSTraversingUsingQueue(){
        BFSTreeTraversal.printTreeThroughQueue(node);
    }

}
