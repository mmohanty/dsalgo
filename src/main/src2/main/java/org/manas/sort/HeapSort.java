package org.manas.sort;

/**
 * Created by mohanty on 27-07-2016.
 */
public class HeapSort {

    public void sort(int[] arr) {

        int length = arr.length;

        for(int index = 0 ; index  <= length/2 -1 ; index++){
            heappify(arr, length, index);
        }

        for(int index = length -1; index >= 0; index--){
            int temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;
            heappify(arr, index, 0);
        }
    }

    private void heappify(int[] arr, int length, int index) {
        int large = index;
        int left = 2 * index +1;
        int right = 2*index +2;

        if(left < length && arr[left] > arr[large]){
            large = left;
        }
        if(right < length && arr[right] > arr[large]){
            large = right;
        }

        if(large != index){
            int temp = arr[large];
            arr[large] = arr[index];
            arr[index] = temp;
            heappify(arr, length, large);
        }

    }
}
