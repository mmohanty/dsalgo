package org.manas.dsalgo.array;

import org.manas.dsalgo.utils.Utils;

/*
 *Program for array rotation
 Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
	1) Store d elements in a temp array
   		temp[] = [1, 2]
	2) Shift rest of the arr[]
   		arr[] = [3, 4, 5, 6, 7, 6, 7]
	3) Store back the d elements
   		arr[] = [3, 4, 5, 6, 7, 1, 2]
 
 */
public class ArrayRotar {

	//Juggling Algo
	public static void rotate(int[] arr, int d) {
		int length = arr.length;
		int j = 0;
		for(int i=0; i < Utils.gcd(length,d); i++){
			int temp = arr[i];
			j=i;
			while( 1 != 0) {
				int k = j+d;
				if(k >= length) {
					k = k - length;
				}
				if(k == i) {
					break;
				}
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
		
	}
	
	//Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. 
	//The idea of the algorithm is:
	//	Reverse A to get ArB. /* Ar is reverse of A */
	//	Reverse B to get ArBr. /* Br is reverse of B */
	//	Reverse all to get (ArBr) r = BA.
	
	public static void rotateArrayWithReversalArrayAlgo(int[] arr, int d) {
		reverseArray(arr, 0, d-1);
		reverseArray(arr, d, arr.length-1);
		reverseArray(arr, 0, arr.length-1);
	}

	private static void reverseArray(int[] arr, int start, int end) {
		
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
	}
}
