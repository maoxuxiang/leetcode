package leetcode;
/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].*/
public class InsertInterval {
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
	    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        List<Interval> res = new LinkedList<Interval>();
	        
	        if (intervals == null || intervals.size() == 0) {
	            res.add(newInterval);
	            Collections.sort(res, new myComp());
	            return res;
	        }
	        
	        if (newInterval.end < intervals.get(0).start) {
	            intervals.add(newInterval);
	            Collections.sort(intervals, new myComp());
	            return intervals;
	        }
	        
	        if (newInterval.start > intervals.get(intervals.size()-1).end) {
	            intervals.add(newInterval);
	            Collections.sort(intervals, new myComp());
	            return intervals;
	        }
	        
	        int i=0;
	        while (i<intervals.size()) {
	            Interval cur = intervals.get(i);
	            if (cur.end >= newInterval.start) {
	                break;
	            }
	            i++;
	        }
	        
	        int j=0;
	        while (j<intervals.size()) {
	            Interval cur = intervals.get(j);
	            if (cur.start > newInterval.end) {
	                break;
	            }
	            j++;
	        }
	        
	        if (j-1<i) {
	            intervals.add(newInterval);
	            Collections.sort(intervals, new myComp());
	            return intervals;
	        }
	        
	        
	        
	        Interval item = new Interval(Math.min(intervals.get(i).start, newInterval.start),
	        Math.max(intervals.get(j-1).end,newInterval.end));
	        
	        for (int a=0; a<i; a++) {
	            res.add(intervals.get(a));
	        }
	        res.add(item);
	        for (int b=j; b<intervals.size(); b++) {
	            res.add(intervals.get(b));
	        }
	        

	        
	        return res;
	    }
	   
	}
	 
	    class myComp implements Comparator<Interval> {
	        public int compare(Interval a, Interval b) {
	            return a.start - b.start;
	        }
	    }

//solution2
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
	        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	            List<Interval> res = new ArrayList<Interval>();
	            
	            for (Interval i: intervals) {
	                if (i.end < newInterval.start) {
	                    res.add(i);
	                }
	                else if (i.start > newInterval.end) {
	                    res.add(newInterval);
	                    newInterval = i;
	                }
	                else if (i.start<=newInterval.end || i.end >= newInterval.start) {
	                    int nstart = Math.min(i.start, newInterval.start);
	                    int nend = Math.max(i.end, newInterval.end);
	                    newInterval = new Interval(nstart,nend);
	                }
	            }
	            
	            res.add(newInterval);
	            return res;
	        }
	    }
}
