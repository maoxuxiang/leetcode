package leetcode;
//Divide two integers without using multiplication, division and mod operator.
public class DivideTwoIntegers {
	public class Solution {
	    public int divide(int dividend, int divisor) {
	        long p = Math.abs((long)dividend);
	        long q = Math.abs((long)divisor);
	        
	        int res = 0;
	        while (p >= q) {
	            int count = 0;
	            while (p >= (q<< count)) {
	                count ++;
	            }
	            
	            p -= q << (count-1);
	            res += 1 << (count -1);
	        }
	        
	        if (dividend < 0 && divisor< 0 || dividend > 0 && divisor>0) {
	            return res;
	        } 
	        else {
	            return -res;
	        }
	    }
	}
}
