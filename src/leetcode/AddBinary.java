package leetcode;
/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/
public class AddBinary {
	public class Solution {
	    public String addBinary(String a, String b) {
	        if (a == null || a.length() == 0) {
	            return b;
	        }
	        
	        if (b == null || b.length() == 0) {
	            return a;
	        }
	        
	        int m = a.length() - 1;
	        int n = b.length() - 1;
	        int carry = 0;
	        int digit = 0;
	        StringBuilder sb = new StringBuilder();
	        
	        while (m >= 0 && n >= 0) {
	            digit = (int)(a.charAt(m)-'0')+(int)(b.charAt(n)-'0')+carry;
	            carry = digit / 2;
	            digit = digit % 2;
	            sb.insert(0,digit);
	            m--;
	            n--;
	        }
	        while (m >= 0) {
	            digit = (int)(a.charAt(m)-'0') + carry;
	            carry = digit / 2;
	            digit = digit % 2;
	            sb.insert(0,digit);
	            m--;
	        }
	        while (n >= 0) {
	            digit = (int)(b.charAt(n)-'0') + carry;
	            carry = digit / 2;
	            digit = digit % 2;
	            sb.insert(0,digit);
	            n--;
	        }
	        if (carry > 0) {
	            sb.insert(0,carry);
	        }
	        
	        return sb.toString();
	        
	     }
	}
}
