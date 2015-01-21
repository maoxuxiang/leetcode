package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/public class WordBreakII {
	public class Solution {
	    public List<String> wordBreak(String s, Set<String> dict) {
	        List<String> res = new ArrayList<String>();  
	        if(s==null || s.length()==0)  
	            return res;
	            
	        if(wordBreakcheck(s,dict)) {
		        StringBuilder sb = new StringBuilder();
		        helper(s, res, sb, dict);
	        }
	        return res;  
	    }
	    
	     
		     private void helper(String s, List<String> res, StringBuilder sb, Set<String> dict) {
		        if (s.length() == 0) {
		            if(sb.length()>0) {
		                String ss = sb.substring(0,sb.length()-1);
		                res.add(ss);
		                return;
		            }
		            
		            res.add(sb.toString());
		            return;
		        }
		        for (int i=1; i<=s.length(); i++) {
		            String str = s.substring(0, i);
		            if (dict.contains(str)) {
		                int len = str.length();
		                sb.append(str);
		                sb.append(" ");
		                helper(s.substring(i), res, sb, dict);
		                sb.delete(sb.length()-len-1,sb.length());
		            }
		            
		        }
		    }
	    
	    public boolean wordBreakcheck(String s, Set<String> dict) {
	        if (s.length() == 0 || s == null) {
	            return true;
	        }
	        
	        boolean[] map = new boolean[s.length()+1];
	        map[0] = true;
	        
	        for (int i=0; i<s.length(); i++) {
	            String str= new String(s.substring(0,i+1));
	            for (int j=0; j<str.length(); j++) {
	                if (map[j] && dict.contains(str.substring(j))) {
	                    map[i+1] = true;
	                    break;
	                }
	            }
	        }
	        
	        return map[s.length()];
	    }
	}
}

