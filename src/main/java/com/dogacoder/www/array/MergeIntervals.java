package com.dogacoder.www.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
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
 */
public class MergeIntervals {


    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        Collections.sort(intervals, new SortbyFirst());

        List<Interval> res = new ArrayList<>();
        int k = 1;
        Interval first = intervals.get(0);
        while (k < intervals.size()) {
            List<Interval> tempList = merge2Intervals(first, intervals.get(k));
            if (tempList.size() > 1) {
                res.add(tempList.get(0));
                first = tempList.get(1);
            }
            else {
                first = tempList.get(0);
            }
            k++;
        }
        res.add(first);
        return (ArrayList<Interval>) res;
    }

    @Test
    public void test() {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        System.out.println(merge(list));
    }


    private ArrayList<Interval> merge2Intervals(Interval one, Interval two) {
        List<Interval> merged = new ArrayList<>();
        if (one.getEnd() < two.getStart()) {
            merged.add(one);
            merged.add(two);
        }
        else {
            merged.add(new Interval(Math.min(one.getStart(), two.getStart()), Math.max(one.getEnd(), two.getEnd())));
        }
        return (ArrayList<Interval>) merged;

    }

    class Interval {
        int start = 0;
        int end = 0;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    class SortbyFirst implements Comparator<Interval>
    {
        @Override
        public int compare(Interval one, Interval two) {
            return one.getStart() - two.getStart();
        }
    }
}
