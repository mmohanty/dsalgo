package org.manas.dsalgo.array;

/**
 Search an element in a sorted and rotated array
 3.2
 An element in a sorted array can be found in O(log n) time via binary search.
 But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
 So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
 Devise a way to find an element in the rotated array in O(log n) time.
 */

/**
 Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 key = 3
 Output : Found at index 8

 Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 key = 30
 Output : Not found

 Input : arr[] = {30, 40, 50, 10, 20}
 key = 10
 Output : Found at index 3
 */
public class SortedRotatedArrayElementIndexFinder {

    public static int findElement(int[]  arr, int element, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            if (arr[mid] == element){
                return mid;
            }
            //left half is sorted
            if(arr[low] < arr[mid]){
                if (arr[low] <= element && arr[mid] >= element){
                    return findElement(arr, element, low, mid-1);
                }
                return findElement(arr,element, mid+1, high);
            }
            //left half is not sorted. Right half is sortred.
            //1.check element lies between mid+1 and high.
            if(element > arr[mid+1] && element < arr[high]){
                return findElement(arr,element, mid+1, high);
            }
            return findElement(arr,element, low, mid+1);

        }else{
            return -1;
        }

    }

    public static void main(String args[])
    {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 6;
        int i = findElement(arr, key,0, n-1);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
}
