package DP0279_numSquares;

/**
 * 完全平方数:给你一个整数n，返回和为n的完全平方数的最少数量。
 * ******************************************************
 * 思路总结:
 * 对于每个i从1到n，要找到一个最小的minn，使得f[i]可以由f[i - j * j]转移而来
 * 遍历所有可能的完全平方数 j * j，并更新 minn 为 min(minn, f[i - j * j])
 * 最后，f[i] 的值为 minn + 1，表示在 f[i - j * j] 的基础上再加上一个完全平方数 j * j
 * 最终结果为 f[n]，即和为 n 的完全平方数的最少数量
 * ******************************************************
 * 时间复杂度:O(n * \sqrt(n)),其中 n 为给定的正整数。状态转移方程的时间复杂度为 O(\sqrt(n))，共需要计算n个状态
 * 空间复杂度:O(n)
 */
class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int minn = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
