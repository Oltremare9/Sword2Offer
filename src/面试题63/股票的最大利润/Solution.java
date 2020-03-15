package 面试题63.股票的最大利润;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int res = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length - 1; i++) {
            if (res < prices[i + 1] - min)
                res = Math.max(prices[i + 1] - min, res);
            if (prices[i + 1] < min)
                min = prices[i + 1];
        }
        return res;
    }
}