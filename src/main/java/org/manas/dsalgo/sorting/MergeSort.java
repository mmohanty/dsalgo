package org.manas.dsalgo.sorting;

public class MergeSort {
    public void sort(int[] arr, int low, int high){
        if (low < high){
            int mid = (low + high)/2;
            sort(arr, low, mid);
            sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int size1 = mid - low +1;
        int size2 = high - mid;
        int []array1 = new int[size1];
        int []array2 = new int[size2];

        for (int i = 0; i < size1; i++){
            array1[i] = arr[low+i];
        }
        for (int i = 0; i < size2; i++){
            array2[i] = arr[mid+1+i];
        }

        int i = 0, j = 0;
        int k = low;

        while( i < size1 && j <size2){
            if(array1[i] >= array2[j]){
                arr[k] = array2[j];
                j++;
            }
            else{
                arr[k] = array1[i];
                i++;
            }
            k++;
        }
        while(i < size1){
            arr[k] = array1[i];
            i++;
            k++;
        }
        while(j < size2){
            arr[k] = array2[j];
            j++;
            k++;
        }
    }
}
