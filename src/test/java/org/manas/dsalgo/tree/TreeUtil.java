package org.manas.dsalgo.tree;

import org.manas.dsalgo.sorting.tree.Node;

/**
 * Created by mohanty on 03-08-2016.
 *                  1
 *                /  \
 *               2    3
 *              / \
 *             4   5
 */


public class TreeUtil {

    public static Node<Integer> buildNode(){
        Node<Integer> rootNode = new Node<>(1);
        rootNode.setLeft(new Node<>(2));
        rootNode.setRight(new Node<>(3));
        rootNode.getLeft().setLeft( new Node<>(4));
        rootNode.getLeft().setRight(new Node<>(5));
        return rootNode;
    }
}
