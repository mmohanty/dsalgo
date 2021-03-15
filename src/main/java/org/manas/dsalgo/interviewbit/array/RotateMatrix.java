package org.manas.dsalgo.interviewbit.array;

import java.util.ArrayList;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note that if you end up using an additional array, you will only receive partial score.
 *
 * Example:
 *
 * If the array is
 *
 * [
 *     [1, 2],
 *     [3, 4]
 * ]
 * Then the rotated array becomes:
 *
 * [
 *     [3, 1],
 *     [4, 2]
 * ]
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int a[] = {1,2,3};

        int b[] = {4,5,6};
        int c[] = {7,8,9};

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList(ArrayUtil.toList(a)));
        list.add(new ArrayList(ArrayUtil.toList(b)));
        list.add(new ArrayList(ArrayUtil.toList(c)));

        System.out.println("The matrix before rotation ");
        print_matrix(list);
        System.out.println("Transpose of the matrix ");
        transpose_matrix(list);
        System.out.println("The matrix after rotation ");
        reverse_rows(list);
        print_matrix(list);
    }

    // Function to reverse rows of the matrix
    public static void reverse_rows(ArrayList<ArrayList<Integer>> a)
    {
        int length = a.size();
        int k;
        for (int i = 0; i < length; i++)
        {
            k = length-1;
            for (int j = 0; j < k; j++)
            {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(i).get(k));
                a.get(i).set(k, temp);
                k--;
            }}}

    // Function to print the matrix
    public static void print_matrix(ArrayList<ArrayList<Integer>> a)
    {
        int length = a.size();
        int i,j;
        for(i=0;i<length;i++)
        {
            for(j=0;j<length;j++)
            {
                System.out.print(a.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }}

    // Function to transpose the matrix
    public static void transpose_matrix(ArrayList<ArrayList<Integer>> a)
    {
        int length = a.size();
        int i,j;
        for(i=0;i<length;i++)
        {
            for(j=i;j<length;j++)
            {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }}}
}
