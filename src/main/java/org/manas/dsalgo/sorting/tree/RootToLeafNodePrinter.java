package org.manas.dsalgo.sorting.tree;

import java.util.Arrays;

public class RootToLeafNodePrinter<T> {

	public void printAllNodeFromRootToLeafNode(Node<T> root, T[] track, int position) {

		if (root == null) {
			return;
		}

		track[position++] = root.data;
		
		if(root.left == null & root.right == null){
			Arrays.stream(track).filter(element -> element != null).forEach(System.out::print);
			System.out.println("\n-------");
		}
		printAllNodeFromRootToLeafNode(root.left, track, position);
		printAllNodeFromRootToLeafNode(root.right, track, position);
	}

	public static void main(String[] args) {
		RootToLeafNodePrinter<Integer> tree = new RootToLeafNodePrinter<>();
		Node<Integer> root = new Node<>(10);
		root.left = new Node<>(8);
		root.right = new Node<>(2);
		root.left.left = new Node<>(3);
		root.left.right = new Node<>(5);
		root.right.left = new Node<>(2);
		
		tree.printAllNodeFromRootToLeafNode(root, new Integer[100], 0);
	}

}
