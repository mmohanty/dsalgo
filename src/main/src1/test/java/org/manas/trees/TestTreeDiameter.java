package org.manas.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mohanty on 15-08-2016.
 */
public class TestTreeDiameter {

    private TreeDiameter treeDiameter;

    @Before
    public void init(){
        treeDiameter = new TreeDiameter();
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
        Node node = new Node(1);
        node.setLeftChild(new Node(2));
        node.setRightChild(new Node(3));


        node.getLeftChild().setRightChild(new Node(5));
        node.getLeftChild().setLeftChild(new Node(4));

        node.getLeftChild().getLeftChild().setLeftChild(new Node(6));
        node.getLeftChild().getRightChild().setRightChild(new Node(7));


        int diameter = treeDiameter.findDiameter(node);

        Assert.assertSame(5, diameter);
    }

}
