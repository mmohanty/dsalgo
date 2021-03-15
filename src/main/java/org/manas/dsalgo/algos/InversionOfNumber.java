package org.manas.dsalgo.algos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class InversionOfNumber {

	@Test
	public void testInversion() {
		int num = 13;
		//00001101
		Queue<Integer> binaryQueue = convertDecimalToBinary(num);
		
		//00001101 --> 11110010 = 242
		int inversionNumber = invertBinary(binaryQueue);
		
		Assert.assertEquals(242, inversionNumber);;
	}

	private int invertBinary(Queue<Integer> binaryQueue) {
		int result = 0, count = 0;
		while(!binaryQueue.isEmpty()) {
			int invert = binaryQueue.poll() == 1 ? 0 : 1;
			result += ( invert * Math.pow(2, count++)) ;
		}
		if(count % 8 != 0) {
			while(count % 8 != 0) {
				result += ( 1 * Math.pow(2, count++)) ;
			}
		}
		return result;
	}

	private Queue<Integer> convertDecimalToBinary(int i) {
		Queue<Integer> queue = new LinkedList<>();
		int temp = i;
		while(temp != 0) {
			int reminder = temp % 2;
			queue.add(reminder);
			temp = temp/2;
		}
		return queue;
	}

}
