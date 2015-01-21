package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.*/
public class LargestNumber {
	public class Solution {
	    public String largestNumber(int[] num) {
	        if (num == null || num.length == 0) {
	            return "0";
	        }
	        String[] str = new String[num.length];
	        for (int i=0;i<str.length; i++) {
	            str[i] = ""+ num[i];
	        }
	        Arrays.sort(str, new myComp());
	        
	        StringBuilder sb = new StringBuilder();
	        for (String s: str) {
	            sb.append(s);
	        }
	        String res = sb.toString();
	        int i=0;
	        while (i<res.length()&&res.charAt(i) == '0') {
	            i++;
	        }
	        if (i == res.length()) {
	            return "0";
	        }
	        return res;
	        
	    }
	}

	class myComp implements Comparator<String> {
	    public int compare(String a, String b) {
	        String ab = a.concat(b);
	        String ba = b.concat(a);
	        return Integer.parseInt(ba) - Integer.parseInt(ab);
	    }
	}
	
}
