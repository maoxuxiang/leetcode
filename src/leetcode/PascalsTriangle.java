package leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/
public class PascalsTriangle {
	public class Solution {
	    public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(numRows == 0) {
	            return res;
	        }
	        
	        for (int i=0; i<numRows; i++) {
	            List<Integer> item = new ArrayList<Integer>();
	            item.add(1);
	            if (i>1) {
	                List<Integer> pre = res.get(i-1);
	                for (int j=1; j<i; j++) {
	                    item.add(pre.get(j-1)+pre.get(j));
	                }
	            }
	            if (i>0) {
	                item.add(1);
	            }
	            res.add(item);
	        }
	        return res;
	    }
	    
	    
	}
}
