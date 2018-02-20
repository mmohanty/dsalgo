package org.manas.sort;

/**
 * Created by mohanty on 27-07-2016.
 */
public class QuickSort {

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = getPivot(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    private int getPivot(int[] arr, int low, int high) {
        int pivot = arr[high];
        int swapPosition = low - 1;
        for (int currentPosition = low; currentPosition < high; currentPosition++) {
            if (arr[currentPosition] <= pivot) {
                swapPosition++;
                swap(arr, swapPosition, currentPosition);
            }
        }
        swap(arr, swapPosition + 1, high);
        return swapPosition + 1;
    }

    private void swap(int[] arr, int swapPosition, int currentPosition) {
        if(swapPosition == currentPosition){
            return;
        }
        int temp = arr[currentPosition];
        arr[currentPosition] = arr[swapPosition];
        arr[swapPosition] = temp;
    }
}
