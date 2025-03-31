package DP0322_coinChange;

import java.util.Arrays;

/**
 * 零钱兑换：给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1。
 * **************************************************************************************************
 * 思路总结：
 * 定义一个最大值 max，其值为 amount + 1，用于后续比较和标记无法凑出的金额。
 * 创建一个长度为 amount + 1 的数组 dp，数组元素初始化为 max，表示初始时认为无法凑成这些金额。
 * 将 dp[0] 初始化为 0，因为凑成金额 0 不需要任何硬币。
 * 采用两层循环遍历：外层循环从 1 到 amount，表示要凑成的目标金额。内层循环遍历所有硬币面额。
 * 对于每个目标金额 i 和每个硬币面额 coins[j]，若 coins[j] <= i，意味着当前硬币面额可以用于凑成金额 i，此时更新 dp[i] 的值，
 * 取其当前值和 dp[i - coins[j]] + 1 中的较小值。这里 dp[i - coins[j]] + 1 表示使用当前硬币 coins[j] 后，凑成金额 i 所需的硬币数。
 * 遍历结束后，查看 dp[amount] 的值：若 dp[amount] > amount，说明无法凑成总金额 amount，返回 -1。否则，返回 dp[amount]，即凑成总金额所需的最少硬币数。
 * **************************************************************************************************
 * 时间复杂度:O(n * m),其中 n 为给定的金额数，m 为硬币面额的数量
 * 空间复杂度:O(n)
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}