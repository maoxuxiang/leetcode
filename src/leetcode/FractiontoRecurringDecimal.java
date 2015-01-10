package leetcode;

import java.util.HashMap;
import java.util.Map;

/*Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".*/
public class FractiontoRecurringDecimal {
	
	/*这题实现起来还是比较麻烦的，主要还要考虑负数的输入情况，特别是-2147483648这样的整数型的边界值。最简单的方法就是先把所有的输入全部转换为长整型的正数。

	另外，由于要记录小数里循环的部分，所以还需要用到一个Map去记录小数点的每位和对应的余数值。如果碰到的同样的余数值，那么说明遇到了开始循环的部分了。
*/	public class Solution {
	    public String fractionToDecimal(int numerator, int denominator) {
	        if (denominator == 0) {
	            return "";
	        }
	        if (numerator == 0) {
	            return "0";
	        }
	        
	        long num = numerator;
	        long den = denominator;
	        
	        StringBuilder sb = new StringBuilder();
	        if (num*den < 0) {
	            sb.append('-');
	        }
	        num = Math.abs(num);
	        den = Math.abs(den);
	        long digit = num / den;
	        sb.append(digit);
	        num = num % den;
	        if (num != 0) {
	            sb.append(".");
	        }
	        
	        StringBuilder frasb = new StringBuilder();
	        Map<Long, Integer> map = new HashMap<Long, Integer>();
	        int idx = 0;
	        while (num != 0) {
	            if (map.containsKey(num)) {
	                frasb.insert(map.get(num),"(");
	                frasb.append(")");
	                break;
	            }
	            map.put(num, idx++);
	            num = num * 10;
	            digit = num / den;
	            frasb.append(digit);
	            num = num % den;
	        }
	        
	        sb.append(frasb);
	        
	        return sb.toString();
	    }
	}
}
