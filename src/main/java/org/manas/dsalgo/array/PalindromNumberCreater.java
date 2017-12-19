package org.manas.dsalgo.array;

import java.util.Arrays;

/**
 * Form the largest palindromic number using atmost two swaps Given a
 * non-negative palindromic number num containing n number of digits. The
 * problem is to apply at most two swap operations on the number num so that the
 * resultant is the largest possible palindromic number.
 * 
 * Examples:
 * 
 * Input : 4697557964 Output : 9647557469 In, 4697557964 the highlighted digits
 * were swapped to get the largest palindromic number 9647557469.
 * 
 * Input : 54345 Output : 54345 No swapping of digits required.
 */
public class PalindromNumberCreater {

	public static void formPalindrom(final int[] arr) {
		int length = arr.length;
		if (length == 3) {
			return;
		}

		int mid = length / 2;
		boolean isOddSizePalindrom = length % 2 == 0 ? false : true;

		int maxSofar = 0;
		int maxSofarIndex = -1;

		int high = isOddSizePalindrom ? mid : mid - 1;
		for (int index = 0; index <= high; index++) {
			if (arr[index] > maxSofar) {
				maxSofar = arr[index];
				maxSofarIndex = index;
			}
		}
		if (maxSofarIndex != 0) {
			int leftIndex = maxSofarIndex;
			int rightIndex;
			if(isOddSizePalindrom) {
				rightIndex = maxSofarIndex + (2 * (mid - maxSofarIndex));
			}else {
				rightIndex = (length -1)-maxSofarIndex;
			}
			
			swap(arr, maxSofar, leftIndex, rightIndex);
		}
	}

	// handle situation for odd size palindrom and middle element is the
	// highest one.
	private static void swap(int[] arr, int element, int left, int right) {

		// Swap 1
		int temp = arr[0];
		arr[0] = element;
		arr[left] = temp;

		// Swap 2
		arr[arr.length - 1] = element;
		arr[right] = temp;
	}

	public static void main(String[] args) {
		//int[] array = { 4, 6, 9, 7, 5, 5, 7, 9, 6, 4 };
		int[] array = { 1,2,3,9,3,2,1 };
		Arrays.stream(array).forEach(System.out::print);
		formPalindrom(array);
		System.out.println();
		Arrays.stream(array).forEach(System.out::print);
	}
}
