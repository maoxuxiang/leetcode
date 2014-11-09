package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public class Solution {
	    public List<String> generateParenthesis(int n) {
	        List<String> res = new ArrayList<String>();
	        StringBuffer sb = new StringBuffer();
	        
	        return generateParenthesis(res, sb, 0, 0, n);
	        
	    }
	    
	    private List<String> generateParenthesis(List<String> res, StringBuffer sb, int LBegin,int RBegin, int End) {
	        if (LBegin == End && RBegin == End) {
	            res.add(sb.toString());
	        }
	        if (LBegin < End) {
	            sb.append('(');
	            generateParenthesis(res, sb, LBegin+1,RBegin, End);
	            sb.deleteCharAt(sb.length()-1);
	        }
	        if ( RBegin<LBegin) {
	            sb.append(')');
	            generateParenthesis(res, sb, LBegin,RBegin+1, End);
	            sb.deleteCharAt(sb.length()-1);
	        }
	        return res;
	    }
	}
}
