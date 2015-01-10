package leetcode;
//Implement pow(x, n).    time - O(log(n))
public class Pow_X_n {
	public class Solution {
	    public double pow(double x, int n) {
	        if (n < 0) {
	            return 1 / power(x, -n);
	        }
	        return power(x, n);
	    }
	    
	    private double power(double x, int n) {
	        if (n == 0) {
	            return 1.0;
	        }
	        double half = power(x, n/2);
	        if (n % 2 == 0) {
	            return half*half;
	        }
	        else {
	            return half*half*x;
	        }
	    }

	}
}
