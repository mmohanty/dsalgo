package org.manas.dsalgo.problems;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		String str = "((()()";
        System.out.println(findMaxLen(str));
      
        str = "()(()))))";
        System.out.println(findMaxLen(str));
	}

	private static int findMaxLen(String str) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int result = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push(i);
			}else {
				stack.pop();
				if(!stack.isEmpty()) {
					result = Math.max(result, i - stack.peek());
				}else {
					stack.push(i);
				}
			}
		}
		return result;
	}
}
