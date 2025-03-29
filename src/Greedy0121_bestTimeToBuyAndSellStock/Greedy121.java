package Greedy0121_bestTimeToBuyAndSellStock;

/**
 * 买卖股票的最佳时机：最大值减最小值
 * *****************************************************
 * 思路总结：
 * 1、准备两个变量minprice和maxprofit，分别表示最低价格和最大利润。
 * 2、遍历prices数组，如果当前价格小于minprice，就更新minprice；
 *  否则，计算当前价格与minprice的差值，如果大于maxprofit，就更新maxprofit。
 * 3、遍历结束后，maxprofit就是最大利润。
 * *****************************************************
 * 补充：
 * 贪心算法：在每一步选择中都采取当前状态下最好或最优（即最有利）的选择，从而希望导致结果是全局最好或最优的算法。
 * *****************************************************
 * 时间复杂度：O(n)，其中n是prices数组的长度，只需要遍历一次数组。
 * 空间复杂度：O(1)，只需要常数级别的额外空间。
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minprice){
                minprice = prices[i];
            }else if(prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}