package leetcode;

import java.util.Stack;

/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/
public class ValidPalindrome {
	public class Solution {
	    public boolean isPalindrome(String s) {
	        if (s == null || s.length() == 0) {
	            return true;
	        }
	        s = s.toLowerCase();
	        Stack<Character> st = new Stack<Character>();
	        int count = 0;
	        for (int i=0; i<s.length(); i++) {
	            if (checkvalid(s.charAt(i))) {
	                count ++;
	            }
	        }
	        int num = count/2;
	        for (int i=0; i<s.length(); i++) {
	            if (checkvalid(s.charAt(i)) && num>0) {
	                st.push(s.charAt(i));
	                num--;
	                continue;
	            }
	            if (checkvalid(s.charAt(i)) ) {
	                if (count%2 == 0) {
	                    if (st.pop() != s.charAt(i)) {
	                        return false;
	                    }
	                }
	                else {
	                    count ++;
	                    continue;
	                }
	            }
	        }
	        
	        return true;
	    }
	    private boolean checkvalid (char c) {
	        if (c >= 'a' && c <= 'z') {
	            return true;
	        }
	        if (c >= '0' && c <= '9') {
	            return true;
	        }

	        return false;
	    }
	}
}
