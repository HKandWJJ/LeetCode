package DP0139_wordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分：给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * **************************************************************************************************
 * 思路总结：
 * 定义一个长度为 s.length() + 1 的布尔数组 dp，数组元素初始化为 false，表示初始时认为无法拆分。
 * 将 dp[0] 初始化为 true，表示空字符串可以被拆分。
 * 采用两层循环遍历：外层循环从 1 到 s.length()，表示要拆分的字符串的长度。内层循环遍历所有可能的拆分位置。
 * 对于每个长度 i 和每个拆分位置 j，若 dp[j] 为 true 且 s.substring(j, i) 在 wordDict 中，
 * 则更新 dp[i] 为 true，表示可以从位置 j 拆分出 s.substring(j, i)。
 * 遍历结束后，查看 dp[s.length()] 的值：若 dp[s.length()] 为 true，说明可以拆分出整个字符串 s，返回 true。否则，返回 false。
 * **************************************************************************************************
 * 时间复杂度:O(n^2),其中 n 为给定的字符串长度
 * 空间复杂度:O(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
