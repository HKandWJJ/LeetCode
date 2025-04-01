package DP0300_lengthOfLIS;

/**
 * 最长递增子序列：给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * *********************************************************************
 * 思路总结:
 * 构建一个与输入数组长度相同的 dp 数组，用于存储以每个元素结尾的最长递增子序列的长度。
 * 把 dp[0] 初始化为 1，这是因为以第一个元素结尾的最长递增子序列长度必然是 1。
 * 初始化 maxans 为 1，用于记录整个数组中最长递增子序列的长度.
 * 从数组的第二个元素开始遍历，针对每个元素 nums[i]：先把 dp[i] 初始化为 1，这是因为以该元素结尾的递增子序列最短长度为 1。
 * 遍历 i 之前的所有元素 nums[j]（0 <= j < i）：若 nums[i] > nums[j]，
 * 表明可以把 nums[i] 接在以 nums[j] 结尾的递增子序列后面，从而形成一个更长的递增子序列。此时更新 dp[i] 为 dp[i] 和 dp[j] + 1 中的较大值。
 * 每次更新 dp[i] 之后，将 maxans 更新为 maxans 和 dp[i] 中的较大值。最终返回 maxans
 * *********************************************************************
 * 时间复杂度：O(n^2)，其中 n 是数组 nums 的长度。
 * 空间复杂度：O(n)，需要额外的空间来存储 dp 数组。
 */
class Solution_DP {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}

/**
 * 贪心+二分查找：
 * 构建一个数组 d[i]，表示长度为 i 的最长递增子序列的末尾元素的最小值。
 * 初始化 len 为 1，d[1] = nums[0]。
 * 从数组的第二个元素开始遍历，针对每个元素 nums[i]：
 * 如果 nums[i] > d[len]，则直接将 nums[i] 接在 d 数组的末尾，即 d[++len] = nums[i]。
 * 如果 nums[i] <= d[len]，则在 d 数组中找到第一个大于等于 nums[i] 的元素 d[pos]，并将 d[pos + 1] 更新为 nums[i]。
 * 最终返回 len 作为最长递增子序列的长度。
 * *********************************************************************
 * 时间复杂度：O(nlogn)，其中 n 是数组 nums 的长度。
 * 空间复杂度：O(n)，需要额外的空间来存储 d 数组。
 */
class Solution_Greedy {
    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for(int i = 1; i < n; ++i){
            if(nums[i] > d[len]){
                d[++len] = nums[i];
            }else{
                int l = 1, r = len, pos = 0;
                while(l <= r){
                    int mid = (l + r) >> 1;
                    if(d[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}