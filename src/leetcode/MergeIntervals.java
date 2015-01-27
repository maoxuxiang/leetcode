package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/
public class MergeIntervals {
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	public class Solution {
	    public List<Interval> merge(List<Interval> intervals) {
	        if (intervals == null || intervals.size() <=1) {
	            return intervals;
	        }
	        
	        Collections.sort(intervals, new myComp());
	        
	        List<Interval> res = new ArrayList<Interval>();
	        Interval pre = intervals.get(0);
	        
	        for (int i=1; i<intervals.size(); i++) {
	            Interval cur = intervals.get(i);
	            if (pre.end >= cur.start) {
	                Interval item = new Interval(pre.start, Math.max(cur.end,pre.end));
	                pre = item;
	            }
	            else {
	                res.add(pre);
	                pre = cur;
	            }
	        }
	        res.add(pre);
	        
	        return res;
	    }
	    
	    class myComp implements Comparator<Interval> {
	        public int compare(Interval a, Interval b) {
	            return a.start - b.start;
	        }
	    }
	}
	
}
