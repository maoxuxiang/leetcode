package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.*/
public class Anagrams {
	public class Solution {
	    public List<String> anagrams(String[] strs) {
	        List<String> res = new ArrayList<String>();
	        if (strs == null || strs.length == 0) {
	            return res;
	        }
	        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	        for (int i=0; i< strs.length; i++) {
	            char[] strChar =  strs[i].toCharArray();
	            Arrays.sort(strChar);
	            String s = new String(strChar);
	            if (map.containsKey(s)) {
	                map.get(s).add(strs[i]);
	            }
	            else{
	                map.put(s, new ArrayList<String>());
	                map.get(s).add(strs[i]);
	                
	            }
	        }
	        
	        Iterator iter = map.values().iterator();
	        while(iter.hasNext()) {
	            ArrayList item = (ArrayList<String>)iter.next();
	            if(item.size()>1) {
	                res.addAll(item);
	            }
	        }
	        return res;
	    }
	}
}
