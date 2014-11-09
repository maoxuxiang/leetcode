package leetcode;

import java.util.Stack;

/*Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) 
parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.*/
public class LongestValidParentheses {
	public class Solution {
	    public int longestValidParentheses(String s) {
	       if (s == null || s.length()<2) {
	           return 0;
	       }
	       
	       int len = s.length();
	       Stack<Integer> stack =new Stack<Integer>();
	       stack.push(-1);
	       int res = 0;
	       
	       for (int i=0; i<len; ++i) {
	           if (s.charAt(i) == '(') {
	               stack.push(i);
	           }
	           else {
	               int top = stack.peek();
	               if (top >=0 && s.charAt(top) == '(') {
	                   stack.pop();
	                   if (i-stack.peek() > res) {
	                       res = i-stack.peek();
	                   }
	               }
	               else stack.push(i);
	           }
	       }
	       return res;
	    }
	}
}
