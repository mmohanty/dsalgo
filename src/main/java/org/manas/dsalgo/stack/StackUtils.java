package org.manas.dsalgo.stack;

import java.util.Stack;


public class StackUtils {

	public static <E> void swap(Stack<E> stackOne, Stack<E> stackTwo) {

		int length1 = stackOne.size();
		int length2 = stackTwo.size();

		if (length1 == 0 && length2 == 0) {
			return;
		}
		E stackOneELement = null;
		E stackTwoELement = null;

		if (!stackOne.isEmpty()) {
			stackOneELement = stackOne.pop();
		}
		if (!stackTwo.isEmpty()) {
			stackTwoELement = stackTwo.pop();
		}
		swap(stackOne, stackTwo);

		if (stackTwoELement != null) {
			stackOne.push(stackTwoELement);
		}
		if (stackOneELement != null) {
			stackTwo.push(stackOneELement);
		}
	}
	
	public static void main(String[] args) {

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		// inserting data
		s1.add(1);
		s1.add(2);
		s1.add(3);

		s2.add(4);
		s2.add(5);
		s2.add(6);
		s2.add(7);

		System.out.println("---- BEFORE SWAP ----\n");
		System.out.println("s1 -> " + s1);
		System.out.println("s2 -> " + s2);

		swap(s1, s2);

		System.out.println("\n---- AFTER SWAP ----\n");
		System.out.println("s1 -> " + s1);
		System.out.println("s2 -> " + s2);
	}
}
