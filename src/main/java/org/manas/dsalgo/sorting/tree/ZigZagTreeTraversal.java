package org.manas.dsalgo.sorting.tree;

import java.util.Stack;

import org.manas.dsalgo.stack.StackUtils;


/**
 * ZigZag Tree Traversal Write a function to print ZigZag order traversal of a
 * binary tree. For the below binary tree the zigzag order traversal will be 1 3
 * 2 7 6 5 4 
 *          1
 *        /   \
 *       2      3
 *     /  \    / \ 
 *    7    6  5    4
 */
public class ZigZagTreeTraversal {

	public <T> void traversal(Node<T> root) {
		if (root == null) {
			return;
		}
		Stack<Node<T>> currentLevel = new Stack<>();
		Stack<Node<T>> nextLevel = new Stack<>();
		boolean isLeftToRight = true;

		currentLevel.push(root);
		while (!currentLevel.isEmpty()) {
			Node<T> temp = currentLevel.pop();
			if (temp != null) {
				System.out.println(temp.data);
				if (isLeftToRight) {
					if (temp.left != null) {
						nextLevel.push(temp.left);
					}
					if (temp.right != null) {
						nextLevel.push(temp.right);
					}
				} else {
					if (temp.right != null) {
						nextLevel.push(temp.right);
					}
					if (temp.left != null) {
						nextLevel.push(temp.left);
					}
				}
			}
			if (currentLevel.isEmpty()) {
				isLeftToRight = !isLeftToRight;
				StackUtils.swap(currentLevel, nextLevel);
			}
		}

	}
}
