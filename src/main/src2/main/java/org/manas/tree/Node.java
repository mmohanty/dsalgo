package org.manas.tree;

/**
 * Created by mohanty on 03-08-2016.
 */
class Node {
    private Node leftNode;
    private Node rightNode;

    private int nodeValue;

    public Node(int nodeValue) {
        this.leftNode = null;
        this.rightNode = null;
        this.nodeValue = nodeValue;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }
}
