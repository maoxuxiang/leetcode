package leetcode;

import java.util.LinkedList;
import java.util.Set;

/*Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.*/
public class WordLadder {
	public class Solution {
	    public int ladderLength(String start, String end, Set<String> dict) {
	        if (start == null || end == null || start.length() == 0 || end.length() == 0 || start.length() != end.length()) {
	            return 0;
	        }
	        
	        LinkedList<String> queue = new LinkedList<String>();
	        int level = 1;
	        int curnum = 1;
	        int nextnum = 0;
	        
	        queue.add(start);
	        
	        while (!queue.isEmpty()) {
	            String str = queue.poll();
	            curnum --;
	            
	            for (int i=0; i<str.length(); i++) {
	                char[] arrchar = str.toCharArray();
	                for (char j='a'; j<='z'; j++) {
	                    arrchar[i] = j;
	                    String s = new String(arrchar);
	                    
	                    if (s.equals(end)) {
	                        return level + 1;
	                    }
	                    if (dict.contains(s)) {
	                        queue.add(s);
	                        nextnum++;
	                        dict.remove(s);
	                    }
	                }
	            }
	            
	            if (curnum == 0) {
	                level++;
	                curnum = nextnum;
	                nextnum = 0;
	            }
	        }
	        return 0;
	    }
	}
	
}
