package org.manas.sort;

/**
 * Created by mohanty on 28-07-2016.
 */
public class MergeSort {
    public void sort(int[] arr, int low, int high) {
        if(low < high){
            int med = (low + high)/2 ;
            sort(arr, low, med);
            sort(arr, med+1, high);
            merge(arr, low, med, high);
        }
    }

    private void merge(int[] arr, int low, int med, int high) {
        int sizeOfFirstArray = med - low + 1;
        int sizeOfSecondArray = high - med;

        int []arr1 = new int[sizeOfFirstArray];
        int []arr2 = new int[sizeOfSecondArray];

        for(int i = 0; i < sizeOfFirstArray ; i++){
            arr1[i] = arr[ low+i];
        }
        for(int i = 0; i < sizeOfSecondArray ; i++){
            arr2[i] = arr[med+1+i];
        }


        int i=0, j=0, k = low;

        while( i < sizeOfFirstArray && j < sizeOfSecondArray){
            if(arr1[i] <= arr2[j]){
                arr[k] = arr1[i];
                i++;
            }else{
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < sizeOfFirstArray){
            arr[k++] = arr1[i++];
        }
        while(j < sizeOfSecondArray){
            arr[k++] = arr2[j++];
        }

    }
}
