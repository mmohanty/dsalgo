package org.manas.dsalgo.sorting;

public class HeapSort {
    public void sort(final int []a){
        int length = a.length;
        for(int i =length/2 -1; i >= 0 ; i--){
            heapify(a, i, length);
        }
        for(int i = length -1; i >= 0; i --){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapify(a, 0 ,i);
        }
    }

    private void heapify(int[] a, int i, int n) {
        int parentIndex = i;
        int leftChildIndex = 2*i + 1;
        int rightChildIndex = 2*i +2;

        if(leftChildIndex < n && a[parentIndex] < a[leftChildIndex]){
            parentIndex = leftChildIndex;
        }
        if(rightChildIndex < n && a[parentIndex] < a[rightChildIndex]){
            parentIndex = rightChildIndex;
        }

        if(parentIndex != i){
            int temp = a[i];
            a[i] = a[parentIndex];
            a[parentIndex] = temp;
            heapify(a, parentIndex, n);
        }
    }
}
