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
		
		return Math.max(lHeight, rHeight) + 1;
	}
	
	
	public static int diameterOptimized(Node<Integer> root, Height height)
    {
		/* lh --> Height of left subtree
        rh --> Height of right subtree */
		Height lh = new Height();
		Height rh = new Height();

     if (root == null)
     {
         height.h = 0;
         return 0; /* diameter is also 0 */
     }
      
     /* ldiameter  --> diameter of left subtree
        rdiameter  --> Diameter of right subtree */ 
     /* Get the heights of left and right subtrees in lh and rh
      And store the returned values in ldiameter and ldiameter */
     lh.h++;     rh.h++; 
     int ldiameter = diameterOptimized(root.left, lh);
     int rdiameter = diameterOptimized(root.right, rh);

     /* Height of current node is max of heights of left and
      right subtrees plus 1*/
     height.h = Math.max(lh.h, rh.h) + 1;

     return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }
	
	public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
		Node<Integer> root = new Node<>(1);
        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(3);
        root.left.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(5);
 
        System.out.println("The diameter of given binary tree is : "
                           + findDiameter(root));
        
        System.out.println("The diameter of given binary tree in optimized way is : "
                + diameterOptimized(root, new Height()));
    }
	
	static class Height
	{
	    int h;
	}
}
