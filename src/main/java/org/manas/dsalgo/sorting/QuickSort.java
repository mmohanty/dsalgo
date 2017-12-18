package org.manas.dsalgo.sorting;

public class QuickSort {

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void quicksort(int[] array, int low, int high){
        if(low < high){
            int pi = partion(array, low, high);
            quicksort(array, low, pi+1);
            quicksort(array, pi+1, high);
        }
    }

	private int partion(int[] array, int low, int high) {
		
		int pivot = array[high];
		
		int startIndex = low-1;
		
		for(int j = low; j< high; j++){
			if(array[j] < pivot){
				startIndex++;
				swap(array, startIndex, j);
			}
		}
		swap(array, startIndex+1, high);
		return startIndex+1;
		
	}




}



