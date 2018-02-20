package org.manas.stocks;

import java.util.Stack;

/**
 * Created by mohanty on 20-09-2016.
 */
public class StockSpan {

    public static void main(String[] args) {
        StockSpan sp = new StockSpan();
        int []stocks = {100,80,60,70,60,75,85};
        int []output = sp.calculateStockSpan(stocks);
        for(int i=0; i<output.length ; i++){
            System.out.println(output[i]);
        }
    }
    public int[] calculateStockSpan(int stocks[]){
        int []output = new int[stocks.length];
        output[0] =1;

        Stack<Integer> stockStack = new Stack<Integer>();
        stockStack.add(stocks[0]);

        Stack<Integer> indexStack = new Stack<Integer>();
        indexStack.add(0);

        for(int i =1 ; i < stocks.length ; i++){
            int currentStock = stocks[i];

            while (!stockStack.isEmpty() && stockStack.peek() < currentStock){
                stockStack.pop();
                indexStack.pop();
            }

            int span = indexStack.isEmpty() ? i+1 : i - indexStack.peek();
            output[i] = span;
            stockStack.push(currentStock);
            indexStack.push(i);
        }
        return output;
    }
}
