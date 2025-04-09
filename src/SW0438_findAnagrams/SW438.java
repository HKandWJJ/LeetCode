package SW0438_findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串s和p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * *************************************************************************
 * 思路总结:
 * 分别获取字符串 s 和 p 的长度，并将其存储在变量 sLen 和 pLen 中。
 * 如果字符串 s 的长度小于字符串 p 的长度，则返回一个空列表，因为这样的子串不可能存在异位词。
 * 初始化两个长度为 26 的整数数组 sCount 和 pCount，用于统计字符串 s 和 p 中每个字符的出现次数。
 * 遍历字符串 p，对于 p 中的每个字符，将其对应的位置在 sCount 中增加 1。
 * 遍历字符串 s，对于 s 中的每个字符，将其对应的位置在 sCount 中增加 1，并将前一个字符对应的位置在 sCount 中减少 1。
 * 每次遍历后，比较 sCount 和 pCount 是否相等，如果相等，则将当前子串的起始索引添加到结果列表 ans 中。
 * 返回结果列表 ans。
 * ****************************************************************************
 * 时间复杂度:O(m + (n - m) * Σ),其中 n 为字符串 s 的长度，m 为字符串 p 的长度，Σ 为所有可能的字符数,因为 s 和 p 仅包含小写字母，所以 Σ=26。
 * 空间复杂度:O(Σ),用于存储字符串 p 和滑动窗口中每种字母的数量。
 */
class Solution{
    public List<Integer> findAnagrans(String s, String p){
        int sLen = s.length(), pLen = p.length();
        if(sLen < pLen){
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i = 0; i < pLen; ++i){
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if(Arrays.equals(sCount, pCount)){
            ans.add(0);
        }
        for(int i = 0; i < sLen - pLen; ++i){
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if(Arrays.equals(sCount, pCount)){
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
