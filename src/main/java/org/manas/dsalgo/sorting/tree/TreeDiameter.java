package org.manas.dsalgo.sorting.tree;

public class TreeDiameter {

	public static int findDiameter(Node<Integer> root) {
		if(root == null) {
			return 0;
		}
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);
		
		int totalHeight = lHeight+rHeight+1;
		
		int lDiameter = findDiameter(root.left);
		int rDiameter = findDiameter(root.right);
		return Math.max(Math.max(lDiameter, rDiameter), totalHeight);
	}

	private static int getHeight(Node<Integer> node) {
		if(node == null) {
			return 0;
		}
		int lHeight = getHeight(node.left);
		int rHeight = getHeight(node.right);
		
		return Math.max(lHeight+1, rHeight+1);
	}
}
