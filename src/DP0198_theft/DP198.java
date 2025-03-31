package DP0198_theft;

/**
 * 打家劫舍:每间房内都藏有一定的现金，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。计算一夜之内能够偷窃到的最高金额。
 * **************************************************************************************************
 * 思路总结：如果只有一间房屋，则偷窃该房屋。如果只有两间房屋，则由于两间房屋相邻，选择其中金额较高的房屋，
 * 如果房屋数量大于两间：
 * 1.偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和。
 * 2.不偷窃第 k 间房屋，偷窃总金额为前 k−1 间房屋的最高总金额。
 * **************************************************************************************************
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for(int i =2; i < length; i++){
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
