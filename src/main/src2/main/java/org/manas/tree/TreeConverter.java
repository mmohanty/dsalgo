package org.manas.tree;

import java.util.List;

/**
 * Builds a tree from inorder and postorder tree.
 * Created by mohanty on 05-08-2016.
 */
public class TreeConverter {

    private static int POST_INDEX;
    public Node convertTreeFromInorderAndPostOrderTree(int[] inOrder, int[] postOrder){

        POST_INDEX = postOrder.length -1;
        int length = inOrder.length;
        return getTree(inOrder, postOrder, 0, length -1);

    }

    private Node getTree(int[] inOrder, int[] postOrder,int inStartIndex, int inEndIndex) {

        if (inEndIndex < inStartIndex) {
            return null;
        }
        int value = postOrder[POST_INDEX];
        Node node = new Node(value);

        POST_INDEX--;
        if(inStartIndex == inEndIndex){
            return node;
        }

        int nodePositionInInOderTree = search(inOrder, inStartIndex, inEndIndex, value);

        Node rightNode = getTree(inOrder, postOrder, nodePositionInInOderTree + 1, inEndIndex);
        node.setRightNode(rightNode);

        Node leftNode = getTree(inOrder, postOrder, inStartIndex, nodePositionInInOderTree -1);
        node.setLeftNode(leftNode);

        return node;

    }

    private int search(int[] inOrder, int inStartIndex, int inEndIndex, int nodeValue) {
        while(inStartIndex <= inEndIndex){

            if(inOrder[inStartIndex++] == nodeValue ){
                return inStartIndex-1;
            }
        }
        return 0;
    }

}
