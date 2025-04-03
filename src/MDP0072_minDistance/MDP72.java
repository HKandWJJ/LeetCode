package MDP0072_minDistance;

/**
 * 编辑距离:给你两个单词word1和word2，请你计算出将word1转换成word2所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * *************************************************************************
 * 思路总结:
 * 1.定义二维数组 dp[i][j]，表示 word1 的前 i 个字符和 word2 的前 j 个字符之间的编辑距离。
 * 2.初始化 dp 数组，dp[i][0] = i，dp[0][j] = j，表示 word1 或 word2 为空字符串时的编辑距离。
 * 3.状态转移方程：
 * 如果 word1[i] == word2[j]，则 dp[i][j] = dp[i-1][j-1]，表示当前字符相同，不需要进行操作。
 * 如果 word1[i] != word2[j]，
 *      插入：dp[i][j-1] + 1(在 word1 中插入 word2[j-1])
 *      删除：dp[i-1][j] + 1(删除 word1[i-1])
 *      替换：dp[i-1][j-1] + 1(将 word1[i-1] 替换为 word2[j-1])
 *      取三者最小值：dp[i][j] = min(插入, 删除, 替换)
 *      表示当前字符不同，需要进行插入、删除或替换操作，取这三种操作的最小值。
 * 4.最终结果为 dp[n][m]，其中 n 为 word1 的长度，m 为 word2 的长度。
 * *************************************************************************
 * 时间复杂度: O(n*m)
 * 空间复杂度: O(n*m)
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n * m == 0){
            return n + m;
        }
        int[][] D = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++){
            D[i][0] = i;
        }
        for(int j = 0; j < m + 1; j++){
            D[0][j] = j;
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
