package DP0152_maxProduct;

/**
 * 乘积最大子数组:给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * *********************************************************************
 * 思路总结:
 * 遍历数组，用 maxF 来表示以第 i 个元素结尾的乘积最大子数组的乘积，用 minF 表示以第 i 个元素结尾的乘积最小子数组的乘积。
 * 初始化 maxF 和 minF 均为 nums[0]。
 * 从数组的第二个元素开始遍历，针对每个元素 nums[i]：
 * 计算以第 i 个元素结尾的乘积最大子数组的乘积 maxF，它可以是当前元素nums[i] 或nums[i]乘以之前的最大乘积或nums[i]乘以之前的最小乘积（考虑负数）
 * 计算以第 i 个元素结尾的乘积最小子数组的乘积 minF，它可以是 nums[i] 本身，或nums[i]乘以之前的最小乘积或nums[i]乘以之前的最大乘积（考虑负数）
 * 每次更新 maxF 和 minF 之后，将 ans 更新为 ans 和 maxF 中的较大值。
 * 最终返回 ans 作为乘积最大子数组的乘积。
 * *********************************************************************
 * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。
 * 空间复杂度：O(1)，只需要常数的空间来存储若干变量。
 */
class Solution {
    public int maxProduct(int[] nums) {
        long maxF = nums[0], minF = nums[0];
        int ans = nums[0];
        int length = nums.length;
        for(int i = 1; i < length; ++i){
            long mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            if(minF < -1 << 31){
                minF = nums[i];
            }
            ans = Math.max((int)maxF, ans);
        }
        return ans;
    }
}
