package org.manas.dsalgo.sorting.tree;

/**
 * Inorder Tree Traversal without recursion and without stack!
 * 
 * @author manasmohanty
 *
 */
public class MorrisTreeTraversal {

	/**
	 * 1. Initialize current as root. 
	 * 2. While current is not NULL
	 * If current does not have left child
     *  a) Print current’s data
     *  b) Go to the right, i.e., current = current->right
   	 * Else
     *  a) Make current as right child of the rightmost 
     *   node in current's left subtree
     *  b) Go to this left child, i.e., current = current->left
	 * @param node Root Node
	 */
	public static <T> void inOrderTraversal(Node<T> node){
		Node<T>  pre = null;
		if(node == null) {
			return;
		}
		Node<T> current = node;
		
		while(current != null) {
			if(current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			}else {
				pre = current.left;
				while(pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if(pre.right == null) {
					pre.right = current;
					current = current.left;
				}
				else
                {
                   pre.right = null;
                   System.out.print(current.data + " ");
                   current = current.right;
               } 
			}
		}
	}
	
	  
    public static void main(String args[]) 
    {
        /* Constructed binary tree is
               1
             /   \
            2      3
          /  \
        4     5
        */
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
          
        inOrderTraversal(root);
        System.out.println();
        preOrderTraversal(root);
    }
    
    /**
     * 1...If left child is null, print the current node data. Move to right child.
     *   ….Else, Make the right child of the inorder predecessor point to the current node. 
     *       Two cases arise:
	 *        ………a) The right child of the inorder predecessor already points to the current node. 
	 *              Set right child to NULL. Move to right child of current node.
	 *        ………b) The right child is NULL. Set it to current node. 
	 *              Print current node’s data and move to left child of current node.
	
	 * 2...Iterate until current node is not NULL.
     * @param root
     */
	public static <T> void preOrderTraversal(Node<T> root) {
		Node<T> node = root;
		while (node != null) {

			// If left child is null, print the current node data. Move to
			// right child.
			if (node.left == null) {
				System.out.print(node.data + " ");
				node = node.right;
			} else {

				// Find inorder predecessor
				Node<T> current = node.left;
				while (current.right != null && current.right != node) {
					current = current.right;
				}

				// If the right child of inorder predecessor already points to
				// this node
				if (current.right == node) {
					current.right = null;
					node = node.right;
				}

				// If right child doesn't point to this node, then print this
				// node and make right child point to this node
				else {
					System.out.print(node.data + " ");
					current.right = node;
					node = node.left;
				}
			}
		}
	}
	/**
	 * 
	 * @param root
	 */
	public static <T> void postOrderTraversal(NodeS<T> root) {
		NodeS<T> temp = root;
		while (temp != null && !temp.isVisited) {
			 
	        // Visited left subtree
	        if (temp.left != null && !temp.left.isVisited)
	            temp = temp.left;
	 
	        // Visited right subtree
	        else if (temp.right != null && !temp.right.isVisited)                 
	            temp = temp.right;
	 
	        // Print node
	        else {
	            System.out.println(temp.data + " ");
	            temp.isVisited = true;
	            temp = root;
	        }
	    }
	}
	
	
	class NodeS<T>{
		boolean isVisited;
		NodeS<T> left, right;
		T data;
		NodeS(T data) {
			this.data = data;
		}
	}
}


