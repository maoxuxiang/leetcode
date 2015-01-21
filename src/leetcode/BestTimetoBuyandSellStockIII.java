package leetcode;
/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Show Tags*/

public class BestTimetoBuyandSellStockIII {
	public class Solution {
	    public int maxProfit(int[] prices) {
	        if (prices.length <=1 || prices == null) {
	            return 0;
	        }
	        int[] profitA = new int[prices.length];
	        int buy = prices[0];
	        for (int i=1; i<profitA.length; i++) {
	            profitA[i] = Math.max(profitA[i-1],prices[i]-buy);
	            buy = Math.min(prices[i], buy);
	        }
	        
	        int[] profitB = new int[prices.length];
	        int sell = prices[prices.length-1];
	        for (int i=prices.length-2; i>=0; i--) {
	            profitB[i] = Math.max(profitB[i+1],sell-prices[i]);
	            sell = Math.max(sell, prices[i]);
	        }
	        
	        int profit = 0;
	        for (int i=0; i<prices.length; i++) {
	            profit = Math.max(profit, profitA[i]+profitB[i]);
	        }
	        
	        return profit;
	    }
	}
}
