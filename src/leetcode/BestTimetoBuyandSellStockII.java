package leetcode;
/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
(ie, you must sell the stock before you buy again).*/
public class BestTimetoBuyandSellStockII {
	public class Solution1 {
	    public int maxProfit(int[] prices) {
	        int profit = 0;
	        for (int i=1; i<prices.length; i++) {
	            if (prices[i] > prices[i-1]) {
	                profit +=prices[i]-prices[i-1];
	            }
	        }
	        
	        return profit;
	    }
	}
	
	//solution2
	public class Solution {
	    public int maxProfit(int[] prices) {
	        if (prices.length <= 1) {
	            return 0;
	        }
	        
	        int i =0;
	        int profit = 0;
	        while (i<prices.length-1) {
	            int buy;
	            int sell;
	            while (i<prices.length-1 && prices[i]>prices[i+1]) {
	                i++;
	            }
	            buy = prices[i];
	            i++;
	            while (i<prices.length && prices[i] >= prices[i-1]) {
	                i++;
	            }
	            i--;
	            sell = prices[i];
	            
	            profit += sell-buy;
	        }
	        
	        return profit;
	    }
	}
}
