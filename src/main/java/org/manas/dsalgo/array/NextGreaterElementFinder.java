package org.manas.dsalgo.array;

import java.util.Stack;

public class NextGreaterElementFinder {

	/**
	 * 1) Push the first element to stack. 
	 * 2) Pick rest of the elements one by one
	 *    and follow following steps in loop. 
	 *    ….a) Mark the current element as next.
	 *    ….b) If stack is not empty, then pop an element from stack and compare it
	 *        with next. 
	 *    ….c) If next is greater than the popped element, then next is the
	 *         next greater element for the popped element. 
	 *    ….d) Keep popping from the stack
	 *          while the popped element is smaller than next. next becomes the next greater
	 *          element for all such popped elements 
	 *     ….e) If next is smaller than the popped
	 *          element, then push the popped element back. 
	 * 3) After the loop in step 2 is
	 *    over, pop all the elements from stack and print -1 as next element for them.
	 * 
	 * @param array
	 */
	public static void printNextElementFinder(int[] array) {
		int i = 0;
		Stack<Integer> stack = new Stack<>();
		int element, next;
		stack.push(array[i]);

		for (int index = 1; index < array.length; index++) {
			next = array[index];
			if (!stack.isEmpty()) {
				element = stack.pop();
				/*
				 * If the popped element is smaller than next, then a) print the pair b) keep
				 * popping while elements are smaller and stack is not empty
				 */
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (stack.isEmpty() == true)
						break;
					element = stack.pop();
				}

				/*
				 * If element is greater than next, then push the element back
				 */
				if (element > next)
					stack.push(element);
			}
			/*
			 * push next to stack so that we can find next greater for it
			 */
			stack.push(next);
		}
		/*
		 * After iterating over the loop, the remaining elements in stack do not have
		 * the next greater element, so print -1 for them
		 */
		while (stack.isEmpty() == false) {
			element = stack.pop();
			next = -1;
			System.out.println(element + " -- " + next);
		}
	}
	 public static void main(String[] args) 
	    {
	        int arr[] = { 11, 13, 21, 3 };
	        printNextElementFinder(arr);
	    }
}
