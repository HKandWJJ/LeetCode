package Array0041_firstMissingPositive;

/**
 * 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * ********************************************************
 * 思路总结:
 * 1. 首先，遍历数组，将所有小于等于 0 的数都替换为数组长度加 1，这样做的目的是为了将所有的负数都转化为正数，方便后续处理。
 * 2. 接下来，再次遍历数组，对于每个数 num，取其绝对值，并将其对应的数组下标 num-1 处的数变为负数，这样做的目的是为了标记数组中存在 num 这个数。
 * 3. 最后，再次遍历数组，找到第一个正数的下标 i，返回 i+1 即可，因为 i+1 就是缺失的第一个正数。
 * 4. 如果数组中不存在正数，那么返回数组长度加 1。
 * ********************************************************
 * 时间复杂度：O(n)，其中 n 是数组的长度。
 * 空间复杂度：O(1)。
 */
class Solution{
    public int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for(int i = 0; i < n; i++){
            int num = Math.abs(nums[i]);
            if(num <= n){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}
