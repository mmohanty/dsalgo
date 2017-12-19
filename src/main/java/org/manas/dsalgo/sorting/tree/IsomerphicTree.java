package org.manas.dsalgo.sorting.tree;

/**
 * wo trees are called isomorphic if one of them can be obtained from other by a series of flips, 
 * i.e. by swapping left and right children of a number of nodes. Any number of nodes at any level can have 
 * their children swapped. 
 * Two empty trees are isomorphic.
 * For example, following two trees are isomorphic with following 
 * sub-trees flipped: 2 and 3, NULL and 6, 7 and 8.
 * 
 *             1                   1
 *          /    \               /   \
 *         2       3            3     2
 *       / \      /             \    / \
 *      4   5    6               6  4   5
 *         / \                          / \
 *        7   8                        8   7
 * @author manasmohanty
 *
 */
public class IsomerphicTree {
	
	/**
	 * We simultaneously traverse both trees. Let the current internal nodes of two trees being traversed be n1 and n2 respectively. 
	 * There are following two conditions for subtrees rooted with n1 and n2 to be isomorphic.
	 *	1) Data of n1 and n2 is same.
	 *	2) One of the following two is true for children of n1 and n2
	 *		……a) Left child of n1 is isomorphic to left child of n2 and right child of n1 is isomorphic to right child of n2.
	 *		……b) Left child of n1 is isomorphic to right child of n2 and right child of n1 is isomorphic to left child of n2.
	 *
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static <T> boolean isIsomorphic(Node<T> node1, Node<T> node2){
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 == null || node2 == null){
			return false;
		}
		if(!node1.data.equals(node2.data)){
			return false;
		}
		return isIsomorphic(node1.left, node2.left) && isIsomorphic(node1.right, node2.right) ||
				isIsomorphic(node1.left, node2.right) && isIsomorphic(node1.right, node2.left);
		
	}
	
	
	// Driver program to test above functions
    public static void main(String args[]) 
    {
         
        // Let us create trees shown in above diagram
        Node<Integer> root1 = new Node<>(1);
        root1.left = new Node<Integer>(2);
        root1.right = new Node<Integer>(3);
        root1.left.left = new Node<Integer>(4);
        root1.left.right = new Node<Integer>(5);
        root1.right.left = new Node<Integer>(6);
        root1.left.right.left = new Node<Integer>(7);
        root1.left.right.right = new Node<Integer>(8);
  
        Node<Integer> root2 = new Node<>(1);
        root2.left = new Node<Integer>(3);
        root2.right = new Node<Integer>(2);
        root2.right.left = new Node<Integer>(4);
        root2.right.right = new Node<Integer>(5);
        root2.left.right = new Node<Integer>(6);
        root2.right.right.left = new Node<Integer>(8);
        root2.right.right.right = new Node<Integer>(7);
  
        if (isIsomorphic(root1, root2) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
