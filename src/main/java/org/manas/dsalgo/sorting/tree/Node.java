package org.manas.dsalgo.sorting.tree;

public class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;
	
	Node(){
	}
	Node(T data){
		this.data = data;
	}
}
