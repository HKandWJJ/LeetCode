package Hash0049_groupAnagrams;

import java.util.*;

/**
 * 字母异位词分组：
 * 给你一个字符串数组，请你将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * **********************************************************************
 * 思路总结:
 * 1. 遍历字符串数组，将每个字符串的字符数组排序，然后将排序后的字符数组作为键，字符串作为值存入哈希表中
 * 2. 遍历哈希表，将哈希表中的值存入结果列表中
 * **********************************************************************
 * 时间复杂度：O(nklogk)，其中 n 是字符串数组中的字符串的数量，k 是字符串的最大长度。
 *      需要遍历 n 个字符串，对于每个字符串，需要 O(klogk) 的时间进行排序以及 O(1) 的时间更新哈希表，因此总时间复杂度是 O(nklogk)。
 * 空间复杂度：O(nk)，其中 n 是字符串数组中的字符串的数量，k 是字符串的最大长度。需要用哈希表存储全部字符串。
 */
class Solution{
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
