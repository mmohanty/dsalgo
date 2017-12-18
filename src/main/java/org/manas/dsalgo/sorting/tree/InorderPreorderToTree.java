package org.manas.dsalgo.sorting.tree;

/**
 * Algorithm: buildTree()
1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next 
   element in next recursive call.
2) Create a new tree node tNode with the data as picked element.
3) Find the picked element’s index in Inorder. Let the index be inIndex.
4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
6) return tNode.
 * @author manasmohanty
 *
 */
public class InorderPreorderToTree {

	private static int preorderIndex = 0;
	public static Node<Character> makeTreeThroughRecursive(char[] inorder, char[] preorder, int low, int high, int size){
		if(low > high || preorderIndex > size){
			return null;
		}
		
		Node<Character> root = new Node<Character>(preorder[preorderIndex]);
		preorderIndex++;
		int indexOfNodeInorderTree = search(inorder, low, high,root.data);
		
		if(low == high || preorderIndex > size){
			return root;
		}
		
		root.left = makeTreeThroughRecursive(inorder, preorder, low, indexOfNodeInorderTree-1, size);
		root.right = makeTreeThroughRecursive(inorder, preorder, indexOfNodeInorderTree+1, high, size);
		return root;
	}
	private static int search(char[] inorder, int low, int high, Character data) {
		for(int index = low; index <= high; index++){
			if(inorder[index] == data){
				return index;
			}
		}
		return -1;
	}
	
	public static void main(String args[]) 
    {
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node<Character> root = makeTreeThroughRecursive(in, pre, 0, len - 1, pre.length);
  
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        printInorder(root);
    }
	
	 static void printInorder(Node<Character> node) 
	    {
	        if (node == null)
	            return;
	  
	        /* first recur on left child */
	        printInorder(node.left);
	  
	        /* then print the data of node */
	        System.out.print(node.data + " ");
	  
	        /* now recur on right child */
	        printInorder(node.right);
	    }
}
