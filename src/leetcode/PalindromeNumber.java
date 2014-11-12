package leetcode;
/*Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.*/
public class PalindromeNumber {
	public class Solution {
	    public boolean isPalindrome(int x) {
	    
	    if (x < 0) {
	        return false;
	    }
	    
	    if (x <= 9) {
	        return true;
	    }
	    
	    int len =0;
	    while ((int) (x / Math.pow(10.0, len)) >0) {
	        len ++;
	    }
	    
	    for (int i = 0; i < len /2;++i) {
	        if((int) (x / Math.pow(10.0, i) % 10) != (int) (x / Math.pow(10.0, len - 1-i) % 10)) {
	            return false;
	        }
	    }
	    
	    return true;
	        
	    }
	}
}