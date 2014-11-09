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
	    public int reverse2(int x) {
	        
	        if (x < 0) {
	            return -reverse(-x);
	        }
	        
	        int i = 10;
	        int res = 0;
	        int digit;
	        
	        while (x > 0) {
	            digit = x % i;
	            res = res*10 +digit;
	            x = x / i;
	        }
	        
	        return res;
	    }
	}
}
