package SS0076_minWindow;

/**
 * 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * *********************************************************************************************************************
 * 思路总结:
 * 1. 用两个数组分别记录字符串 t 中每个字符出现的次数和当前窗口中每个字符出现的次数。
 * 2. 用两个指针 l 和 r 分别表示窗口的左右边界，用一个计数器 count 记录当前窗口中已经包含了多少个 t 中的字符。
 * 3. 当 count 等于 t 中不同字符的个数时，说明当前窗口已经包含了 t 中的所有字符，此时可以尝试缩小窗口，即移动左指针 l。
 * 4. 当 count 不等于 t 中不同字符的个数时，说明当前窗口还没有包含 t 中的所有字符，此时可以尝试扩大窗口，即移动右指针 r。
 * 5. 当 count 等于 t 中不同字符的个数时，更新最小覆盖子串的长度和起始位置。
 * 6. 当 count 不等于 t 中不同字符的个数时，继续移动右指针 r。
 * 7. 当 r 到达字符串 s 的末尾时，结束循环。
 * 8. 返回最小覆盖子串。
 * *********************************************************************************************************************
 * 时间复杂度: O(n),其中 n 是字符串 s 的长度。
 * 空间复杂度: O(n)
 */
class Solution{
    public String minWindow(String s, String t){
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[] hash1 = new int[128];
        int m = 0;
        for (int i = 0; i < t.length(); i++){
            char in = cht[i];
            if(hash1[in] == 0){
                ++m;
            }
            hash1[in]++;
        }
        int l = 0, r = 0;
        int count = 0;
        int minLen = s.length() + 1;
        int begin = -1;
        int[] hash2 = new int[128];
        while(r < s.length()){
            char in = chs[r];
            hash2[in]++;
            if(hash1[in] == hash2[in]){
                ++count;
            }
            while(count == m){
                if(minLen > r - l + 1){
                    minLen = r - l + 1;
                    begin = l;
                }
                char out = chs[l];
                if(hash2[out] == hash1[out]){
                    --count;
                }
                hash2[out]--;
                ++l;
            }
            ++r;
        }
        if(begin == -1){
            return "";
        }else {
            return s.substring(begin, begin + minLen);
        }
    }
}
