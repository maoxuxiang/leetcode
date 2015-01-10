package leetcode;
/*Compare two version numbers version1 and version1.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37*/
public class CompareVersionNumbers {
	public class Solution {
	    public int compareVersion(String version1, String version2) {
	        String[] v1 = version1.split("\\.");
	        String[] v2 = version2.split("\\.");
	        
	        int maxlen;
	        if (v1.length > v2.length) {
	            maxlen = v1.length;
	        }
	        else {
	            maxlen = v2.length;
	        }
	        int [] arr1 = new int[maxlen];
	        int [] arr2 = new int[maxlen];
	        
	        for (int i=0; i<v1.length; i++) {
	            arr1[i] = Integer.parseInt(v1[i]);
	        }
	        for (int i=0; i<v2.length; i++) {
	            arr2[i] = Integer.parseInt(v2[i]);
	        }
	        
	        for (int i=0; i<maxlen; i++) {
	            if (arr1[i] > arr2[i]) {
	                return 1;
	            }
	            else if (arr1[i] < arr2[i]) {
	                return -1;
	            }
	        }
	        
	        return 0;
	    }
	}
}
