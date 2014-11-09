package leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.*/

public class LetterCombinationsofaPhoneNumber {
	public class Solution {
	    public List<String> letterCombinations(String digits) {
	        // if (digits == null || digits.length() == 0) {
	        //     return new ArrayList<String>();
	        // }
	        List<String> res = new ArrayList<String>();
	        String str = "";
	        String[] map = {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	        
	        //recCombinations(res, map, digits, digits.length(), new StringBuffer());
	        recCombinations2(res, map, digits, 0, new StringBuffer());
	        return res;
	    }
	    
	    // private void recCombinations(List<String> res, String[] map,String digits, int remain, StringBuffer sb) {
	    //     if (remain == 0) {
	    //         res.add(sb.toString());
	    //         return;
	    //     }
	        
	    //     String s = map[digits.charAt(0)-'0'];
	    //     for (int i = 0; i<s.length(); ++i) {
	    //         sb.append(s.charAt(i));
	    //         recCombinations(res, map, digits.substring(1), remain-1, sb);
	    //         sb.deleteCharAt(sb.length()-1);
	    //     }
	    // }
	    private void recCombinations2(List<String> res, String[] map,String digits, int start, StringBuffer sb) {
	        if (start == digits.length()) {
	            res.add(sb.toString());
	            return;
	        }
	        
	        String s = map[digits.charAt(start)-'0'];
	        for(int i = 0; i < s.length(); ++i) {
	            recCombinations2(res, map, digits, start+1, sb.append(s.charAt(i)));
	            sb.deleteCharAt(sb.length()-1);
	        }
	        
	    }
	}
}
