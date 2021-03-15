package org.manas.dsalgo.interviewbit.array;

import java.util.*;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 *
 * Example 2:
 *
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 *
 *  * Example 3:
 *  *
 *  * Given [1,2],[3,5], insert and merge [8,10] would result in [1,2],[3,5],[8,10].
 *
 *
 * Make sure the returned intervals are also sorted.
 */


public class MergeIntervals {


    public static void main(String[] args) {
        Interval interval1 = new Interval(1,2);
        Interval interval2 = new Interval(3,5);
        //Interval interval3 = new Interval(6,7);
        //Interval interval4 = new Interval(8,10);
        //Interval interval5 = new Interval(12,16);

        Interval newInterval = new Interval(8,10);

        ArrayList<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        //list.add(interval3);
        //list.add(interval4);
        //list.add(interval5);
        MergeIntervals mergeIntervals = new MergeIntervals();
        ArrayList<Interval> result = mergeIntervals.insert(list, newInterval);

        result.stream().forEach(item -> {
            System.out.println(item.start + ", " + item.end );
        });
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<>();

        Interval newStart = new Interval(newInterval.start, newInterval.start);
        int i = Collections.binarySearch(intervals, newStart, inRangeCompA);
        if(i < 0){
            i = -(i+1);
            intervals.add(i, newStart);
        }
        Interval newEnd = new Interval(newInterval.end, newInterval.end);
        int j = Collections.binarySearch(intervals, newEnd, inRangeCompA);
        if(j < 0){
            j = -(j+1);
            intervals.add(j, newEnd);
        }
        if(i != j){
            Interval v = intervals.get(i);
            v.end = intervals.get(j).end;
            intervals.set(i, v);
            intervals.subList(i+1, j+1).clear();
        }
        return intervals;
    }

    Comparator<Interval> inRangeCompA = (a, b) -> {
        return (a.end < b.start ) ? -1 : ((a.start > b.end) ? 1 : 0);
    };








}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
