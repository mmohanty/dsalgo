package org.manas.trees;

/**
 * Created by mohanty on 15-08-2016.
 */
public class Node {
    private final int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
