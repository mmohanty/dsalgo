package org.manas.dsalgo.interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 *
 * If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.
 *
 * Note:
 *
 * 1. The replacement must be in-place, do **not** allocate extra memory.
 * 2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
 * Input Format:
 *
 * The first and the only argument of input has an array of integers, A.
 * Output Format:
 *
 * Return an array of integers, representing the next permutation of the given array.
 * Constraints:
 *
 * 1 <= N <= 5e5
 * 1 <= A[i] <= 1e9
 * Examples:
 *
 * Input 1:
 *     A = [1, 2, 3]
 *
 * Output 1:
 *     [1, 3, 2]
 *
 * Input 2:
 *     A = [3, 2, 1]
 *
 * Output 2:
 *     [1, 2, 3]
 *
 * Input 3:
 *     A = [1, 1, 5]
 *
 * Output 3:
 *     [1, 5, 1]
 *
 * Input 4:
 *     A = [20, 50, 113]
 *
 * Output 4:
 *     [20, 113, 50]
 */
public class NextPermutation {

    public static void main(String[] args) {
        //int digits[] = { 5,3,4,9,7,6 }; // 536479
        //int digits[] = { 444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52 };
        //expcted
        //444 994 508 72 125 299 181 238 354 223 691 249 838 890 758 675 424 199 201 788 609 582 979 259 901 371 766 759 983 728 220 16 158 822 515 488 846 321 908 469 84 460 961 285 417 142 952 626 916 247 116 975 202 734 128 312 499 274 213 208 472 265 315 335 205 784 708 681 160 448 365 165 190 693 606 226 351 241 526 311 164 98 422 363 103 747 507 669 153 856 701 695 52 319
        //int n = digits.length;
      //  List list = ArrayUtil.toList(digits);

       // NextPermutation nextPermutation = new NextPermutation();
       // List<Integer> response = nextPermutation.nextPermutation((ArrayList) list);


        //response.stream().forEach( item -> System.out.print(item + " "));

        //int digits[] = { 444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52 };
        //int digits[] = { 1};
        int []digits = {251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991};
        int n = digits.length;
        nextGreater nextGreater = new nextGreater();
        nextGreater.findNext(digits, n);

    }
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {


        int position = -1;
        int rMHN = A.get(A.size()-1);
        for(int index = A.size() -2; index > 0; index --){
            if(A.get(index) < rMHN){
                position = index;
                break;
            }
        }

        //Already Sorted - As per Requirement sort the element
        if(position == -1){
            Collections.sort(A);
            return A;
        }

         //swap position
        int temp = A.get(position);
        A.set(position, rMHN);
        A.set(A.size() -1, temp);

        //sort from position+1 to Size

        sort(A, position+1, position+1);
        return  A;
    }

    public void sort(List<Integer> list, int position, int offset)
    {
        int n = list.size();

        // Build heap (rearrange array)
        for (int i = (((n -position) / 2 ) + position) - 1; i >= position; i--)
            heapify(list, n, i, offset);

        // One by one extract an element from heap
        for (int i = n - 1; i > position; i--) {
            // Move current root to end
            int temp = list.get(position);
            list.set(position, list.get(i));
            list.set(i, temp);


            // call max heapify on the reduced heap
            heapify(list, i, position, position);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(List<Integer> list, int n, int i, int offset)
    {
        int largest = i; // Initialize largest as root
        int l = (2 * (i - offset) + 1) + offset; // left = 2*i + 1
        int r = (2 * (i - offset) + 2) + offset;// right = 2*i + 2

        // If left child is larger than root
        if (l < n && list.get(l) > list.get(largest))
            largest = l;

        // If right child is larger than largest so far
        if (r < n && list.get(r) > list.get(largest))
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = list.get(i);
            list.set(i, list.get(largest));
           list.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(list, n, largest, offset);
        }
    }

}

 class nextGreater
{
    // Utility function to swap two digit
    static void swap(int ar[], int i, int j)
    {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    // Given a number as a char array number[],
    // this function finds the next greater number.
    // It modifies the same array to store the result
    static void findNext(int ar[], int n)
    {
        int i;

        // I) Start from the right most digit
        // and find the first digit that is smaller
        // than the digit next to it.
        for (i = n - 1; i > 0; i--)
        {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        if (i == 0)
        {
            System.out.println("Not possible");
        }
        else
        {
            int x = ar[i - 1], min = i;

            // II) Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < n; j++)
            {
                if (ar[j] > x && ar[j] < ar[min])
                {
                    min = j;
                }
            }

            // III) Swap the above found smallest
            // digit with number[i-1]
            swap(ar, i - 1, min);

            // IV) Sort the digits after (i-1)
            // in ascending order
            Arrays.sort(ar, i, n);
            System.out.print("Next number with same" +
                    " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(ar[i] + " ");
        }
    }


}
