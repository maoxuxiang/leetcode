package leetcode;
/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
public class ClimbingStairs {
	public class Solution {
	    public int climbStairs(int n) {
	        int[] map = new int[n+1];
	        if (n == 0 || n == 1) {
	            return 1;
	        }
	        map[0] = 1;
	        map[1] = 1;
	        for (int i=2; i<=n; i++) {
	            map[i] = map[i-1] + map[i-2];
	        }
	        
	        return map[n];
	    }
	}
}
