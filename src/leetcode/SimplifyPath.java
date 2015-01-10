package leetcode;

import java.util.LinkedList;

/*Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"*/
public class SimplifyPath {
	public class Solution {
	    public String simplifyPath(String path) {
	        if (path == null) {
	            return "";
	        }
	        
	        String[] info = path.split("/");
	        LinkedList<String> ls = new LinkedList<String>();
	        for (int i=0; i<info.length; i++) {
	            if (info[i].equals("..")) {
	                if (!ls.isEmpty()) {
	                    ls.pop();
	                }
	                else 
	                    continue;
	            }
	            else if (info[i].equals(".") || info[i].length() == 0) {
	                continue;
	            }
	            else {
	                ls.push(info[i]);
	            }
	        }
	        StringBuilder sb = new StringBuilder();
	        if (ls.isEmpty()) {
	            ls.push("");
	        }
	        while (!ls.isEmpty()) {
	            sb.append("/");
	            sb.append(ls.removeLast());
	           
	        }
	        return sb.toString();
	    }
	}
}
