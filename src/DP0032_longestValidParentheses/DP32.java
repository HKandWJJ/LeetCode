package DP0032_longestValidParentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号：给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * *********************************************************************
 * 思路总结:
 * 初始化一个长度为 s.length 的数组 dp，用于存储以每个字符结尾的最长有效括号子串的长度。
 * 遍历字符串 s，从第二个字符开始：
 * 如果当前字符是 ')'，则需要考虑它可能与前面的字符组成有效括号对。
 * 如果前一个字符是 '('，则说明这两个字符组成了一个有效括号对，长度为 dp[i - 2] + 2。
 * 如果前一个字符是 ')'，则需要考虑与前面的有效括号对是否可以组成新的有效括号对。
 * 如果 i - dp[i - 1] - 1 位置的字符是 '('，则说明这两个字符组成了一个有效括号对，长度为 dp[i - 1] + 2。
 * 更新 dp[i] 的值为上述两种情况的较大值。
 * 每次更新 dp[i] 之后，将 maxans 更新为 maxans 和 dp[i] 中的较大值。
 * 最终返回 maxans 作为最长有效括号子串的长度。
 * *********************************************************************
 * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。
 * 空间复杂度：O(n)，需要额外的空间来存储 dp 数组。
 */
class Solution_DP {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}

/**
 * 栈：
 * 初始化一个栈，将 -1 作为栈底元素。
 * 遍历字符串 s，对于每个字符：
 * 如果当前字符是 '('，将其下标入栈。
 * 如果当前字符是 ')'，弹出栈顶元素，表示匹配到一个有效括号对。
 * 如果栈为空，则将当前字符的下标入栈，作为新的起始位置。
 * 如果栈不为空，则更新最长有效括号子串的长度为当前字符的下标减去栈顶元素的下标。
 * 最终返回最长有效括号子串的长度。
 * *********************************************************************
 * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。
 * 空间复杂度：O(n)，需要额外的空间来存储栈。
 */
class Solution_stack {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
