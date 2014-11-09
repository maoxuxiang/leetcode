package leetcode;

//Given an integer, convert it to a roman numeral.
//
//Input is guaranteed to be within the range from 1 to 3999.

public class IntegertoRoman {
	public class Solution {
	    public String intToRoman(int num) {
	    //I 1  
	    //V 5  
	    //X 10  
	    //L 50  
	    //C 100  
	    //D 500  
	    //M 1,000  
	    
	    if (num < 1 || num >3999) {
	        return null;
	    }
	    
	    int[] val = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] str = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i=0; num>0; i++) {
	        while (num >= val[i]) {
	            num = num - val[i];
	            sb.append(str[i]);
	        }
	    }
	    
	    return sb.toString();
	    
	    }
	}
}
