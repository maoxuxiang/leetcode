package leetcode;

/*Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.*/

import java.util.LinkedList;

public class LongestSubstringWithoutRepeatingCharacters {
	public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        
	        if (s.length() == 0) {
	            
	            return 0;
	        }
	        
	        int maxLen = 0;
	        
	        boolean[] map = new boolean[256];
	        LinkedList<Character> curNode = new LinkedList<Character>();
	        
	        for (int i=0; i<s.length(); ++i) {
	            if (map[s.charAt(i)] != true) {
	                map[s.charAt(i)] = true;
	                curNode.add(s.charAt(i));
	            }
	            else {
	                while (curNode.peek() != s.charAt(i)) {
	                    map[curNode.peek()] = false;
	                    curNode.poll(); 
	                }
	                curNode.poll();
	                curNode.add(s.charAt(i));
	            }
	            
	            maxLen = maxLen < curNode.size()?curNode.size():maxLen;
	        }
	        
	        return maxLen;
	    }
	    
	    
	}
}

