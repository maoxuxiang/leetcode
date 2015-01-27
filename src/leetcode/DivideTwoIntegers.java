package leetcode;
//Divide two integers without using multiplication, division and mod operator.
public class DivideTwoIntegers {
	public class Solution {
		
		    public int divide(int dividend, int divisor) {
		        if (dividend == Integer.MIN_VALUE && divisor == -1) {
		            return Integer.MAX_VALUE;
		        }
		        long a = Math.abs((long)dividend);
		        long b = Math.abs((long)divisor);
		        
		        int res = 0;
		        while (a >= b) {
		            
		            int count = 0;
		            while (a>=(b<<count)) {
		                count++;
		            }
		            a -= b<<(count-1);
		            res += 1<<(count-1);
		        }
		        
		        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
		            return res;
		        }
		        else {
		            return -res;
		        }
		    }
		}
	
}
