package leetcode;
/*//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//
//Note: The sequence of integers will be represented as a string.
*/
public class CountandSay {
	public class Solution {
	    public String countAndSay(int n) {
	        String first = "1";
	        for (int i=1; i<n; i++) {
	            first = generateStr(first);
	        }
	        return first;
	     
	    }
	    
	    public String generateStr(String n) {
	        char last = n.charAt(0);
	        int count = 1;
	        StringBuffer str = new StringBuffer();
	        for (int i =1; i<n.length(); i++) {
	            if (n.charAt(i) == last) {
	                count++;
	            }
	            else {
	                
	                str.append(count);
	                str.append(last);
	                last = n.charAt(i);
	                count = 1;
	            }
	        }
	        
	        str.append(count);
	        str.append(last);
	        return str.toString();
	    }
	}
}
