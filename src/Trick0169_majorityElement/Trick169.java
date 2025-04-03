package Trick0169_majorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素:给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * *******************************************************************************************
 * 思路总结:
 * 哈希表: 遍历数组, 统计每个元素出现的次数, 最后返回出现次数最多的元素
 * *******************************************************************************************
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
class Solution_Map {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
}

/**
 * 排序: 数组排序后, 中间的元素一定是多数元素
 * ***********************************
 * 时间复杂度:O(nlogn)
 * 空间复杂度:O(logn)
 */
class Solution_sort {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/**
 * Boyer-Moore 投票算法:
 * 维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
 * 遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
 * 如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
 * 如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
 * 在遍历完成后，candidate 即为整个数组的多数元素。
 * ***********************************
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
