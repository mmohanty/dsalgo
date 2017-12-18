package org.manas.dsalgo.sorting.tree;
/**
 * Let us consider the two given arrays as 
 * pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7} and 
 * post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
 * In pre[], the leftmost element is root of tree. Since the tree is full and array size is more than 1. 
 * The value next to 1 in pre[], must be left child of root. So we know 1 is root and 2 is left child. 
 * How to find the all nodes in left subtree? We know 2 is root of all nodes in left subtree. 
 * All nodes before 2 in post[] must be in left subtree. Now we know 1 is root, 
 * elements {8, 9, 4, 5, 2} are in left subtree, and the elements {6, 7, 3} are in right subtree.
 * 
 * @author manasmohanty
 *
 */
public class PreorderPostOrderToTree {

	private static int preIndex = 0;
	
	public static Node<Integer> makeTree(int[] pre, int[]post, int low, int high, int size){
		
		//Base case
		if(low > high || preIndex >= size){
			return null;
		}
		
		 // The first node in preorder traversal is 
        // root. So take the node at preIndex from 
        // preorder and make it root, and increment 
        // preIndex
		Node<Integer> node = new Node<Integer>(pre[preIndex]);
		preIndex++;
		
		// If the current subarry has only one 
        // element, no need to recur or 
        // preIndex > size after incrementing
		if(low == high || preIndex >= size){
			return node;
		}
		
		// Search the next element of pre[] in post[]
		int i;
		for(i = low; i <= high; i++){
			if(pre[preIndex] == post[i]){
				break;
			}
		}
		// Use the index of element found in 
        // postorder to divide postorder array 
        // in two parts. Left subtree and right subtree
		if(low <= high){
			node.left = makeTree(pre, post, low, i, size);
			node.right = makeTree(pre, post, i+1, high, size);
		}
		
		return node;
	}
	
	// The main function to construct Full 
    // Binary Tree from given preorder and 
    // postorder traversals. This function 
    // mainly uses makeTree()
	static Node<Integer> constructTree(int pre[], int post[], int size) 
    {
        preIndex = 0;
        return makeTree(pre, post, 0, size - 1, size);
    }
	
	static void printInorder(Node<Integer> root) 
    {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
	
	public static void main(String[] args) {
		int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
 
        int size = pre.length;
        Node<Integer> root = constructTree(pre, post, size);
 
        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
	}
}
