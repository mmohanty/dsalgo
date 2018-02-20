package org.manas.dynamicprogramming;

import java.util.Stack;

/**
 * Created by mohanty on 03-09-2016.
 */
public class BracketValidator {

    /*public boolean validateBracket(String token) {
        if (token == null || token.length() % 2 != 0) {
            return false;
        }
        char tokens[] = token.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char tokenChar : tokens) {
            Bracket bracket = Bracket.getInstance(tokenChar);
            if(bracket == null){
                return false;
            }
            if (bracket.isClosedBracket()) {
                if (stack.isEmpty() || stack.pop() != bracket.getCounterPart()) {
                    return false;
                }
            } else {
                stack.push(bracket.getChar());
            }
        }
        return stack.isEmpty();
    }*/
}

enum Bracket {
    LEFT_SQUARE('[', ']',false), RIGHT_COUNTERPART(']', '[', true),
    LEFT_PARENTHESIS('(', ')', false), RIGHT_PARENTHESIS(')', '(', true),
    LEFT_CURLY('{', '}', false), RIGHT_CURLY('}', '{', true);

    Bracket(char c, char counterPart, boolean closed) {
        this.c = c;
        this.counterPart = counterPart;
        this.closed = closed;
    }

    private char c;
    private char counterPart;
    private boolean closed;

    public static Bracket getInstance(char c) {
        for(Bracket bracket : Bracket.values()){
            if(bracket.getChar() == c ){
                return bracket;
            }
        }
        return null;
    }

    public boolean isClosedBracket(){
        return this.closed;
    }
    public char getChar(){
        return this.c;
    }
    public char getCounterPart() {
        return this.counterPart;
    }
}