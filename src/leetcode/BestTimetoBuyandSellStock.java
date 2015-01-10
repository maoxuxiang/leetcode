package leetcode;
/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.*/
public class BestTimetoBuyandSellStock {
	public class Solution {
	    public int maxProfit(int[] prices) {
	        if (prices.length ==0 || prices == null) {
	            return 0;
	        }
	        int buy = prices[0];
	        int profit = 0;
	        
	        for (int i=0; i<prices.length; i++) {
	            buy = Math.min(prices[i], buy);
	            profit = Math.max(prices[i]-buy,profit);
	        }
	        
	        return profit;
	    }
	}
}
