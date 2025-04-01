package DP0416_canPartition;

/**
 * 分割等和子集：给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * *********************************************************************
 * 思路总结：
 * 计算数组 nums 的元素和 sum，如果 sum 是奇数，则无法将数组分割成两个子集，使得两个子集的元素和相等，直接返回 false。
 * 计算数组 nums 的元素和的一半 target，如果数组中最大的元素 maxNum 大于 target，则无法找到满足条件的子集，直接返回 false。
 * 创建一个长度为 target + 1 的布尔数组 dp，用于存储是否存在一个子集的元素和等于当前的下标。
 * 初始化 dp[0] 为 true，表示空子集的元素和为 0。
 * 遍历数组 nums 中的每个元素 num:
 * 从 target 开始递减到 num，对于每个下标 j，更新 dp[j] 的值为 dp[j] 或 dp[j - num] 的逻辑或。
 * 最终返回 dp[target]，如果为 true，则说明存在一个子集的元素和等于 target，即可以将数组分割成两个子集，使得两个子集的元素和相等。
 * *********************************************************************
 * 时间复杂度：O(n * target)，其中 n 是数组 nums 的长度，target 是数组 nums 的元素和的一半。
 * 空间复杂度：O(target)，需要额外的空间来存储 dp 数组。
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return false;
        }
        int sum = 0, maxNum = 0;
        for(int num : nums){
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        if(maxNum > target){
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            for(int j = target; j >= num; --j){
                dp[j] = dp[j] | dp[j - num];
            }
        }
        return dp[target];
    }
}
