package org.manas.dsalgo.interviewbit.array;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example:
 *
 * Given [1,3],[2,6],[8,10],[15,18],
 *
 * return [1,6],[8,10],[15,18].
 *
 * Make sure the returned intervals are sorted.
 *
 *
 * //A : [ (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6) ]
 * The expected returned value :
 * (1, 10)
 */
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Interval interval1 = new Interval(1,10);
        Interval interval2 = new Interval(2,9);
        Interval interval3 = new Interval(3,8);
        Interval interval4 = new Interval(4,7);
        Interval interval5 = new Interval(5,6);
        Interval interval6 = new Interval(6,6);

        String str = " (30, 63), (66, 94), (36, 87), (16, 86), (26, 85), (24, 50), (17, 84), (5, 25), (67, 81), (23, 54), (84, 99), (48, 85), (23, 28), (3, 86), (63, 79), (18, 73), (6, 68), (34, 40), (61, 66), (60, 96), (95, 99), (1, 10), (4, 82), (19, 78), (23, 61), (30, 45), (53, 87), (10, 42), (80, 93), (33, 73), (64, 65), (29, 71), (73, 89), (2, 98), (62, 67), (84, 98), (43, 58), (20, 45), (86, 92), (22, 100), (72, 74), (5, 52), (48, 56), (69, 93), (8, 98), (37, 47), (19, 45), (22, 99), (34, 97), (21, 80), (58, 77), (48, 66), (59, 91), (18, 33), (2, 7), (8, 92), (12, 32), (17, 83), (11, 16), (60, 75), (9, 11), (3, 61), (4, 18), (53, 68), (17, 39), (18, 93), (15, 55), (4, 34), (48, 85), (61, 65), (59, 77), (15, 37), (62, 82), (4, 78), (80, 96), (4, 42), (15, 48), (27, 45),";
        //expected 1,100

        //String str = " (5, 28), (7, 70), (54, 93), (5, 98), (46, 70), (42, 63), (5, 91), (30, 49), (36, 57), (31, 95), (86, 88), (9, 90), (5, 53), (42, 62), (14, 100), (59, 75), (32, 100), (5, 79), (31, 31), (7, 42), (13, 47), (44, 87), (61, 83), (100, 100), (96, 98), (47, 51), (34, 44), (6, 53), (30, 92), (50, 64), (37, 57), (49, 67), (2, 67), (36, 50), (55, 100), (54, 78), (58, 70), (2, 37), (13, 54), (7, 60), (16, 79), (35, 78), (17, 57), (16, 84), (60, 80), (10, 54), (54, 59), (62, 85), (7, 37), (31, 99), (40, 41), (4, 99), (28, 45), (27, 71), (14, 64),";
        //2,100
        String s[] = str.split("\\),");

        ArrayList<Interval> list = new ArrayList<>();

        for(String s1: s){
            //System.out.println(s1);
            String s3[] = s1.split(",");
            Interval interval = new Interval(Integer.valueOf(s3[0].substring(2)), Integer.valueOf(s3[1].substring(1)));
            list.add(interval);
        }

        //list.add(interval1);
        //list.add(interval2);
        //list.add(interval3);
        //list.add(interval4);
        //list.add(interval5);
        //list.add(interval6);
        MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();
        ArrayList<Interval> response = mergeOverlappingIntervals.merge(list);

        response.stream().forEach(item ->{
            System.out.println(item.start + ","+ item.end) ;
        });
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {


        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval prev, Interval curr) {
                return curr.start > prev.start ? -1 : curr.start == prev.start? 0 : 1;
            }
        });
        Interval interval = new Interval();

        Stack<Interval> stack = new Stack<>();
        int index = 1;
        stack.push(intervals.get(0));
    //Given [1,3],[2,6],[8,10],[15,18],
    // *
    // * return [1,6],[8,10],[15,18].
        while (index < intervals.size()){
            Interval top = stack.peek();
            Interval current = intervals.get(index);
            if(current.start <= top.end){//overlapping
                stack.pop();
                interval.start = Math.min(top.start, current.start);;
                interval.end = Math.max(current.end, top.end);
                stack.push(interval);
            }else {
                stack.push(current);
            }
            index++;
        }

        ArrayList<Interval> result = new ArrayList<>(stack.size());
        while (!stack.isEmpty()){
                Interval interval1 = stack.pop();
                result.add(interval1);
        }
        Collections.reverse(result);
        return result;
    }
}

