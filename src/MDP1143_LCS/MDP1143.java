package MDP1143_LCS;

/**
 * 最长公共子序列：给定两个字符串text1和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * *************************************************************************************************
 * 思路总结:
 * 1. 定义dp数组：dp[i][j]表示text1的前i个字符和text2的前j个字符的最长公共子序列的长度。
 * 2. 初始化dp数组：dp[0][j]和dp[i][0]都为0，因为空字符串和任何字符串的最长公共子序列长度都是0。
 * 3. 状态转移方程：
 *    如果text1[i-1] == text2[j-1]，则dp[i][j] = dp[i-1][j-1] + 1，因为当前字符相同，所以最长公共子序列长度加1。
 *    如果text1[i-1] != text2[j-1]，则dp[i][j] = max(dp[i-1][j], dp[i][j-1])，因为当前字符不同，所以最长公共子序列长度不变。
 * 4. 最终结果：dp[m][n]，其中m和n分别是text1和text2的长度。
 * *************************************************************************************************
 * 时间复杂度：O(m*n)，其中m和n分别是text1和text2的长度。
 * 空间复杂度：O(m*n)，需要使用一个二维数组来存储dp值。
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            char c1 = text1.charAt(i - 1);
            for(int j = 1; j <= n; j++){
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
