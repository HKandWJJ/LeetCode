package TP0015_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和:
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 *      满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * ************************************************************************************
 * 思路总结:
 * 1. 排序 + 双指针:
 *  1.1 对数组进行排序
 *  1.2 遍历数组, 对于每个元素, 用双指针法找到所有和为0的三元组
 *  1.3 为了避免重复, 跳过相同的元素
 *  1.4 返回所有和为0的三元组
 *  ********************************************************************************
 * 2. 时间复杂度: O(n^2)
 * 3. 空间复杂度: O(1)
 */
class Solution{
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = n - 1;
            int target = -nums[i];
            for(int k = i + 1; k < n; k++){
                if(k > i + 1 && nums[k] == nums[k - 1]){
                    continue;
                }
                while(k < j && nums[k] + nums[j] > target){
                    --j;
                }
                if(k == j){
                    break;
                }
                if(nums[k] + nums[j] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
