package org.manas.dsalgo.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.manas.dsalgo.sorting.tree.Node;
import org.manas.dsalgo.sorting.tree.TreeDiameter;

/**
 * Created by mohanty on 15-08-2016.
 */
public class TestTreeDiameter {

    @Before
    public void init(){
    }

    /**
     *                 1
     *                / \
     *               2    3
     *              / \
     *             4   5
     *            /     \
     *           6       7
     *
     */

    @Test
    public void testTreeDiameter(){
        Node<Integer> node = new Node<>(1);
        node.setLeft(new Node<>(2));
        node.setRight(new Node<>(3));


        node.getLeft().setRight(new Node<>(5));
        node.getLeft().setLeft(new Node<>(4));

        node.getLeft().getLeft().setLeft(new Node<>(6));
        node.getLeft().getRight().setRight(new Node<>(7));


        int diameter = TreeDiameter.findDiameter(node);

        Assert.assertSame(5, diameter);
    }

}
