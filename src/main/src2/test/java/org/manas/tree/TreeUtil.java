package org.manas.tree;

/**
 * Created by mohanty on 03-08-2016.
 *                  1
 *                /  \
 *               2    3
 *              / \
 *             4   5
 */


public class TreeUtil {

    public static Node buildNode(){
        Node rootNode = new Node(1);
        rootNode.setLeftNode(new Node(2));
        rootNode.setRightNode(new Node(3));
        rootNode.getLeftNode().setLeftNode(new Node(4));
        rootNode.getLeftNode().setRightNode(new Node(5));
        return rootNode;
    }
}
