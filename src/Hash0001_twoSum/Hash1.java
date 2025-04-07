package Hash0001_twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * ****************************************************************************************************
 * 思路总结:
 * 1. 遍历数组，将数组中的元素作为键，数组的下标作为值存入哈希表中
 * 2. 遍历数组，判断哈希表中是否存在 target - nums[i] 的键
 * 3. 如果存在，返回哈希表中 target - nums[i] 的值和当前数组的下标
 * 4. 如果不存在，将当前数组的元素作为键，数组的下标作为值存入哈希表中
 * ****************************************************************************************************
 * 时间复杂度：O(n)，其中 n 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
 * 空间复杂度：O(n)，其中 n 是数组中的元素数量。主要为哈希表的开销。
 */
class Solution {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
