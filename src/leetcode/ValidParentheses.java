package leetcode;
/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/
import java.util.Stack;

public class ValidParentheses {
	public class Solution {
	    
	    public boolean isValid(String s) {
	        if (s.length() == 0 || s == null || s.length() % 2 == 1) {
	            return false;
	        }
	        
	        int sum = 0;
	        Stack<Character> stack = new Stack<Character>();
	        char target = ' ';
	        
	        for (int i=0; i<s.length();++i) {
	            char c = s.charAt(i);
	            if (c == '(' || c == '[' || c == '{') {
	                sum ++;
	                stack.push(c);
	            }
	            else {
	                sum --;
	                if (sum < 0) {
	                    return false;
	                }
	                switch (c) {
	                    case ')':
	                        target = '(';
	                        break;
	                    case ']':
	                        target = '[';
	                        break;
	                    case '}':
	                        target = '{';
	                        break;
	                    default:
	                        return false;
	                }
	                if (stack.peek() != target) {
	                    return false;
	                }
	                else {
	                    stack.pop();
	                }
	            }
	        }
	        if (sum == 0) {
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	   
	}
}
