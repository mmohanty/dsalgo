package org.manas.dsalgo.problems;

import java.util.Stack;

/**
 * Given two expressions in the form of strings. The task is to compare them and check if they are 
 * similar. 
 * Expressions consist of lower case alphabets, '+', '-' and  '( )'.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases 
 * follow. Each test case contains two lines. And each line contains an expression.

 * Output
 * For each test case, print in a new line "YES"  if the expressions are similar else print "NO".

 * Constraints:
 * 1<=T<=100
 * 3<=|Expression length|<=100

 * Example:
 * Input:
 * 2
 * -(a+b+c)
 * -a-b-c
 * 
 * a-b-(c-d)
 * a-b-c-d

 * Output:
 * YES
 * NO
 * @author manasmohanty
 *
 */
public class ExpressionEvaluator {

	public boolean areExpressionsEqual(String exp1, String exp2) {
		
		String postfixExp1 = postfixExpression(exp1.toCharArray());
		String postfixExp2 = postfixExpression(exp2.toCharArray());
		
		return postfixExp1.equals(postfixExp2);
	}

	private String postfixExpression(char[] tokens) {
		Stack<Character> operatorStack = new Stack<>();
		for(int index = 0; index < tokens.length; index++) {
			Character c = tokens[index];
			if(c == '(') {
				//do something
				if(index != 0) {
					operatorStack.push(tokens[index-1]);
				}else {
					operatorStack.push('+');
				}
			}
			else if(c == ')') {
				//do something
				char sign = operatorStack.pop();
				tokens[index] = ' ';
				int tempIndex = index;
				while(1 != 0) {
					if(tokens[tempIndex] == '(') {
						//check tempIndex character. If it's a operator then change tempIndex-1 to EMPTY.
						if(tokens[tempIndex+1] == '-' || tokens[tempIndex+1] == '+') {
							tokens[tempIndex-1] = ' ';
						}
						tokens[tempIndex] = ' ';
						break;
					}
					if(tokens[tempIndex] == '-' || tokens[tempIndex] == '+') {
						tokens[tempIndex] = changeSignOfOperator(tokens[tempIndex], sign);
					}
					tempIndex--;
				}
			}
		}
		return buildString(tokens);
	}

	private String buildString(char[] tokens) {
		StringBuilder builder = new StringBuilder();
		for(char ch:tokens) {
			if(ch == ' ') {
				continue;
			}else {
				builder.append(ch);
			}
		}
		return builder.toString();
	}
	
	private char changeSignOfOperator(char current, char sign) {
		if(current == sign) {
			return '+';
		}else {
			return '-';
		}
	}

	public static void main(String[] args) {
		ExpressionEvaluator evaluator = new ExpressionEvaluator();
		String str1 = "-(a+b+c)";
		String str2 = "-a-b-c";
		System.out.println(evaluator.areExpressionsEqual(str1, str2));
		
		String str3 = "a-b-(c-d)";
		String str4 = "a-b-c-d";
		System.out.println(evaluator.areExpressionsEqual(str3, str4));
		
		String str5 = "a-b-(-c+d)";
		String str6 = "a-b+c-d";
		System.out.println(evaluator.areExpressionsEqual(str5, str6));
	}
}
