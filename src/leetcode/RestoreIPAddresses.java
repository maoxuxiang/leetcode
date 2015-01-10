package leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/
public class RestoreIPAddresses {
	public class Solution {
	    public List<String> restoreIpAddresses(String s) {
	        List<String> res = new ArrayList<String>();
	        if (s.length() > 12 || s.length() < 4) {
	            return res;
	        }
	        StringBuffer sb = new StringBuffer();
	        helper(res, s, 0, sb);
	        return res;
	    }
	    
	    private void helper(List<String> res, String str, int start, StringBuffer sb) {
	        if (start == 3 && isvalid(str)) {
	            sb.append(str);
	            res.add(sb.toString());
	        }
	        
	        for (int i=1; i<=3 && i<str.length(); i++) {
	            String sub = str.substring(0,i);
	            int len = sb.length();
	            if (isvalid(sub)) {
	                sb.append(sub);
	                sb.append('.');
	                helper(res, str.substring(i), start+1, sb);
	            }
	            sb.delete(len,sb.length());
	        }
	    }
	    
	    private boolean isvalid(String str) {
	        if (str.charAt(0) == '0') {
	            return str.equals("0");
	        }
	        
	        int num = Integer.parseInt(str);
	        if (num > 255 || num < 0) {
	            return false;
	        } else {
	            return true;
	        }
	    }
	}
}
