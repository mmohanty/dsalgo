package org.manas.dsalgo.tree;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.manas.dsalgo.sorting.tree.DFSTreeTraversal;
import org.manas.dsalgo.sorting.tree.Node;

/**
 * Created by mohanty on 03-08-2016.
 */
public class TestDFSTraversal {

    private DFSTreeTraversal dfsTreeTraversal;

    @Before
    public void init(){
        Node<Integer> node = TreeUtil.buildNode();
        dfsTreeTraversal = new DFSTreeTraversal(node);
    }

    @Test
    public void testInorderTraversal(){
        List<Integer> output = dfsTreeTraversal.inorderTraversal();
        for (int indices: output) {
            System.out.println(indices);
        }
    }

    @Test
    public void testPreOrderTraversal(){
        List<Integer> output = dfsTreeTraversal.preorderTraversal();
        for (int indices: output) {
            System.out.println(indices);
        }

    }
    @Test
    public void testPostOrderTraversal(){
        List<Integer> output = dfsTreeTraversal.postorderTraversal();
        for (int indices: output) {
            System.out.println(indices);
        }

    }
}
