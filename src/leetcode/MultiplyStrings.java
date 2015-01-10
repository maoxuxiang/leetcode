package leetcode;
/*Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.*/
public class MultiplyStrings {
	public class Solution {
	    public String multiply(String num1, String num2) {
	        String n1 = new StringBuilder(num1).reverse().toString();
	        String n2 = new StringBuilder(num2).reverse().toString();
	        
	        int[] res = new int[n1.length()+n2.length()];
	        for (int i=0; i<n1.length(); i++) {
	            for (int j=0; j<n2.length(); j++) {
	                res[i+j] += (n2.charAt(j)-'0')*(n1.charAt(i)-'0');
	            }
	        }
	        
	        StringBuffer sb = new StringBuffer();
	        for (int i=0; i<res.length; i++) {
	            int digit = res[i]%10;
	            int carry = res[i]/10;
	            if (i+1<res.length) {
	                res[i+1] += carry;
	            }
	            sb.insert(0,digit);
	        }
	        while (sb.charAt(0) == '0'&& sb.length() > 1) {
	            sb.deleteCharAt(0);
	        } 
	        
	        return sb.toString();
	        
	    }
	}
}
