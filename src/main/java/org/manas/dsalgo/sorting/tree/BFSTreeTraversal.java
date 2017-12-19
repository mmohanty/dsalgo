package org.manas.dsalgo.sorting.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTreeTraversal {

	public static void traverseTreeThroughRecurssion(Node<Integer> root){
		
		int heightOfTree = getHeight(root);
		for(int start = 0 ; start < heightOfTree; start++){
			printTree(root, start);
		}
		
	}

	private static void printTree(Node<Integer> root, int start) {
		if(root == null){
			return;
		}
		if(start == 0){
			System.out.println(root.data);
		}
		printTree(root.left, start-1);
		printTree(root.right, start-1);
		
	}

	private static int getHeight(Node<Integer> root) {
		if(root == null){
			return 0;
		}
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);
		
		return Math.max(lHeight+1, rHeight+1);
	}
	
	public static void main(String args[])
    {
       Node<Integer> root = new Node<Integer>(1);
       root.left= new Node<Integer>(2);
       root.right= new Node<Integer>(3);
       root.left.left= new Node<Integer>(4);
       root.left.right= new Node<Integer>(5);
        
       System.out.println("Level order traversal of binary tree is ");
       traverseTreeThroughRecurssion(root);
       
       
       System.out.println("Level order traversal of binary tree is ");
       printTreeThroughQueue(root);
    }
	
	public static void printTreeThroughQueue(Node<Integer> root){
		if(root == null){
			return;
		}
		
		Queue<Node<Integer>> queue = new  LinkedList<Node<Integer>>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node<Integer> node = queue.poll();
			System.out.println(node.data);
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
	}
}
