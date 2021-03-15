package org.manas.dsalgo.interviewbit.array;

import java.util.*;

/**
 * Problem Description
 *
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has C rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .
 *
 *
 *
 * Input Format
 * First argument is an integer array A containing arrival time of booking.
 * Second argument is an integer array B containing departure time of booking.
 * Third argument is an integer C denoting the count of rooms.
 *
 *
 *
 * Output Format
 * Return True if there are enough rooms for N bookings else return False.
 * Return 0/1 for C programs.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 3, 5]
 *  B = [2, 6, 8]
 *  C = 1
 *
 *
 * Example Output
 * Output 1:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class HotelBookingsPossible {


    public static void main(String[] args) {
        int a[] = {40, 18}; // expected [2, 1, 4, 3]
        List<Integer> arrival = ArrayUtil.toList(a);


        int b[] = {40, 43}; // expected [2, 1, 4, 3]
        List<Integer> depart = ArrayUtil.toList(b);

        int k = 1;
        HotelBookingsPossible hbp = new HotelBookingsPossible();

        boolean result = hbp.hotel(arrival, depart, k);

        System.out.print( result);
    }


    public boolean hotel(List<Integer> arrive, List<Integer> depart, int k) {

        int n = arrive.size();

        HotelBooking ans[] = new HotelBooking[2*n];
        for (int i = 0, j =0; i < n; i++, j++)
        {
            ans[i + j] =  new HotelBooking(arrive.get(i), 1);
            ans[i + j + 1] =  new HotelBooking(depart.get(i), 0);
        }

        Arrays.sort(ans);

        int curr_active = 0, max_active = 0;
        for (int i = 0; i < 2 * n; i++)
        {

            // if new arrival, increment current
            // guests count and update max active
            // guests so far
            if (ans[i].depart == 1)
            {
                curr_active++;
                max_active = Math.max(max_active,
                        curr_active);
            }

            // if a guest departs, decrement
            // current guests count.
            else
                curr_active--;
        }

        // if max active guests at any instant
        // were more than the available rooms,
        // return false. Else return true.
        return (k >= max_active);


    }
}


class HotelBooking implements  Comparable<HotelBooking>{
    int arrival;
    int depart;

    HotelBooking(int arrival, int depart){
        this.arrival =arrival;
        this.depart = depart;
    }

    @Override
    public int compareTo(HotelBooking other) {
        if(this.arrival == other.arrival){
            return 0;
        }else if(this.arrival > other.arrival){
            return 1;
        }else if(this.arrival < other.arrival){
            return  -1;
        }
        return 0;
    }
}
