package leetcode;
/*Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.*/
public class PlusOne {
	//solution1
	public class Solution1 {
	    public int[] plusOne(int[] digits) {
	        if (digits == null || digits.length == 0) {
	            return digits;
	        }
	        int num =0;
	        for (int i: digits) {
	            if (i == 9) {
	                num++;
	            }
	        }
	        if (num == digits.length) {
	            int[] res = new int[digits.length+1];
	            res[0] = 1;
	            for (int i=1; i<res.length; i++) {
	                res[i] = 0;
	            }
	            
	            return res;
	        }
	        
	        for (int i=digits.length-1; i>=0; i--) {
	            if (digits[i] < 9) {
	                digits[i] += 1;
	                break;
	            } else {
	                digits[i] = 0;
	            }
	        }
	        
	        return digits;
	    }
	}
	//solution2
	public class Solution2 {
	    public int[] plusOne(int[] digits) {
	        if (digits == null || digits.length == 0) {
	            return digits;
	        }
	        int carry = 1;
	        for (int i=digits.length-1; i>=0; i--) {
	            int digit = (digits[i]+carry)%10;
	            carry = (digits[i]+carry)/10;
	            digits[i] = digit;
	            if (carry == 0) {
	                return digits;
	            }
	        }
	        int[] res = new int[digits.length+1];
	        res[0] = 1;
	        return res;
	    }
	}
}
