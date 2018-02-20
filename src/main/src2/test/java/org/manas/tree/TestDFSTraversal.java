package org.manas.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohanty on 03-08-2016.
 */
public class TestDFSTraversal {

    private DFSTreeTraversal dfsTreeTraversal;

    @Before
    public void init(){
        Node node = TreeUtil.buildNode();
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
