package org.manas.dsalgo.sorting.tree;

import java.util.Stack;

/**
 *       10
 *      /   \
 *     8     2
 *    / \   / 
 *   3   5 4
 * @author manasmohanty
 *
 * @param <T>
 */
public class DFSTreeTraversalThroughIterative<T> {

	
	public void preOrderTraversal(Node<T> node){

		if(node == null){
			return;
		}
		
		Stack<Node<T>> stack = new Stack<>();
		stack.push(node);
		
		while(!stack.isEmpty()){
			
			Node<T> parent = stack.pop();
			System.out.println(parent.data);
			if(parent.right != null){
				stack.push(parent.right);
			}
			if(parent.left != null){
				stack.push(parent.left);
			}
		}
	}
	
	public static void main(String args[]) {
		DFSTreeTraversalThroughIterative<Integer> tree = new DFSTreeTraversalThroughIterative<>();
        Node<Integer> root = new Node<>(10);
        root.left = new Node<>(8);
        root.right = new Node<>(2);
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(4);
        tree.preOrderTraversal(root);
 
    }
}
