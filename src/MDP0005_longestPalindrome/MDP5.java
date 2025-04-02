package MDP0005_longestPalindrome;

/**
 * 最长回文子串:给你一个字符串 s，找到 s 中最长的回文子串。
 * **********************************************************************
 * 思路总结:
 * 1. 边界条件判断：如果字符串长度小于 2，直接返回该字符串。
 * 2. 初始化：所有长度为 1 的子串都是回文串。
 * 3. 递推开始：
 *    - 枚举子串长度：从 2 开始，逐渐增加子串长度。
 *    - 枚举左边界：左边界的上限可以宽松一些，因为对于长度为 L 的子串，左边界的最大值为 n - L。
 *    - 计算右边界：根据左边界和子串长度，可以计算出右边界。
 *    - 状态转移方程：如果左边界和右边界的字符相同，并且子串的长度小于等于 3，或者子串的内部也是回文串，那么当前子串也是回文串。
 *    - 更新最长回文子串：如果当前子串是回文串，并且长度大于之前记录的最长回文子串的长度，更新最长回文子串的起始位置和长度。
 * 4. 返回最长回文子串：根据最长回文子串的起始位置和长度，从原字符串中截取最长回文子串。
 * **********************************************************************
 * 时间复杂度：O(n^2)，其中 n 是字符串的长度。
 * 空间复杂度：O(n^2)，需要使用一个二维数组 dp 来存储每个子串是否为回文串。
 */
class Solution_MDP {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

/**
 * 中心扩展算法:
 * 思路总结:
 * 1. 边界条件判断：如果字符串长度小于 2，直接返回该字符串。
 * 2. 初始化：最长回文子串的起始位置和长度。
 * 3. 中心扩展：
 *    - 枚举中心位置：从 0 到字符串长度 - 1。
 *    - 奇数长度回文：从中心位置开始，向两边扩展。
 *    - 偶数长度回文：从中心位置和中心位置的下一个字符开始，向两边扩展。
 *    - 记录最长回文子串：如果当前回文子串的长度大于之前记录的最长回文子串的长度，更新最长回文子串的起始位置和长度。
 * 4. 返回最长回文子串：根据最长回文子串的起始位置和长度，从原字符串中截取最长回文子串。
 * **********************************************************************
 * 时间复杂度：O(n^2)，其中 n 是字符串的长度。
 * 空间复杂度：O(1)，只使用了常数个变量。
 */
class Solution_MDP_2 {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}