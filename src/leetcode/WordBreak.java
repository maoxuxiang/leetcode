package leetcode;

import java.util.Set;

/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".*/
public class WordBreak {
	//http://www.cnblogs.com/springfor/p/3874731.html
	public class Solution {
	    public boolean wordBreak(String s, Set<String> dict) {
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
