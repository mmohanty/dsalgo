package org.manas.dsalgo.sorting.tree;

import java.util.HashMap;
import java.util.Map;

public class NodeAtKthDistanceFromLeaf<T> {
	
	private Map<T, Boolean> nodeMap = new HashMap<>();
	public Integer printNodes(Node<T> node, int k){
		
		if(node == null){
			return 0;
		}
		
		int lHeight = printNodes(node.left, k);
		int  rHeight = printNodes(node.right, k);
		
		if(lHeight+1 == k+1 || rHeight+1 == k+1 && !nodeMap.containsKey(node.data)){
			nodeMap.put(node.data, Boolean.TRUE);
			System.out.println(node.data);
		}
		
		return Math.max(lHeight, rHeight)+1;
	}

	  public static void main(String args[])
	    {
		  NodeAtKthDistanceFromLeaf<Integer> tree = new NodeAtKthDistanceFromLeaf<>();
	  
	        /* Let us construct the tree shown in above diagram */
	        Node<Integer> root = new Node<>(1);
	        root.left = new Node<>(2);
	        root.right = new Node<>(3);
	        root.left.left = new Node<>(4);
	        root.left.right = new Node<>(5);
	        root.right.left = new Node<>(6);
	        root.right.right = new Node<>(7);
	        root.right.left.right = new Node<>(8);
	  
	        System.out.println(" Nodes at distance 2 are :");
	        tree.printNodes(root, 1);
	    }
}
