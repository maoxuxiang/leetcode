package leetcode;

/*Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        int len = 0;
	        
	        Set<Character> set = new HashSet<Character>();
	        LinkedList<Character> curNode = new LinkedList<Character>();
	        for (int i=0; i<s.length(); i++) {
	            if (!set.contains(s.charAt(i))) {
	                set.add(s.charAt(i));
	                curNode.add(s.charAt(i));
	            }
	            else {
	                while (curNode.peek() != s.charAt(i)) {
	                    set.remove(curNode.peek());
	                    curNode.poll();
	                }
	                curNode.poll();
	                curNode.add(s.charAt(i));
	            }
	            
	            len = len>curNode.size()?len:curNode.size();
	        }
	        
	        return len;
	    }
	}
}

