package leetcode;

/*Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
then the reverse of 1000000003 overflows. How should you handle such cases?

Throw an exception? Good, but what if throwing an exception is not an option? 
You would then have to re-design the function (ie, add an extra parameter).*/

public class ReverseInteger {
	public class Solution {
	    public int reverse(int x) {
	        if (x < 0) {
	            return -reverse(-x);
	        }
	        String num = Integer.toString(x);
	        StringBuffer res = new StringBuffer();
	        
	        for (int i =num.length()-1; i>=0; --i) {
	            res.append(num.charAt(i));
	        }
	        
	        return Integer.parseInt(res.toString());
	    }
	    
	    // solution2 
	    public class Solution2 {
	        public int reverse(int x) {
	            if (x == Integer.MIN_VALUE) {
	                return 0;
	            }
	            int num = Math.abs(x);
	            int res = 0;
	            int digit = 0;
	            
	            while (num>0) {//越界检查
	                if (res > (Integer.MAX_VALUE)/10) {
	                    return 0;
	                }
	                digit = num % 10;
	                res = res*10 + digit;
	                num = num/10;
	            }
	            return x >0? res: -res;
	        }
	    }
	}
}
