package Greedy0763_partitionLabels;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间：字符串S由小写字母组成，要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * ***************************************************************************************************************
 * 思路总结：
 * 1. 贪心算法：每次选择能包含的最远的位置
 * 2. 维护一个数组last，记录每个字母最后出现的位置
 * 3. 维护一个变量end，表示当前能包含的最远位置
 * 4. 维护一个变量start，表示当前片段的起始位置
 * 5. 遍历字符串，更新end为当前字母最后出现的位置
 * 6. 当遍历到end时，更新start为end+1，将当前片段的长度加入结果列表
 * 7. 最后返回结果列表
 * ***************************************************************************************************************
 * 时间复杂度：O(n), 其中n为字符串的长度，需要遍历字符串两次，第一次遍历时记录每个字母最后一次出现的下标位置，第二次遍历时进行字符串划分
 * 空间复杂度：O(|E|)，其中E是字符串中的字符集，这道题中字符串只包含小写字母，因此|E|=26
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for(int i = 0; i < length; i++){
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for(int i = 0; i < length; i++){
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i == end){
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
