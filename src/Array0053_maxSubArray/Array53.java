package Array0053_maxSubArray;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * ****************************************************************************
 * 思路总结:
 * pre 用于记录以当前元素结尾的连续子数组的最大和，maxAns 用于记录全局最大和。
 * 遍历数组，对于每个元素，计算以当前元素结尾的连续子数组的最大和，更新 pre 和 maxAns。
 * 最后返回 maxAns 作为结果。
 * ******************************************************************************
 * 时间复杂度: O(n)，其中 n 是数组的长度。
 * 空间复杂度: O(1)，只使用了常数级别的额外空间。
 */
class Solution {
    public int maxSubArray(int[] nums){
        int pre = 0, maxAns = nums[0];
        for(int num : nums){
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
