package leetcode;

import java.util.Stack;

/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/
public class EvaluateReversePolishNotation {
	public class Solution {
	    public int evalRPN(String[] tokens) {
	        if (tokens == null || tokens.length == 0) {
	            return 0;
	        }
	        Stack<String> st = new Stack<String>();
	        for (int i=0; i<tokens.length; i++) {
	            if (!checkOper(tokens[i])) {
	                st.push(tokens[i]);
	            }
	            else {
	                String str = tokens[i];
	                int a = Integer.parseInt(st.pop());
	                int b = Integer.parseInt(st.pop());
	                int res;
	                switch (str) {
	                    case "+": res = a+b;
	                              break;
	                    case "-": res = b-a;
	                              break;
	                    case "*": res = a*b;
	                              break;
	                    case "/": res = b/a;
	                              break;
	                    default:  res = 0;
	                              break;
	                }
	                st.push(Integer.toString(res));
	            }
	        }
	        return Integer.parseInt(st.pop());
	    }
	    
	    private boolean checkOper(String c) {
	        if (c.equals("+") || c.equals("-")  || c.equals("*")  || c.equals("/") ) {
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	}
}
