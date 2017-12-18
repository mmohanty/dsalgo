package org.manas.dsalgo.sorting.tree;

public class TreeMirror {

	public static <T> Node<T> mirror(Node<T> node) {
		if (node == null) {
			return node;
		}
		Node<T> left = mirror(node.left);
		Node<T> right = mirror(node.right);

		node.left = right;
		node.right = left;
		return node;
	}

	public static <T> boolean areMirror(Node<T> nodea, Node<T> nodeb) {
		if (nodea == null && nodeb == null) {
			return true;
		}
		if (nodea == null || nodeb == null) {
			return false;
		}
		return nodea.data == nodeb.data && areMirror(nodea.left, nodeb.right) 
				&& areMirror(nodea.right, nodeb.left);
	}
	
	// Driver code to test above methods
    public static void main(String[] args) 
    {
    
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(1);
        a.left = new Node<Integer>(2);
        a.right = new Node<Integer>(3);
        a.left.left = new Node<Integer>(4);
        a.left.right = new Node<Integer>(5);
 
        b.left = new Node<Integer>(3);
        b.right = new Node<Integer>(2);
        b.right.left = new Node<Integer>(5);
        b.right.right = new Node<Integer>(4);
 
        if (areMirror(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
 
    }
}
